package springBoot.web.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import springBoot.web.model.Role;
import springBoot.web.model.User;
import springBoot.web.model.UserDTO;
import springBoot.web.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Component
public class DtoToEntity implements UtilService {

    private UserService userService;

    @Autowired
    public DtoToEntity(UserService userService) {
        this.userService = userService;
    }

    @Override
    public User getConvertToUser(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setAge(userDTO.getAge());
        user.setRoles(userDTO.getRoles());
        return user;
    }


    @Override
    public List<Role> getRoleForUser(String role) {
        List<Role> roles = new ArrayList<>();
        Role indexRole = new Role();
        try {
            String[] partsRole = role.split("[, ]");
            indexRole = userService.getRoleByName(partsRole[1]);
            roles.add(indexRole);
            indexRole = userService.getRoleByName(partsRole[0]);
            roles.add(indexRole);
            return roles;
        } catch (Exception e) {

        }
        indexRole = userService.getRoleByName(role);
        roles.add(indexRole);
        return roles;
    }
}
