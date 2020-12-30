package webapp.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import webapp.entity.Post;

public interface postsRepository extends CrudRepository<Post,Integer> {
	
	@Query(value = "from Post where createdDate BETWEEN :startDate AND :endDate")
	/// List<Logger> findAllBycreatedDate(@PathParam("startDate") Date startDate,@PathParam("endDate") Date endDate);
	 List<Post> findAllByCreatedDate(Date startDate, Date endDate);
	

	
}
