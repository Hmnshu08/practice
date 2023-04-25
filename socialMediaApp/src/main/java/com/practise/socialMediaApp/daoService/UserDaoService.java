package com.practise.socialMediaApp.daoService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import com.practise.socialMediaApp.model.User;

@Component
public class UserDaoService {

	//creating a static list bcoz no using database or h2 database or jpa
	private static List<User> users = new ArrayList();
	
	//for users count
	private static int usersCount=0;
	
	static {
		users.add(new User(++usersCount,"Ryo", LocalDate.now().minusYears(32)));
		users.add(new User(++usersCount,"Nakagawa", LocalDate.now().minusYears(27)));
		users.add(new User(++usersCount,"Sakonji", LocalDate.now().minusYears(30)));
	}
	
	
	
	//method to retrieve all the users
	public List<User>findAll(){
		return users;
	}
	
	/*creating a method to retrieve one user based on the id provided, 
	 * used functional programming to get id which is equal and then stream it to filter
	 * from the first match from the list of users 
	*/
	public User findOne(int id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id);
//		return users.stream().filter(predicate).findFirst().get();
		return users.stream().filter(predicate).findFirst().orElse(null);
	}
	
	public User save(User user) {
		user.setId(++usersCount);
		users.add(user);
		return user;
	}
	
	public void deleteById(int id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		users.removeIf(predicate);
		
	}
	
}
