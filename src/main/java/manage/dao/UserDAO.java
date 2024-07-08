package manage.dao;

import java.util.List;

import entities.User;

public interface UserDAO {
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(int userID);
    User getUserById(int userID);
    List<User> getAllUsers();
	User getUserByAuthentification(String username,String password);
}
