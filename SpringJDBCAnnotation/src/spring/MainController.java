package spring;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import spring.DAO.AppDAOImpl;
import spring.config.AppConfig;
import spring.model.User;

@Controller
public class MainController {
	@RequestMapping("/")
	public ModelAndView welcome() {
		List<User> users = new ArrayList<User>();

		ModelAndView mav = new ModelAndView("Index");
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		AppDAOImpl DAO = context.getBean("DAOBean", AppDAOImpl.class);

		users = DAO.listUsers();
		System.out.println(users);

		mav.addObject("users", users);

		context.close();
		return mav;

	}

	// @RequestMapping("displayname")
	@RequestMapping("/displayDetails")
	public String addUser( User user) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		AppDAOImpl DAO = context.getBean("DAOBean", AppDAOImpl.class);

		 DAO.addUser(user);
		return("forward:/");
		
	}

	@RequestMapping("/inputDetails")
	public String inputDetails(Model model, User user) {
		model.addAttribute("user", user);
		Map<String, String> genderMap = new HashMap<String, String>();
		genderMap.put("male", "Male");
		genderMap.put("female", "Female");

		Map<String, String> countryMap = new HashMap<String, String>();
		countryMap.put("india", "India");
		countryMap.put("Nepal", "Nepal");
		countryMap.put("uae", "UAE");
		countryMap.put("USA", "United States");
		countryMap.put("Germany", "Germany");

		Map<String, String> hobbiesMap = new HashMap<String, String>();
		hobbiesMap.put("singing", "Singing");
		hobbiesMap.put("horse_riding", "Horse Riding");
		hobbiesMap.put("puzzles", "Puzzles");

		model.addAttribute("genderMap", genderMap);
		model.addAttribute("countryMap", countryMap);
		model.addAttribute("hobbiesMap", hobbiesMap);
		return "inputDetails";

	}

	@ExceptionHandler
	public String exceptionHandler(Exception ex) {
		return "error";
	}
	/*
	 * @GetMapping("/inputDetails") public ModelAndView inputDetails() { User user =
	 * new User(); ModelAndView mav = new ModelAndView("inputDetails");
	 * mav.addObject("user", user); Map<String, String> genderMap = new
	 * HashMap<String, String>(); genderMap.put("male", "Male");
	 * genderMap.put("female", "Female");
	 * 
	 * Map<String, String> countryMap = new HashMap<String, String>();
	 * countryMap.put("india", "India"); countryMap.put("Nepal", "Nepal");
	 * countryMap.put("uae", "UAE"); countryMap.put("USA", "United States");
	 * countryMap.put("Germany", "Germany");
	 * 
	 * Map<String, String> hobbiesMap = new HashMap<String, String>();
	 * hobbiesMap.put("singing", "Singing"); hobbiesMap.put("horse_riding",
	 * "Horse Riding"); hobbiesMap.put("puzzles", "Puzzles");
	 * 
	 * mav.addObject("genderMap", genderMap); mav.addObject("countryMap",
	 * countryMap); mav.addObject("hobbiesMap", hobbiesMap); return mav; }
	 * 
	 */
	/*
	 * public String displayName(@RequestParam ("firstname") String
	 * firstName,@RequestParam("lastname") String lastName,Model model) {
	 * model.addAttribute("fName",firstName); model.addAttribute("lName",lastName);
	 * 
	 * return "displayName";
	 * 
	 * }
	 */

	/*
	 * public String displayName(HttpServletRequest request) { String
	 * firstName=request.getParameter("firstname"); String
	 * lastName=request.getParameter("lastname");
	 * request.setAttribute("firstName",firstName);
	 * request.setAttribute("lastName",lastName); return "displayName"; }
	 */
}
