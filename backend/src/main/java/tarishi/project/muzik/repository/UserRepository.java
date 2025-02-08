package tarishi.project.muzik.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import tarishi.project.muzik.model.User;

import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByEmail(String email);
    boolean existsById(UUID userId);
}