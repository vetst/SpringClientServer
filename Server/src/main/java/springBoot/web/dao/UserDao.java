package springBoot.web.dao;


import springBoot.web.model.Role;
import springBoot.web.model.User;

import java.util.List;

public interface UserDao {

    public List<User> getAllUsers();

    public void addRole(Role role);

    public Role getRoleByName(String name);

    public void addUser(User user);

    public void removeUser(long id);

    public void updateUser(User user);

    public boolean isNotReg(String name);

    public User getUserById(long id);

    public User getUserByName(String name);
}

