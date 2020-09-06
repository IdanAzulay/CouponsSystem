package zoolpon.project.services;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import zoolpon.project.entities.CustomLogin;
import zoolpon.project.entities.Login;
import zoolpon.project.entities.User;
import zoolpon.project.repositories.ClientRepository;
import zoolpon.project.repositories.UserRepository;

@Service
@Validated
public class userServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	ClientRepository clientRepository;

	@Autowired
	Logger logger;

	public boolean Login(Login login) {

		List<User> allUsers = userRepository.findAll();
		for (User user : allUsers) {
			if (user.getUserName().equals(login.getUserName()) && user.getPassword().equals(login.getPassword())
					&& user.isActive() == true) {
				logger.info("User : " + user.getUserName() + " has logged in successfully");
				return true;
			}
		}
		return false;
	}

	public CustomLogin CustomLogin(String userName, String password) {
		User user = userRepository.findByUserNameAndPassword(userName, password);
		return new CustomLogin(user.getId(), user.getCompanies());

	}

}
