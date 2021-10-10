package DAO;

import java.util.List;

import Model.User;

public interface User_DAO {

	public boolean saveUser(User user);
	public List<User> getUsers();
	public boolean deleteUser(User user);
	public List<User> getUserByID(User user);
	public int Login(String user_email , String user_password);
	public boolean updateUser(User user);
}
