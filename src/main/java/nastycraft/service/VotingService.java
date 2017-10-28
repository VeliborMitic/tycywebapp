package nastycraft.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;


import nastycraft.dao.VotingRepository;
import nastycraft.model.Voting;



@Service
@Transactional
public class VotingService {
	
		private final VotingRepository votingRepository;


		public VotingService(VotingRepository votingRepository) {
			this.votingRepository = votingRepository;
		}

		
		public List<Voting> findAll(){
			List<Voting> votingList = new ArrayList<>();
			for(Voting voting : votingRepository.findAll()) {
				votingList.add(voting);
			}
			
			return votingList;
		}
		
		public void saveVoting(Voting voting) {
			votingRepository.save(voting);
		}
		
		public void deleteVoting(int id) {
			votingRepository.delete(id);
		}
		
		public Voting findOneVoting(int id) {
			return votingRepository.findOne(id);
		}
		
		
		
		
}
