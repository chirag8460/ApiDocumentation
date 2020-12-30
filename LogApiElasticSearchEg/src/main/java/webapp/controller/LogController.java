package webapp.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import webapp.entity.Log;
import webapp.services.LogService;
@CrossOrigin
@RestController
@RequestMapping("/logs")
public class LogController {

	@Autowired
	private LogService logService;

	@GetMapping("/")
	public List<Log> getLogs( @RequestParam(value ="startDate", required = false) String startDate,
			@RequestParam(value ="endDate", required = false) String endDate) {
//		LOG.log(Level.INFO, response);
		return startDate==null ? logService.getLog():logService.getLogByDate(startDate, endDate);		
	}

	@PostMapping("/")
	public ResponseEntity<Log> addLog(@RequestBody Log Log) {
		logService.addLog(Log);
		return ResponseEntity.accepted().body(Log);
	}

	@GetMapping("/{id}")
	public Log getLog(@PathVariable int id) {
		return logService.getLog(id);
	}
	
	

	@GetMapping("/entity/{entityName}")
	public List<Log> getLog(@PathVariable String entityName) {
		return logService.getLogByEntityName(entityName);
	}

	//to get the details logs between dates but with bydate as endpoint
	
	@GetMapping("/bydate")
	public List<Log> getLogByDate(@RequestParam(value = "startDate") String startDate,
			@RequestParam(value = "endDate") String endDate) {
		return logService.getLogByDate(startDate, endDate);
	}
	
	/*
	 * @GetMapping() public ResponseEntity<?> getProgramById( @RequestParam(value =
	 * "startDate", required = false) Date startDate,@RequestParam(value =
	 * "endDate", required = false) Integer endDate) { return null;}
	 */
}
