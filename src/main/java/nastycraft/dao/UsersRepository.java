package nastycraft.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import nastycraft.model.Users;




public interface UsersRepository extends CrudRepository<Users,Integer> {

	@Query("select u from users u where user=:user")
	public Users findByUser(@Param(value = "user") String user);
}
