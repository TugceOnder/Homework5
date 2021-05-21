package homeworkFifthDay.core.concretes;

import homeworkFifthDay.business.abstracts.UserService;
import homeworkFifthDay.business.concretes.LoginManager;
import homeworkFifthDay.business.concretes.UserManager;
import homeworkFifthDay.core.abstracts.RegistrationOtherService;
import homeworkFifthDay.dataAccess.concretes.DbUserDao;
import homeworkFifthDay.entities.concretes.User;

public class GoogleRegistration implements RegistrationOtherService {

	@Override
	public void register(User user) {

		UserService userService = new UserManager(new EmailConfirmation(),new DbUserDao(),new LoginManager());
		userService.register(user);
		System.out.println("Registered with google.");
	}

	
}
