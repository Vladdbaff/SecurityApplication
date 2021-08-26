package mvc_security.dao;

import mvc_security.model.Role;
import mvc_security.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;


    private RoleDao roleDao;

    public UserDaoImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    @Transactional
    public void updateUser(User user, long id) {
        User dbUser = entityManager.find(User.class, id);
        dbUser.setName(user.getName());
        dbUser.setLastName(user.getLastName());
        dbUser.setEmail(user.getEmail());
        entityManager.merge(dbUser);
    }

    @Override
    @Transactional
    public void removeUser(long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    @Override
    @Transactional
    public User getUserById(long id) {
        User user = entityManager.find(User.class, id);
        return user;
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        List<User> users = entityManager.createQuery("select u from User u", User.class).getResultList();
        return users;
    }

    @Override
    @Transactional
    public User getUserByUsername(String username) {
        Query query = entityManager.createQuery("select u from User u where u.name =: name");
        query.setParameter("name", username);
        User user = (User) query.getSingleResult();
        return entityManager.find(User.class, user.getId());
    }

    @Override
    public String getPassword(User user) {
        return entityManager.find(User.class, user.getId()).getPassword();
    }


}
