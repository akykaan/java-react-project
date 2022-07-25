package test.ave.api.controllers;

import java.security.NoSuchAlgorithmException;
import java.util.Dictionary;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import test.ave.business.abstracts.UserService;
import test.ave.entities.concretes.User;
import test.ave.entities.dtos.LoginDto;

@RestController
@RequestMapping("api/users")
@CrossOrigin
public class UserController {
	
	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@PostMapping("/register")
	public String add(@RequestBody User user) {
		return this.userService.add(user); 
	}
	
	@PostMapping("/login")
	public Dictionary<String, Integer> login(@RequestBody LoginDto loginDto) throws NoSuchAlgorithmException {
		return this.userService.login(loginDto);
	}
		
	@GetMapping("/getalluser")
	public List<User> getAllUser() {
		return this.userService.getAllUser();
	}

}
