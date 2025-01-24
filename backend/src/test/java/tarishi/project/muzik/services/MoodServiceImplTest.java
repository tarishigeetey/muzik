package tarishi.project.muzik.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import tarishi.project.muzik.model.Emotion;
import tarishi.project.muzik.model.EmotionType;
import tarishi.project.muzik.model.Mood;
import tarishi.project.muzik.repository.EmotionRepository;
import tarishi.project.muzik.repository.MoodRepository;
import tarishi.project.muzik.services.impl.MoodServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MoodServiceImplTest {

    @Mock
    private MoodRepository moodRepository;

    @Mock
    private EmotionRepository emotionRepository;

    @InjectMocks
    private MoodServiceImpl moodService;

    @Test
    public void getAllMoodIds_validEmotionId_returnsListOfMoodIds() {
        // Arrange
        Emotion emotion = Emotion.builder()
                .id(UUID.randomUUID())
                .emotion(EmotionType.valueOf("sadness"))
                .build();

        Mood mood1 = Mood.builder()
                .id(UUID.randomUUID())
                .mood("sad")
                .emotion(emotion)
                .build();

        Mood mood2 = Mood.builder()
                .id(UUID.randomUUID())
                .mood("nostalgic")
                .emotion(emotion)
                .build();

        when(moodRepository.findMoodsByEmotion(emotion.getId())).thenReturn(List.of(mood1, mood2));
        List<UUID> exepctedMoodIdList = List.of(mood1.getId(), mood2.getId());

        // Act
        List<UUID> actualMoodIdList = moodService.getAllMoodIds(emotion.getId());

        // Assert
        assertEquals(2, actualMoodIdList.size());
        assertArrayEquals(exepctedMoodIdList.toArray(), actualMoodIdList.toArray());
    }

    @Test
    public void getAllMoodIds_invalidEmotionId_returnsEmptyList() {
        // Arrange
        List<UUID> expectedMoodIdList = List.of();

        // Act
        List<UUID> actualMoodIdList = moodService.getAllMoodIds(UUID.randomUUID());

        // Assert
        assertEquals(0, actualMoodIdList.size());
        assertArrayEquals(expectedMoodIdList.toArray(), actualMoodIdList.toArray());
    }
}
