package tarishi.project.muzik.services.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import tarishi.project.muzik.model.User;
import tarishi.project.muzik.repository.UserRepository;
import tarishi.project.muzik.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	private final UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository){
		this.userRepository = userRepository;
	}

	@Override
	public User saveUser(String email) {
		if (email == null || email.isBlank()) {
			throw new IllegalArgumentException("Email cannot be null or empty");
		}
		return userRepository.findByEmail(email).orElseGet(() -> createUser(email));
	}
	
	private User createUser(String email) {
		User user = new User();
		user.setEmail(email);
		return userRepository.save(user);
	}
	
	public boolean doesUserExist(UUID userId) {
        // query the database to check if the user exists
        return userRepository.existsById(userId);
    }
}
