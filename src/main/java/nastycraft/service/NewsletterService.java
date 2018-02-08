package nastycraft.service;

import java.util.ArrayList;
import java.util.List;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import nastycraft.dao.NewsletterRepository;
import nastycraft.model.Newsletter;
import nastycraft.query.MCQuery;
import nastycraft.query.QueryResponse;


@Service
@Transactional
public class NewsletterService {
	
		private final NewsletterRepository newsletterRepository;

	
		
		public NewsletterService(NewsletterRepository newsletterRepository) {
			this.newsletterRepository = newsletterRepository;
		}

		public int returnPlayers() {
			MCQuery mcQuery = new MCQuery("91.134.50.184", 25565);
			QueryResponse response = mcQuery.basicStat();
			return response.getOnlinePlayers();
		}
		
		public List<Newsletter> findAll(){
			List<Newsletter> emailsList = new ArrayList<>();
			for(Newsletter email : newsletterRepository.findAll()) {
				emailsList.add(email);
			}
			
			return emailsList;
		}
		
		public void saveNewsletter(Newsletter email) {
			newsletterRepository.save(email);
		}
		
		public void deleteNewsletter(int id) {
			newsletterRepository.delete(id);
		}
		
		public Newsletter findOne(int id) {
			return newsletterRepository.findOne(id);
		}
		
		
		//email validation method
		public static boolean isValidEmailAddress(String email) {
			   boolean result = true;
			   try {
			      InternetAddress emailAddr = new InternetAddress(email);
			      emailAddr.validate();
			   } catch (AddressException ex) {
			      result = false;
			   }
			   return result;
			}
		
		
		//email exist
		public  boolean emailExist(String email) {
			boolean exist = false;
			for(int i = 0;i < findAll().size();i++) {
				if(findAll().get(i).getEmail().equalsIgnoreCase(email)) {
					exist = true;
				}
			}
			return exist;
		}
		
		//ip exist
				public  boolean ipExist(String ip) {
					boolean exist = false;
					for(int i = 0;i < findAll().size();i++) {
						if(findAll().get(i).getIp().equalsIgnoreCase(ip)) {
							exist = true;
						}
					}
					return exist;
				}
}
