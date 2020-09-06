package zoolpon.project.services;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

import zoolpon.project.entities.Client;
import zoolpon.project.entities.User;

public interface AdminService {

	void verified(@Positive long clientId);

	User createUser(@Valid User user);

	void inActiveUser(@Positive long userId);

	void activeUser(@Positive long userId);

	List<User> getAllUsers();

	Client createClient(@Valid Client client);

	void removeClient(@Positive long clientId);

	List<Client> getAllClients();

}
