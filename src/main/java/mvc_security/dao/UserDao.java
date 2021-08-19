package mvc_security.dao;

import mvc_security.model.User;

import java.util.List;

public interface UserDao {

     void saveUser(User user);

     void updateUser(User user, long id);

     void removeUser(long id);

     User getUserById(long id);

     List<User> getAllUsers();

     User getUserByUsername(String username);

     String getPassword(User user);
}
