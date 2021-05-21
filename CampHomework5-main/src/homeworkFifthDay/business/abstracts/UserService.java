package homeworkFifthDay.business.abstracts;


import homeworkFifthDay.dataAccess.abstracts.UserDao;
import homeworkFifthDay.entities.concretes.User;

public interface UserService {
	boolean checkPassword(User user);
	boolean checkEmailisValid(User user);
	boolean checkFirstName(User user);
	boolean checkLastName(User user);
	boolean checkEmail(User user);
	void register(User user);
	void registerWithService(UserDao userDao);
	void login(String email,String password);
	void delete(String email);
	
	}
