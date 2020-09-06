package zoolpon.project.rest;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import zoolpon.project.entities.Client;
import zoolpon.project.entities.User;
import zoolpon.project.services.AdminService;
import zoolpon.project.services.UserService;

@RestController
@RequestMapping("systemProject/Admin")
@Validated
public class AdminWebService {

	@Autowired
	AdminService adminService;

	@Autowired
	UserService userService;

	@Autowired
	Logger logger;

	@RequestMapping(path = "createUser", method = RequestMethod.POST)
	public User createUser(@RequestBody User user) {

		logger.info("User : " + user.getUserName() + "Just joined the system.");
		return adminService.createUser(user);
	}

	@RequestMapping(path = "generateCode", method = RequestMethod.GET)
	public String Generated() {
		return generateCode();
	}

	@RequestMapping(path = "inActive/{userId}", method = RequestMethod.GET)
	public void inActiveUser(@PathVariable long userId) {
		adminService.inActiveUser(userId);
	}

	@RequestMapping(path = "active/{userId}", method = RequestMethod.GET)
	public void activeUser(@PathVariable long userId) {

		adminService.activeUser(userId);
	}

	@RequestMapping(path = "getAllUsers", method = RequestMethod.GET)
	public List<User> getAllUsers() {

		return adminService.getAllUsers();
	}

	@RequestMapping(path = "createClient", method = RequestMethod.POST)
	public Client createClient(@RequestBody Client client) {
		return adminService.createClient(client);
	}

	@RequestMapping(path = "removeClient/{clientId}", method = RequestMethod.DELETE)
	public void removeClient(@PathVariable long clientId) {

		adminService.removeClient(clientId);
	}

	@RequestMapping(path = "getAllClients", method = RequestMethod.GET)
	public List<Client> getAllClients() {

		return adminService.getAllClients();
	}

	@RequestMapping(path = "verified/{clientId}")
	public void verified(@PathVariable long clientId) {
		adminService.verified(clientId);

	}

	public static int Random() {

		return (int) (Math.random() * 10 + 0);

	}

	public static String generateCode() {

		String newCode = "";

		for (int i = 0; i < 10; i++) {

			String code = Integer.toString(Random());
			newCode += code;

		}

		return newCode;

	}

}
