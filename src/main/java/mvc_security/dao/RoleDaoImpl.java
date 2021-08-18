package mvc_security.dao;

import mvc_security.model.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<Role> getRoles() {
        List<Role> roles = entityManager.createQuery("select r from Role r", Role.class).getResultList();
        return roles;
    }
}
