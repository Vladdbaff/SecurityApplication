package mvc_security.service;

import mvc_security.dao.RoleDao;
import mvc_security.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleDao roleDao;

    @Override
    public List<Role> getAllRoles() {
        return roleDao.getAllRoles();
    }



}
