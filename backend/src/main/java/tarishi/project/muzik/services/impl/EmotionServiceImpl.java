package tarishi.project.muzik.services.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import tarishi.project.muzik.model.EmotionType;
import tarishi.project.muzik.model.Emotion;
import tarishi.project.muzik.repository.EmotionRepository;
import tarishi.project.muzik.services.EmotionService;

@Service
public class EmotionServiceImpl implements EmotionService {

	private final EmotionRepository emotionRepository;

    public EmotionServiceImpl(EmotionRepository emotionRepository) {
        this.emotionRepository = emotionRepository;
    }

    @Override
    public UUID getEmotionId(EmotionType emotion) {
        Emotion retrievedEmotion = emotionRepository.findByEmotion(emotion)
                .orElseThrow(() -> new IllegalArgumentException("Emotion not found"));

        return retrievedEmotion.getId();
    }
}
