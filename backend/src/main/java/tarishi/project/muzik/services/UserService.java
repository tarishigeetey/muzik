package tarishi.project.muzik.services;

import java.util.UUID;

import tarishi.project.muzik.model.User;

public interface UserService {
	public User saveUser(String email);
	public boolean doesUserExist(UUID userId);
}
