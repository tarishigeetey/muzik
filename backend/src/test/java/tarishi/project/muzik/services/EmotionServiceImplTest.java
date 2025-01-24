package tarishi.project.muzik.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import tarishi.project.muzik.model.Emotion;
import tarishi.project.muzik.model.EmotionType;
import tarishi.project.muzik.repository.EmotionRepository;
import tarishi.project.muzik.services.impl.EmotionServiceImpl;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EmotionServiceImplTest {

    @Mock
    private EmotionRepository emotionRepository;

    @InjectMocks
    private EmotionServiceImpl emotionService;

    @Test
    public void getEmotionId_existingEmotion_returnsEmotionId() {
        // Arrange
        Emotion emotion = Emotion.builder()
                .emotion(EmotionType.valueOf("sadness"))
                .build();

        when(emotionRepository.findByEmotion(EmotionType.sadness)).thenReturn(Optional.ofNullable(emotion));

        // Act
        UUID retrievedId = emotionService.getEmotionId(EmotionType.sadness);

        // Assert
        assertEquals(emotion.getId(), retrievedId);
    }

}