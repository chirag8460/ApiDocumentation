package webapp.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import webapp.entity.Log;
import webapp.entity.Post;
import webapp.repository.LoggerClassRepository;

@Service
public class LogService {
	@Autowired
	private LoggerClassRepository loggerClassRepository;
	Log tempLogger = new Log();
	RestTemplate restTemplate = new RestTemplate();
	Post tempPost = new Post();
	String url = "http://localhost:9050/loggers/";
	ObjectMapper mapper = new ObjectMapper();
	Date date = new Date();

	public ResponseEntity<Log> addLogger(Log logger) {
		//logger.setLastModifiedDate(new Date());
		
			logger.setCreatedDate(date);
		
		loggerClassRepository.save(logger);
		return ResponseEntity.accepted().body(logger);
	}

	public Log getLogger(int id) {
		return loggerClassRepository.findById(id).get();
	}

	public List<Log> getLogger() {
		List<Log> loggers = new ArrayList<>();
		for (Log logger : loggerClassRepository.findAll()) {
			loggers.add(logger);
		}
		return loggers;

	}

	public List<Log> getLoggerByDate(String startDate, String endDate) {
		List<Log> loggers = new ArrayList<>();
		try {
			for (Log logger : loggerClassRepository.findAllBycreatedDate(
					new SimpleDateFormat("yyyy-MM-dd").parse(startDate),
					new SimpleDateFormat("yyyy-MM-dd").parse(endDate))) {
				loggers.add(logger);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return loggers;

	}

	public List<Log> getLoggerByEntityName(String entityName) {

		List<Log> loggers = new ArrayList<>();
		for (Log logger : loggerClassRepository.findByentityName(entityName)) {
			loggers.add(logger);
		}

		return loggers;
	}

	public void migrateData() {
		
		for (Log logger : loggerClassRepository.findAll()) {
			
			restTemplate.postForObject(url, logger, Log.class);
		}
		
		
		
	}

}
