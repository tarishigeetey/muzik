package tarishi.project.muzik.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tarishi.project.muzik.model.EmotionType;
import tarishi.project.muzik.model.Emotion;

@Repository
public interface EmotionRepository extends JpaRepository<Emotion, UUID> {
    @Query("SELECT e FROM Emotion e WHERE e.emotion = :emotion")
    Optional<Emotion> findByEmotion(@Param("emotion") EmotionType emotion);
}
