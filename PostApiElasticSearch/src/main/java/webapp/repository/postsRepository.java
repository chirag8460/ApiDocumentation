package webapp.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.jpa.repository.Query;
import webapp.entity.Post;

public interface postsRepository extends ElasticsearchRepository<Post,Integer> {
	
//	@Query(value = "from Post where createdDate BETWEEN :startDate AND :endDate")
	/// List<Logger> findAllBycreatedDate(@PathParam("startDate") Date startDate,@PathParam("endDate") Date endDate);
	// List<Post> findAllByCreatedDate(Date startDate, Date endDate);
	 List<Post> fingByTitle(String title);	
}
