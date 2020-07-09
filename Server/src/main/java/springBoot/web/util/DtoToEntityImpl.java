package springBoot.web.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import springBoot.web.model.User;
import springBoot.web.model.UserDTO;
import springBoot.web.service.UserService;

@Component
public class DtoToEntityImpl implements DtoToEntity {

    private UserService userService;

    @Autowired
    public DtoToEntityImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public User convert(UserDTO userDTO) {
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
}
