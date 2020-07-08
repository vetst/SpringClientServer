package springBoot.web.util;

import springBoot.web.model.Role;

import java.util.List;

public interface UserRole {
    public List<Role> getRoleForUser(String role);
}
