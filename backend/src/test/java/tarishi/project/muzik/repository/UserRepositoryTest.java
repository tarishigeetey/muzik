package tarishi.project.muzik.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import tarishi.project.muzik.model.Users;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findByEmail_validEmail_returnsUser() {
        // Arrange
        Users user = Users.builder()
                .email("test@xyz.com")
                .build();

        userRepository.save(user);

        // Act
        Optional<Users> foundUser = userRepository.findByEmail("test@xyz.com");

        // Assert
        assertTrue(foundUser.isPresent());
        assertEquals(user, foundUser.get());
    }

    @Test
    public void findByEmail_invalidEmail_returnsEmptyOptional() {
        // Arrange
        Users user = Users.builder()
                .email("test@xyz.com")
                .build();

        userRepository.save(user);

        // Act
        Optional<Users> result1 = userRepository.findByEmail("testing@xyz.com");
        Optional<Users> result2 = userRepository.findByEmail("");

        // Assert
        assertFalse(result1.isPresent());
        assertFalse(result2.isPresent());
    }

}
