package mvc_security.service;

import mvc_security.model.Role;
import mvc_security.model.User;

import java.util.List;
import java.util.Set;

public interface RoleService {



    Set<Role> getRoleByName(String[] name);




}
