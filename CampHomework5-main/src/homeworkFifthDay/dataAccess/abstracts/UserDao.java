package homeworkFifthDay.dataAccess.abstracts;

import java.util.ArrayList;

import homeworkFifthDay.entities.concretes.User;

public interface UserDao {

	void add(User user);
	void delete(String email);
	ArrayList<User> listAll();
	
}
