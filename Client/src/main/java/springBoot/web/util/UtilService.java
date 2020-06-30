package springBoot.web.util;

import springBoot.web.model.Role;
import springBoot.web.model.User;
import springBoot.web.model.UserDTO;

import java.util.List;
import java.util.Set;

public interface UtilService {

    public List<Role> getRoleForUser(String role);

    public User getConvertToUser(UserDTO userDTO);
}
