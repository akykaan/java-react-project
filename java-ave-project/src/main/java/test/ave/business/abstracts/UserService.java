package test.ave.business.abstracts;

import java.security.NoSuchAlgorithmException;
import java.util.Dictionary;
import java.util.List;

import test.ave.entities.concretes.User;
import test.ave.entities.dtos.LoginDto;

public interface UserService {
	String add(User user);
	
	Dictionary<String, Integer> login(LoginDto loginDto) throws NoSuchAlgorithmException;
	// String login(LoginDto loginDto) throws NoSuchAlgorithmException;
	List<User> getAllUser();
	
}
