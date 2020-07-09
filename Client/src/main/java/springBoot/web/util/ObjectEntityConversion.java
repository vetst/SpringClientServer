package springBoot.web.util;

import springBoot.web.model.User;
import springBoot.web.model.UserDTO;

public interface ObjectEntityConversion {
    public User convert(UserDTO userDTO);
}
