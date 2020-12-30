package webapp.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import webapp.entity.Log;
import webapp.services.LogService;

@RestController
@RequestMapping("/logs")
public class LogController {

	@Autowired
	private LogService logService;

	@GetMapping
	public List<Log> getLogger( @RequestParam(value ="startDate", required = false) String startDate,
			@RequestParam(value ="endDate", required = false) String endDate) {
		return startDate==null ? logService.getLogger():logService.getLoggerByDate(startDate, endDate);
	}
	
	@GetMapping("migratedata")
	public String migrateData(){
		logService.migrateData();
		return "success";
		
	}
	
	@PostMapping("/")
	public ResponseEntity<Log> addLogger(@RequestBody Log logger) {
		logService.addLogger(logger);
		return ResponseEntity.accepted().body(logger);
	}
	

	@GetMapping("/{id}")
	public Log getLogger(@PathVariable int id) {
		return logService.getLogger(id);
	}

	@GetMapping("/entity/{entityName}")
	public List<Log> getLogger(@PathVariable String entityName) {
		return logService.getLoggerByEntityName(entityName);
	}

	//to get the details logs between dates but with bydate as endpoint
	@GetMapping("/bydate")
	public List<Log> getLoggerByDate(@RequestParam(value = "startDate") String startDate,
			@RequestParam(value = "endDate") String endDate) {
		return logService.getLoggerByDate(startDate, endDate);
	}
	
	/*
	 * @GetMapping() public ResponseEntity<?> getProgramById( @RequestParam(value =
	 * "startDate", required = false) Date startDate,@RequestParam(value =
	 * "endDate", required = false) Integer endDate) { return null;}
	 */
}
