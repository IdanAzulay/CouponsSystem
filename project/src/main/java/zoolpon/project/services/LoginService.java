package zoolpon.project.services;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zoolpon.project.entities.CustomLogin;
import zoolpon.project.entities.Login;
import zoolpon.project.exceptions.InvalidLoginException;

@Service
public class LoginService {

	@Autowired
	private userServiceImpl userServiceImpl;

	@Autowired
	private adminServiceImpl adminServiceImpl;

	@Autowired
	Logger logger;

	public CustomLogin login(Login login) throws InvalidLoginException {

		if (userServiceImpl.Login(login)) {
			return userServiceImpl.CustomLogin(login.getUserName(), login.getPassword());
		}
		if (adminServiceImpl.Login(login)) {
			String[] admin = { "admin" };
			return new CustomLogin(1, admin);
		} else {
			throw new InvalidLoginException();
		}
	}

}
