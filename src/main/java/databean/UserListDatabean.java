package databean;

import java.util.List;

import JDBC.SelectUser;
import domain.User;

public class UserListDatabean {
	private List<User> userList;
	
	public UserListDatabean() {
		userList = SelectUser.getAllUsers();

	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
}
