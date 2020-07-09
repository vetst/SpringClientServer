package springBoot.web.util;

import org.springframework.stereotype.Component;
import springBoot.web.model.Role;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserRoleImpl implements UserRole {
    @Override
    public List<Role> getRoleForUser(String role) {
        List<Role> roles = new ArrayList<>();
        try {
            String[] partsRole = role.split("[, ]");
            roles.add(new Role(partsRole[1]));
            roles.add(new Role(partsRole[0]));
            return roles;
        } catch (Exception e) {

        }
        roles.add(new Role(role));
        return roles;
    }
}
