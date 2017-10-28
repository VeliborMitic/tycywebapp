package nastycraft.service;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import nastycraft.dao.HashsessionRepository;
import nastycraft.model.Hashsession;


@Service
@Transactional
public class HashsessionService {
	
	   @Autowired
	    private UserService userService;
	   
	   
		private final HashsessionRepository hashsessionrepository;

		public HashsessionService(HashsessionRepository hashsessionrepository) {
			super();
			this.hashsessionrepository = hashsessionrepository;
		}

		public List<Hashsession> findAll(){
			List<Hashsession> hashsession = new ArrayList<>();
			for(Hashsession hash : hashsessionrepository.findAll()) {
				hashsession.add(hash);
			}
			
			return hashsession;
		}
		
		public void saveHash(Hashsession hash) {
			hashsessionrepository.save(hash);
		}
		
		public void deleteHashSession(int id) {
			hashsessionrepository.delete(id);
		}
		
		public Hashsession findOne(int id) {
			return hashsessionrepository.findOne(id);
		
		}
		
		
		
		public String hashString() {
			String model = "abc!@defg#$hij^klm1n2u3q4r5s6t&*u789v(x)w[0]x?z";
			String hashString = "";
			SecureRandom rd = new SecureRandom();
			
			for(int i = 0;i < 16;i++) {
				hashString += model.charAt(rd.nextInt(model.length()-1));
			}
			
			return userService.passwordHas(hashString);
		}
		
		
		public String returnHashByName(String name) {
			List<Hashsession> hashsession = findAll();
			String returnHash = "";
			
			for(int i=0;i<hashsession.size();i++) {
				if(hashsession.get(i).getUsername().equals(name)) {
					returnHash =  hashsession.get(i).getHashsession();
				}
			}
			return returnHash;
		}
		
		public void deleteHashSessionByName(String name) {
			
			List<Hashsession> hashsession = findAll();
			
			for(int i = 0;i < hashsession.size();i++) {
				if(hashsession.get(i).getUsername().equals(name)) {
					hashsessionrepository.delete(hashsession.get(i).getId());
				}
			}
		}
		
}
