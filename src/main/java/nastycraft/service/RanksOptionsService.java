package nastycraft.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import nastycraft.dao.RanksOptionsRepository;
import nastycraft.model.RanksOptions;



@Service
@Transactional
public class RanksOptionsService {
	
		private final RanksOptionsRepository ranksOptionsRepository;
		
		public RanksOptionsService(RanksOptionsRepository ranksOptionsRepository) {
			super();
			this.ranksOptionsRepository = ranksOptionsRepository;
		}

		public List<RanksOptions> findAll(){
			List<RanksOptions> ranksOptionsList = new ArrayList<>();
			for(RanksOptions rankO : ranksOptionsRepository.findAll()) {
				ranksOptionsList.add(rankO);
			}
			
			return ranksOptionsList;
		}
		
		public void saveRankOption(RanksOptions ranks) {
			ranksOptionsRepository.save(ranks);
		}
		
		public void deleteRankOption(int id) {
			ranksOptionsRepository.delete(id);
		}
		
		public RanksOptions findOneRank(int id) {
			return ranksOptionsRepository.findOne(id);
		}
		
		
		
		
}
