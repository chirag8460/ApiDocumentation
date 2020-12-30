package webapp.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import webapp.entity.Log;
import webapp.repository.LogRepository;

@Service
public class LogService {
	private static Logger logger = LogManager.getLogger();

	@Autowired
	private LogRepository logClassRepository;
	Log tempLog = new Log();

	public ResponseEntity<Log> addLog(Log Log) {

		logClassRepository.save(Log);
		logger.debug("Logs saved" + Log);
		
		return ResponseEntity.accepted().body(Log);
	}

	public Log getLog(int id) {
		logger.info("Log retrived");

		return logClassRepository.findById(id).get();
		
	}

	public List<Log> getLog() {
		List<Log> Logs = new ArrayList<>();
		for (Log Log : logClassRepository.findAll()) {
			Logs.add(Log);
		}
		return Logs;

	}

	public List<Log> getLogByDate(String startDate, String endDate) {
		List<Log> Logs = new ArrayList<>();
		try {
			for (Log Log : logClassRepository.findAllBycreatedDate(new SimpleDateFormat("yyyy-MM-dd").parse(startDate),
					new SimpleDateFormat("yyyy-MM-dd").parse(endDate))) {
				Logs.add(Log);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return Logs;
	}

	public List<Log> getLogByEntityName(String entityName) {

		logger.info("Log retrieved by name");
		
		List<Log> Logs = new ArrayList<>();
		for (Log Log : logClassRepository.findByEntityName(entityName)) {
			Logs.add(Log);
		}

		return Logs;
	}

}
