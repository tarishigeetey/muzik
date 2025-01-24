package tarishi.project.muzik.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tarishi.project.muzik.model.Genre;

import java.util.List;
import java.util.UUID;

@Repository
public interface GenreRepository extends JpaRepository<Genre, UUID> {
    @Query("SELECT g FROM Genre g WHERE g.mood.id = :mood_id")
    List<Genre> findGenresByMood(@Param("mood_id") UUID moodId);
}