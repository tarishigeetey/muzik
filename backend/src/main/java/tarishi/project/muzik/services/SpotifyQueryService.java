package tarishi.project.muzik.services;

import tarishi.project.muzik.model.Track;

import java.util.List;

public interface SpotifyQueryService {
	public String getSpotifyPlaylistId(List<String> genreList, String accessToken);
    public List<Track> getSpotifyTracks(String playlistId, String accessToken);
}