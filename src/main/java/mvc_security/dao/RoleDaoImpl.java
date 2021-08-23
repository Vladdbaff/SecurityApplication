package mvc_security.dao;

import mvc_security.model.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.*;

@Repository
public class RoleDaoImpl implements RoleDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Set<Role> getRoleByName(String[] name) {
        List<String> roles = Arrays.asList(name);
        return new HashSet<Role>(entityManager.createQuery("select r from Role r where r.role in  (:stringRoles)", Role.class)
                .setParameter("stringRoles", roles).getResultList());

    }


}
