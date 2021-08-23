package mvc_security.dao;

import mvc_security.model.Role;

import java.util.List;
import java.util.Set;

public interface RoleDao {


    Set<Role> getRoleByName(String[] name);


}
