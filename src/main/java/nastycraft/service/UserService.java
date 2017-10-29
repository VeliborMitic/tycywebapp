package nastycraft.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.xml.bind.DatatypeConverter;

import org.springframework.stereotype.Service;

import nastycraft.dao.UsersRepository;
import nastycraft.model.Users;



@Service
@Transactional
public class UserService {

	
	private final UsersRepository usersRepository;
	
	public UserService(UsersRepository usersRepository){
		this.usersRepository = usersRepository;
	}
	
	
	
	//find all
	public List<Users> findAllUsers(){
		List<Users> users = new ArrayList<>();
		
		for(Users user : usersRepository.findAll()){
			users.add(user);
		}
		
		return users;
		
	}

	
	public boolean checkPassAndUser(String name,String password){
		
		String passHash = passwordHas(password);
		
		boolean detailsMatch = false;
		

		Users user = usersRepository.findByUser(name);
		
		if(user.getPassword().equalsIgnoreCase(passHash)) {
			detailsMatch = true;
		}
		
		return detailsMatch;
	}
	
	
	
	
	
	//pass hash
	public String passwordHas(String password) {
		String hasResult = "";
		try{
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(password.getBytes());
		byte[] digest = md.digest();
		
		hasResult = DatatypeConverter.printHexBinary(digest).toUpperCase();
		
		return hasResult;
		}catch(NoSuchAlgorithmException e){
			e.printStackTrace();
		}
		
		return hasResult;
	}
}
