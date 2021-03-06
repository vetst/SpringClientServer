package springBoot.web.util;

import org.springframework.stereotype.Component;
import springBoot.web.model.User;
import springBoot.web.model.UserDTO;

@Component
public class ObjectEntityConversionImpl implements ObjectEntityConversion {

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

    public UserDTO convert(User user) {
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
}
