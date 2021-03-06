package springBoot.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springBoot.web.dao.UserDao;
import springBoot.web.model.Role;
import springBoot.web.model.User;

import java.util.ArrayList;
import java.util.List;

@Service
public class InitServiceImpl implements InitService {

    private UserDao userDao;

    @Autowired
    public InitServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public void addAdminAndUser() {
        if (!userDao.isNotReg("admin@mail.com")) {

            userDao.addRole(new Role("ADMIN"));
            userDao.addRole(new Role("USER"));
            List<Role> admin = new ArrayList<>();
            admin.add(userDao.getRoleByName("ADMIN"));
            admin.add(userDao.getRoleByName("USER"));
            userDao.addUser(new User("Иван", "admin", "Иванов", "admin@mail.com", 35, admin));

            List<Role> user = new ArrayList<>();
            user.add(userDao.getRoleByName("USER"));
            userDao.addUser(new User("Петр", "user", "Петров", "user@mail.com", 25, user));
        }
    }
}
