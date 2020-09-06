package zoolpon.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import zoolpon.project.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

	Client findByPhoneNumber(String phoneNumber);
	
	
}
