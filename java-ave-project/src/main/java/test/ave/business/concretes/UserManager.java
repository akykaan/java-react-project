package test.ave.business.concretes;
import java.security.NoSuchAlgorithmException;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.ave.business.abstracts.UserService;
import test.ave.dataAccess.abstracts.UserDao;
import test.ave.entities.concretes.Group;
import test.ave.entities.concretes.User;
import test.ave.entities.dtos.LoginDto;
import test.ave.security.hashing.abstracts.HashingService;

@Service
public class UserManager implements UserService{

	private UserDao userDao;
	private HashingService hashingService;
	
	@Autowired
	public UserManager(UserDao userDao,HashingService hashingService) {
		super();
		this.userDao = userDao;
		this.hashingService=hashingService;
	}
	@Override
	public String add(User user) {
		User userFind= userDao.findByEmail(user.getEmail());
		if (userFind!=null)
			return "Bu mail ile daha önce üye olunmuş";
		else {
			try {
				String newPassword= this.hashingService.passwordHash(user.getPassword());
				user.setPassword(newPassword);
				user.setGroups_id(2);
				this.userDao.save(user);
			} catch (Exception e) {
				System.out.print(e);
			}
			
		}
		return "Başarı ile Kayıt olundu.";
	}

	@Override
	public Dictionary<String, Integer> login(LoginDto loginDto) throws NoSuchAlgorithmException {
		
		Dictionary<String, Integer> userIdAndMessage = new Hashtable<String, Integer>();
		
		User userFindEmail = userDao.findByEmail(loginDto.getEmail());
		
		if (emailCheck(userFindEmail) && passwordCheck(loginDto,userFindEmail) ) {
			userIdAndMessage.put("Success", 1); 
			userIdAndMessage.put("groupId", userFindEmail.getGroups_id());
			return userIdAndMessage;
			
			//return String.valueOf( userFindEmail.getId());
		}
		return userIdAndMessage;
		//return "0";
	}
	
	public boolean passwordCheck(LoginDto loginDto, User user) throws NoSuchAlgorithmException {
		
		String hashPassword=this.hashingService.passwordHash(loginDto.getPassword());
			
		if (!user.getPassword().equals(hashPassword)) {
			return false;
		}
		return true;
	}
	
	public boolean emailCheck(User user) {	
		if (user==null)
			return false;
		return true;
	}
		
	@Override
	public List<User> getAllUser() {
		return userDao.findAll();
	}
}
