package mvc_security.dao;

import mvc_security.model.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class RoleDaoImpl implements RoleDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public Set<Role> getRolesByName(String[] roles) {
        List<String> role = Arrays.asList(roles);
        return new HashSet<Role>(entityManager.createQuery("select r from Role r where r.role in (:roleSet)")
                .setParameter("roleSet", role).getResultList());
    }

}
