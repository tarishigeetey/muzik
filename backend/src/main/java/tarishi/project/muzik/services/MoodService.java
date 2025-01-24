package tarishi.project.muzik.services;

import java.util.UUID;
import java.util.List;

public interface MoodService {
    public List<UUID> getAllMoodIds(UUID emotionId);
}