package mvc_security.service;

import mvc_security.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    public void saveUser(User user);

    public User getUserById(long id);

    public List<User> getAllUsers();

    public void removeUser(long id);

    public void updateUser(User user, long id);

}
