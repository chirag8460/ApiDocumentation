package spring.DAO;

import java.util.List;

import spring.model.User;

public interface AppDAO {
	public List<User> listUsers();
	public void addUser(User user); 
	

}
