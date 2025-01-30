package tarishi.project.muzik.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import tarishi.project.muzik.model.EmotionType;
import tarishi.project.muzik.model.ErrorResponse;
import tarishi.project.muzik.model.Track;
import tarishi.project.muzik.services.impl.*;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class TrackController {

    private final EmotionRecognitionServiceImpl emotionRecognitionServiceImpl;
    private final EmotionServiceImpl emotionServiceImpl;
    private final MoodServiceImpl moodServiceImpl;
    private final GenreServiceImpl genreServiceImpl;
    private final SpotifyQueryServiceImpl spotifyQueryServiceImpl;
    private final StringRedisTemplate redisTemplate;

    public TrackController(EmotionRecognitionServiceImpl emotionRecognitionServiceImpl,
                           EmotionServiceImpl emotionServiceImpl,
                           MoodServiceImpl moodServiceImpl,
                           GenreServiceImpl genreServiceImpl,
                           SpotifyQueryServiceImpl spotifyQueryServiceImpl,
                           StringRedisTemplate redisTemplate) {
        this.emotionRecognitionServiceImpl = emotionRecognitionServiceImpl;
        this.emotionServiceImpl = emotionServiceImpl;
        this.moodServiceImpl = moodServiceImpl;
        this.genreServiceImpl = genreServiceImpl;
        this.spotifyQueryServiceImpl = spotifyQueryServiceImpl;
        this.redisTemplate = redisTemplate;
    }

    @GetMapping("/get-tracks")
    public ResponseEntity<?> getTracks(
            @RequestParam(value = "submission") String input,
            @RequestParam(value = "userId") String userId) {

        String accessToken = redisTemplate.opsForValue().get("spotify:user-access:" + userId);


        boolean waitForModel = false;

        // validate if access token is present and not expired
        if (accessToken == null) {
            return new ResponseEntity<>(new ErrorResponse("Unauthorized access."), HttpStatus.UNAUTHORIZED);
        }

        // validate incoming client-side data
        if (!isValidInput(input)) {
            return new ResponseEntity<>(new ErrorResponse("Invalid request."), HttpStatus.BAD_REQUEST);
        }

        // check if model is ready
        if (!emotionRecognitionServiceImpl.isModelReady()) {
            // if not ready, indicate that we need to set wait-for-model flag = true
            waitForModel = true;
        }

        try {
            // transform input to emotion
            EmotionType emotionName = EmotionType.valueOf(emotionRecognitionServiceImpl.analyze(input, waitForModel));
            UUID emotionId = emotionServiceImpl.getEmotionId(emotionName);

            // get moods based on emotion
            List<UUID> moodIds = moodServiceImpl.getAllMoodIds(emotionId);

            // get genres based on moods
            List<String> genreNames = genreServiceImpl.getAllGenre(moodIds);

            // get playlist id based on genres
            String randomPlaylistId = spotifyQueryServiceImpl.getSpotifyPlaylistId(genreNames, accessToken);

            // get tracks based on playlist id
            List<Track> tracksList = spotifyQueryServiceImpl.getSpotifyTracks(randomPlaylistId, accessToken);

            return new ResponseEntity<>(tracksList, HttpStatus.OK);

        }  catch (JsonProcessingException e) {
            return new ResponseEntity<>(new ErrorResponse("JsonProcessingException error: " + e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        } catch (RuntimeException e) {
            return new ResponseEntity<>(new ErrorResponse("RuntimeException error: " + e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }

    private boolean isValidInput(String input) {
        return input != null && input.length() > 2;

    }
}