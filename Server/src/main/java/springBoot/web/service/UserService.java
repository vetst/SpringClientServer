package springBoot.web.service;

import springBoot.web.model.Role;
import springBoot.web.model.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();

    public boolean addUser(User user);

    public boolean removeUser(long id);

    public boolean updateUser(User user);

    public String ifPasswordNull(Long id, String password);

    public User getUserByName(String email);

    public Role getRoleByName(String name);
}
