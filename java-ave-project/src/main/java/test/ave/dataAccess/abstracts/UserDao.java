package test.ave.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import test.ave.entities.concretes.User;

public interface UserDao extends JpaRepository<User, Integer> {
	User findByEmail(String email);
	
	
}
