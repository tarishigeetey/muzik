package tarishi.project.muzik.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import tarishi.project.muzik.model.Users;

import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface UserRepository extends JpaRepository<Users, UUID> {
    Optional<Users> findByEmail(String email);
    boolean existsById(UUID userId);
}