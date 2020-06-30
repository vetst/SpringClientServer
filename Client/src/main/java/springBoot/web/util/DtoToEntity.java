package springBoot.web.util;

import org.springframework.stereotype.Component;
import springBoot.web.model.Role;
import springBoot.web.model.User;
import springBoot.web.model.UserDTO;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class DtoToEntity implements UtilService {

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

    public UserDTO getConvertToUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());
        userDTO.setAge(user.getAge());
        userDTO.setRoles(user.getRoles());
        return userDTO;
    }

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
