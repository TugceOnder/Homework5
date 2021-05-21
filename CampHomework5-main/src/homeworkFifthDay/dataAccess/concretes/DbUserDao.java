package homeworkFifthDay.dataAccess.concretes;

import java.util.ArrayList;

import homeworkFifthDay.dataAccess.abstracts.UserDao;
import homeworkFifthDay.entities.concretes.User;

public class DbUserDao implements UserDao{

	public static ArrayList<User> arrayList = new ArrayList<User>();
	@Override
	public void add(User user) {

		arrayList.add(user);
		System.out.println(user.getFirstName() + " registered!");
	}

	@Override
	public void delete(String email) {

		for (User user : arrayList) {
			if(user.getEmail() == email) {
				arrayList.remove(user);
				System.out.println("User deleted.");
				return;
			}
		}
		System.out.println("There is no user with this email.");
	}

	public ArrayList<User> listAll() {
		return DbUserDao.arrayList;

		
	}

	
}
