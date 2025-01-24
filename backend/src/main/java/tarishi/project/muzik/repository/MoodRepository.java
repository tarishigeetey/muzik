package tarishi.project.muzik.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tarishi.project.muzik.model.Mood;

@Repository
public interface MoodRepository extends JpaRepository<Mood, UUID> {

	@Query("SELECT m FROM Mood m WHERE m.emotion.id = :emotion_id")
	List<Mood> findMoodsByEmotion(@Param("emotion_id") UUID emotionId);
}
