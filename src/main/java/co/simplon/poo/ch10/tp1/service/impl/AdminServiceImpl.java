package co.simplon.poo.ch10.tp1.service.impl;

import java.util.List;

import co.simplon.poo.ch10.tp1.model.User;
import co.simplon.poo.ch10.tp1.repository.UserRepository;
import co.simplon.poo.ch10.tp1.service.AdminService;
import co.simplon.poo.ch10.tp1.utils.communication.FakeMailUtil;
import co.simplon.poo.ch10.tp1.utils.security.PasswordTools;

public class AdminServiceImpl implements AdminService {
	
	private final UserRepository users;

	public AdminServiceImpl(UserRepository users) {
		this.users = users;
	}

	@Override
	public List<User> findAllUsers() {
		return users.retrieve();
	}

	@Override
	public void resetAndSendNewPassword(String userId) {
		User user = users.getById(userId);
		if (user != null) {
			String newPassword = PasswordTools.generateRandomPassword();
			user.setPassword(newPassword);
			FakeMailUtil.sendFakeEmail(user.getEmail(), "Réintialisation de votre mot de passe",  "Votre nouveau mot de passe est :" + newPassword);
		}
	}

	@Override
	public void disableUser(String userId) throws Exception {
		User user = users.getById(userId);
		if (user != null) {
			user.setEnable(false);
		}

	}

	@Override
	public void enableUser(String userId) throws Exception {
		User user = users.getById(userId);
		if (user != null) {
			user.setEnable(true);
		}

	}

}
