package tarishi.project.muzik.services;

import jakarta.servlet.http.HttpSession;
import tarishi.project.muzik.model.Track;

import java.util.List;

public interface SpotifyQueryService {
    public String getSpotifyPlaylistId(List<String> genreList, HttpSession session);
    public List<Track> getSpotifyTracks(String playlistId, HttpSession session);
}