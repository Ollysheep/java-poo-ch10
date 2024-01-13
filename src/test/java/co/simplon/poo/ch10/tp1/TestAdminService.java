package co.simplon.poo.ch10.tp1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import co.simplon.poo.ch10.tp1.model.User;
import co.simplon.poo.ch10.tp1.repository.UserRepository;
import co.simplon.poo.ch10.tp1.repository.impl.UserRepositoryJson;
import co.simplon.poo.ch10.tp1.service.UserService;
import co.simplon.poo.ch10.tp1.service.impl.AdminServiceImpl;
import co.simplon.poo.ch10.tp1.service.impl.UserServiceImpl;

public class TestAdminService {
	
	private UserRepositoryJson users = new UserRepositoryJson("data/json/users.json");
	private UserService userService = new UserServiceImpl(users);
	private AdminServiceImpl adminService = new AdminServiceImpl(users);
	
	@Test
	void testResetAndSendNewPassword() throws Exception {
		
		// 10 fake users creation
		for (int i = 1; i < 10; i++) {
			users.create(new User("user" + i, "passworduser" + i, "user" + i + "@gmail.com", true));
		}
		
		// Retrieve first fake user named user1
		User user1 = users.getByLogin("user1");

		//calling service method
		adminService.resetAndSendNewPassword(user1.getId());
		
		//Controlling
		assertNotEquals(user1.getPassword(), ("passworduser"));		
		
	}
	
	@Test
	void testDisableUser() throws Exception {
		
		// 10 fake users creation
		for (int i = 1; i < 10; i++) {
			users.create(new User("user" + i, "passworduser" + i, "user" + i + "@gmail.com", true));
		}
		
		// Retrieve first fake user named user1
		User user1 = users.getByLogin("user1");

		//calling service method
		adminService.disableUser(user1.getId());
		
		//Controlling
		assertFalse(user1.isEnable());
		
	}
	
	@Test
	void testEnableUser() throws Exception {
		
		// 10 fake users creation
		for (int i = 1; i < 10; i++) {
			users.create(new User("user" + i, "passworduser" + i, "user" + i + "@gmail.com", true));
		}
		
		// Retrieve first fake user named user1
		User user1 = users.getByLogin("user1");

		//calling service method
		adminService.enableUser(user1.getId());
		
		//Controlling
		assertTrue(user1.isEnable());
		
	}

}
