package zoolpon.project.rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import zoolpon.project.entities.CustomLogin;
import zoolpon.project.entities.Login;
import zoolpon.project.exceptions.InvalidLoginException;
import zoolpon.project.services.LoginService;

@RestController
@RequestMapping("Login")
@Validated
public class LoginWebService {

	@Autowired
	private LoginService loginService;

	@Autowired
	Logger logger;

	@PostMapping
	public boolean Login(@RequestBody Login login, HttpServletRequest request, HttpServletResponse response) {

		try {
			CustomLogin customLogin = loginService.login(login);
			HttpSession session = request.getSession();
			session.setAttribute("FACADE", customLogin);
			logger.info(login.getUserName() + "Just logged in.");
			return true;
		} catch (InvalidLoginException e) {
			logger.info("Something went wrong , might be wrong userName or password.");
			return false;
		}

	}

	@GetMapping
	public boolean logOut(HttpServletRequest request, HttpServletResponse response) {
		try {
			HttpSession session = request.getSession(false);
			session.invalidate();
			logger.info("logout succesfully.");
			return true;

		} catch (Exception e) {
			return false;
		}

	}
}
