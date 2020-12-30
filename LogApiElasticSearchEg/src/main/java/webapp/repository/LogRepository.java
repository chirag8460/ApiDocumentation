package webapp.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

import webapp.entity.Log;

public interface LogRepository extends ElasticsearchCrudRepository<Log,Integer>{
	
	public List<Log> findByEntityName(String entityName);	
	/// List<Logger> findAllBycreatedDate(@PathParam("startDate") Date startDate,@PathParam("endDate") Date endDate);
	List<Log> findAllBycreatedDate(Date startDate, Date endDate);
	                    
}
