package tarishi.project.muzik.services;

import java.util.List;
import java.util.UUID;

public interface GenreService {
    public List<String> getAllGenre(List<UUID> moodIdList);
}
