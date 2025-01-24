package tarishi.project.muzik.services;

import java.util.UUID;

import tarishi.project.muzik.model.Users;

public interface UserService {
	public Users saveUser(String email);
	public boolean doesUserExist(UUID userId);
}
