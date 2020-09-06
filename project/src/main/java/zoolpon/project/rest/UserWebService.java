package zoolpon.project.rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import zoolpon.project.entities.Client;
import zoolpon.project.entities.CustomLogin;
import zoolpon.project.repositories.ClientRepository;
import zoolpon.project.services.UserService;

@RestController
@RequestMapping("systemProject/User")
@Validated
public class UserWebService {

	@Autowired
	UserService userService;

	@Autowired
	private HttpServletRequest request;

	@Autowired
	ClientRepository clientRepository;

	@Autowired
	Logger logger;

	public CustomLogin getFacade() {
		HttpSession session = request.getSession(false);
		return (CustomLogin) session.getAttribute("FACADE");
	}

	@RequestMapping(path = "getCode/{phoneNumber}", method = RequestMethod.GET)
	public String getCode(@PathVariable String phoneNumber) {
		Client client = clientRepository.findByPhoneNumber(phoneNumber);

		String[] companies = getFacade().getCompany();

		for (String string : companies) {

			if (client.getCompany().equals(string)) {

				return client.getCode();
			}
		}

		logger.info("Something went wrong , Invalid phone number.");
		return null;
	}

}
