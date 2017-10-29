package nastycraft.service;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
		
		
		public boolean verifyLogIn(HttpSession session,HttpServletRequest request) {
			
			String sessionAttribute = (String) session.getAttribute("loginsession");
			String nameFromSession = (String) session.getAttribute("username");
			String ip = getIp(request);
			
			if(sessionAttribute == null) {
				return false;
			}
			else if(!sessionAttribute.equals(returnHashByName(nameFromSession)) && !ip.equals(returnIpByName(nameFromSession))){
				return false;
			}else {
				return true;
			}
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
		
		
		
		public String returnName(String name) {	
			String returnName = "";
			try {
				returnName = hashsessionrepository.findByName(name).getUsername();
			}catch(Exception e) {
				
			}
			return returnName;
		}
		
		
		public String returnIpByName(String name) {	
			return hashsessionrepository.findByName(name).getIp();
		}
		
		
		
		public String returnHashByName(String name) {	
		Hashsession hashSessionName = hashsessionrepository.findByName(name);
		String returnHash = hashSessionName.getHashsession();
			return returnHash;
		}
		
		
		public void deleteHashSessionByName(String name) {
			Hashsession hashSessionName = hashsessionrepository.findByName(name);
			hashsessionrepository.delete(hashSessionName.getId());
		}
		
		
		
		public String getIp(HttpServletRequest request) {
			String remoteAddr = "";
			if (request != null) {
				remoteAddr = request.getHeader("X-FORWARDED-FOR");
				if (remoteAddr == null || "".equals(remoteAddr)) {
					remoteAddr = request.getRemoteAddr();
				}
			}
			return remoteAddr;
		}
}
