package springBoot.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springBoot.web.dao.UserDao;
import springBoot.web.model.Role;
import springBoot.web.model.User;
import springBoot.web.util.UtilService;

import java.util.List;

@Service
public class ServerServiceImp implements UserService {

    private UserDao dao;
    private UtilService utilService;

    @Autowired
    public void setUtilService(UtilService utilService) {
        this.utilService = utilService;
    }

    @Autowired
    public ServerServiceImp(UserDao dao) {
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

            dao.addUser(user);
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
            dao.updateUser(user);
            return true;
        }
        return false;
    }

    @Transactional
    @Override
    public String ifPasswordNull(Long id, String password) {
        if (password.trim().length() == 0) {
            return dao.getUserById(id).getPassword();
        }
        return password;
    }

    @Transactional
    @Override
    public User getUserByName(String email) {
        return dao.getUserByName(email);
    }

    @Override
    public Role getRoleByName(String name) {
        return dao.getRoleByName(name);
    }
}