package test.ave.security.hashing.abstracts;

import java.security.NoSuchAlgorithmException;

public interface HashingService {
	
	String getSalt() throws NoSuchAlgorithmException;
	String passwordHash(String password) throws NoSuchAlgorithmException;
	
}
