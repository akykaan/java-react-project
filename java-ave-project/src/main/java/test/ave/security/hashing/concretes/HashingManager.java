package test.ave.security.hashing.concretes;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Service;

import test.ave.security.hashing.abstracts.HashingService;

@Service
public class HashingManager implements HashingService{
	
	public String getSalt() {
		String salt="avebilisim";
        return salt;
    }
	
	public String passwordHash(String password) throws NoSuchAlgorithmException  {
		
		String generatedPassword=null;
		
		MessageDigest md=MessageDigest.getInstance("SHA256");
		md.update(getSalt().getBytes());
		
		byte[] resultByteArray = md.digest(password.getBytes());
		StringBuilder sb=new StringBuilder();
		for (byte b : resultByteArray) {
			sb.append(String.format("%02x",b ));
		}
		
		generatedPassword=sb.toString();
		return generatedPassword;
	}
}
