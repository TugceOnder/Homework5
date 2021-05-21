package homeworkFifthDay;

import homeworkFifthDay.business.abstracts.UserService;
import homeworkFifthDay.business.concretes.LoginManager;
import homeworkFifthDay.business.concretes.UserManager;
import homeworkFifthDay.core.abstracts.RegistrationOtherService;
import homeworkFifthDay.core.concretes.EmailConfirmation;
import homeworkFifthDay.core.concretes.GoogleRegistration;
import homeworkFifthDay.dataAccess.concretes.DbUserDao;
import homeworkFifthDay.entities.concretes.User;

public class Main {

	public static void main(String[] args) throws Exception {

	
		User user = new User(1,"Tugce","Onder","tog@hotmail.com","123124123");
		User user3 = new User(1,"Tugce","Onder","tog@hotmail.com","123124123");
		User user2 = new User(2,"Ayse","Yılmaz","ayn@hotmail.com","123124123");
		User user4 = new User(2,"Abcd","Defy","abcan@hotmail.com","123124123");
		User user5 = new User(3,"Ali","Derg","ali@hotmail.com","123124123");

		UserService userService = new UserManager(new EmailConfirmation(),new DbUserDao(),new LoginManager());
		RegistrationOtherService registrationOtherService = new GoogleRegistration();
		userService.register(user);
		userService.register(user2);
		userService.register(user3);
		userService.register(user4);
		System.out.println("---------Login simulator----------");
		userService.login("tog@hotmail.com","123124123");
		System.out.println("---------Delete simulator----------");
		userService.delete("saasd");
		userService.login("tog@hotmail.com","123124123");
		userService.delete(user2.getEmail());
		userService.login("tog@hotmail.com","123124123");
		System.out.println("---------Google registration simulator----------");
		registrationOtherService.register(user5);
		
	}

}
