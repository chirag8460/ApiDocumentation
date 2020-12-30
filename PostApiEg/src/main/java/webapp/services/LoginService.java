package webapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webapp.entity.Login;
import webapp.repository.LoginRepository;
@Service
public class LoginService {
	@Autowired
	LoginRepository loginRepository;

	public Login addUser(Login login) {
		loginRepository.save(login);
		return login;
		
	}
	

}
