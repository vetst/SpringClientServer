package springBoot.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springBoot.web.dao.UserDao;
import springBoot.web.model.Role;
import springBoot.web.model.User;
import springBoot.web.util.DtoToEntity;
import springBoot.web.util.UserRole;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserDao dao;
    private DtoToEntity dtoToEntity;
    private UserRole userRole;

    @Autowired
    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    @Autowired
    public void setUtilService(DtoToEntity dtoToEntity) {
        this.dtoToEntity = dtoToEntity;
    }

    @Autowired
    public UserServiceImpl(UserDao dao) {
        this.dao = dao;
    }

    @Override
    public List<User> getAllUsers() {
        return dao.getAllUsers();
    }

    @Transactional
    @Override
    public boolean addUser(User user) {
        if (user != null) {
            dao.addUser(userRole.getUserWithRole(user));
            return true;
        }
        return false;
    }

    @Transactional
    @Override
    public boolean removeUser(long id) {
        if (id != 0) {
            dao.removeUser(id);
            return true;
        }
        return false;
    }

    @Transactional
    @Override
    public boolean updateUser(User user) {
        if (user != null) {
            dao.updateUser(userRole.getUserWithRole(user));
            return true;
        }
        return false;
    }

    @Override
    public String ifPasswordNull(Long id, String password) {
        if (password.trim().length() == 0) {
            return dao.getUserById(id).getPassword();
        }
        return password;
    }

    @Override
    public User getUserByName(String email) {
        return dao.getUserByName(email);
    }

    @Override
    public Role getRoleByName(String name) {
        return dao.getRoleByName(name);
    }
}