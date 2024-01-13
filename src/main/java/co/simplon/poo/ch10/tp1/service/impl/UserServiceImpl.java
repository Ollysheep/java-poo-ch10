package co.simplon.poo.ch10.tp1.service.impl;

import co.simplon.poo.ch10.tp1.model.User;
import co.simplon.poo.ch10.tp1.repository.UserRepository;
import co.simplon.poo.ch10.tp1.service.UserService;

public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	public UserServiceImpl(UserRepository users) {
		this.userRepository = users;
	}

	@Override
	public void changeMyPassword(String userId, String oldPass, String newPass) throws Exception {
		User targetUser = userRepository.getById(userId);

		// Pourquoi ce n'est pas safe de faire comme çà, avec le mot de passe en clair
		// ????? Comment devra t-on faire plus tard ?
		if (targetUser.getPassword().equals(oldPass)) {
			targetUser.setPassword(newPass);
			userRepository.update(targetUser, userId);
		} else
			throw new Exception("bad old password");
	}

	@Override
	public void changeMyEmail(String userId, String newEmail) {
		User targetUser = userRepository.getById(userId);
		targetUser.setEmail(newEmail);
	}

}
