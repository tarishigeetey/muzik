package tarishi.project.muzik.services;

import java.util.UUID;

import tarishi.project.muzik.model.EmotionType;

public interface EmotionService {
	public UUID getEmotionId(EmotionType emotion);
}
