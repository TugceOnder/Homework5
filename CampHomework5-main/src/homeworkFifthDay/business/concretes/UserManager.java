package homeworkFifthDay.business.concretes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import homeworkFifthDay.business.abstracts.Login;
import homeworkFifthDay.business.abstracts.UserService;
import homeworkFifthDay.core.abstracts.ConfirmationService;
import homeworkFifthDay.dataAccess.abstracts.UserDao;
import homeworkFifthDay.dataAccess.concretes.DbUserDao;
import homeworkFifthDay.entities.concretes.User;

public class UserManager implements UserService{

	ConfirmationService confirmationService;
	UserDao userDao;
	Login login;
	
	public UserManager(ConfirmationService confirmationService,UserDao userDao,Login login) {
		this.confirmationService = confirmationService;
		this.userDao = userDao;
		this.login=login;
	}
	
	@Override
	public boolean checkPassword(User user) {
		if(user.getPassword().length() < 6) {
			return false;
		}
		return true;
	}

	@Override
	public boolean checkEmailisValid(User user) {
		String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(user.getEmail());
		if(!m.find()) {
			return false;
		}
		else {return true;}
	}

	@Override
	public boolean checkFirstName(User user) {
		if(user.getFirstName().length() < 2 ) {
			return false;
		}
		return true;
	}

	@Override
	public boolean checkLastName(User user) {
		if(user.getLastName().length() < 2 ) {
			return false;
		}
		return true;
	
	
	}

	@Override
	public void register(User user) {
		if(checkEmailisValid(user)) {
			if(checkFirstName(user)) {
				if(checkLastName(user)) {
					if(checkPassword(user)) {
						if(!checkEmail(user)) {
							confirmationService.confirm();
							userDao.add(user);
						}
						else {
							System.out.println(user.getEmail() + " Email used! Registration is unsuccessful");
						}
					}
					else 
						System.out.println("Password cannot be less than 6!");
				}
				else
					System.out.println("Last name cannot be less than 2!");
			}
			else 
				System.out.println("First name cannot be less than 2!");
		}
		else {
			System.out.println("Email is invalid!");
		}
	}

	@Override
	public void registerWithService(UserDao userDao) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean checkEmail(User user) {
		
		for (User user2 : DbUserDao.arrayList) {
			if(user2.getEmail() == user.getEmail()) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void login(String email, String password) {
		login.login(email, password);
		
	}

	@Override
	public void delete(String email) {

		userDao.delete(email);
	}
	 
}
