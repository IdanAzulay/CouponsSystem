package zoolpon.project.services;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import zoolpon.project.entities.Client;
import zoolpon.project.entities.Login;
import zoolpon.project.entities.User;
import zoolpon.project.repositories.ClientRepository;
import zoolpon.project.repositories.UserRepository;

@Service
@Validated
public class adminServiceImpl implements AdminService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	ClientRepository clientRepository;

	@Autowired
	Logger Logger;

	public boolean Login(Login login) {

		if (login.getUserName().equals("admin") && login.getPassword().equals("1234")) {
			Logger.info("Admin has logged in successfully.");

			return true;
		} else {
			return false;
		}
	}

	@Override
	public User createUser(@Valid User user) { // Throw Exception - Invalid user.

		Logger.info("New user just joined the system , userName: " + user.getUserName());

		return userRepository.save(user);
	}

	@Override
	public void inActiveUser(@Positive long userId) {

		try {

			User user = userRepository.findById(userId).get();
			if (user.isActive()) {
				user.setActive(false);
				userRepository.save(user);
			}

		} catch (Exception e) {

			// throw System exception.
		}

	}

	@Override
	public void activeUser(@Positive long userId) {

		try {

			User user = userRepository.findById(userId).get();
			if (!user.isActive()) {
				user.setActive(true);
				userRepository.save(user);
			}

		} catch (Exception e) {
			// throw system exception.
		}

	}

	@Override
	public List<User> getAllUsers() {

		try {
			Logger.info("Admin called getAllUser Method : ");
			return userRepository.findAll();
		} catch (Exception e) {

			// throw systemException.

		}

		return null;
	}

	@Override
	public Client createClient(@Valid Client client) { // Throw exception - Invalid Client.

		client.setStart_time(Calendar.getInstance());
		client.setCompany(client.getCompany());

		int A = client.getStart_time().get(Calendar.MINUTE);
		Calendar calendar = GregorianCalendar.getInstance();

		calendar.set(Calendar.MINUTE, A + 5);

		client.setExpire_time(calendar);
		Logger.info("New client just joined the system.");

		return clientRepository.save(client);

	}

	@Override
	public void removeClient(@Positive long clientId) {

		try {
			clientRepository.deleteById(clientId);
			Logger.info("Client just removed from the system.");

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Override
	public List<Client> getAllClients() {

		try {
			Logger.info("Admin called getAllClients method.");
			return clientRepository.findAll();
		} catch (Exception e) {

		}
		return null;

	}

	@Override
	public void verified(@Positive long clinetId) {

		try {
			Client client = clientRepository.findById(clinetId).get();
			client.setVerified(true);
			clientRepository.save(client);
		} catch (Exception e) {
			// Throw systemException.
		}

	}
}
