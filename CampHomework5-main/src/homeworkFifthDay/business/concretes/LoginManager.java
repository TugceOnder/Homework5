package homeworkFifthDay.business.concretes;

import homeworkFifthDay.business.abstracts.Login;
import homeworkFifthDay.dataAccess.concretes.DbUserDao;
import homeworkFifthDay.entities.concretes.User;

public class LoginManager implements Login{

	@Override
	public void login(String email, String password) {

		for (User user : DbUserDao.arrayList) {
			if(user.getEmail() == email && user.getPassword() == password) {
				System.out.println("Successfully login");
				return;
			}
		}
		System.out.println("email or password is incorrect");
		
		
	}

}
