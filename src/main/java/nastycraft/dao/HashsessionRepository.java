package nastycraft.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import nastycraft.model.Hashsession;



public interface HashsessionRepository extends CrudRepository<Hashsession,Integer>{

	@Query("select h from hashsession h where username=:username")
	public Hashsession findByName(@Param(value = "username") String username);
}
