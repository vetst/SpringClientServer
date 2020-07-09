package springBoot.web.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import springBoot.web.dao.UserDao;
import springBoot.web.model.Role;
import springBoot.web.model.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserRoleImpl implements UserRole {

    private UserDao dao;

    @Autowired
    public UserRoleImpl(UserDao dao) {
        this.dao = dao;
    }

    public User getUserWithRole(User user) {
        List<Role> roles = user.getRoles();
        List<Role> indexRoles = new ArrayList();
        Role role;
        if (roles.size() == 2) {
            role = roles.get(0);
            indexRoles.add(dao.getRoleByName(role.getName()));
            role = roles.get(1);
            indexRoles.add(dao.getRoleByName(role.getName()));
            user.setRoles(indexRoles);
        } else {
            role = roles.get(0);
            indexRoles.add(dao.getRoleByName(role.getName()));
            user.setRoles(indexRoles);
        }
        return user;
    }
}
