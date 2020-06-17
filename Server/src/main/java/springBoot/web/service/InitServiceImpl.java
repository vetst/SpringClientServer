package springBoot.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springBoot.web.dao.UserDao;
import springBoot.web.model.Role;
import springBoot.web.model.User;

import java.util.HashSet;
import java.util.Set;

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

            Set<Role> admin = new HashSet<>();
            admin.add(new Role("ADMIN"));
            admin.add(new Role("USER"));
            userDao.addUser(new User("Иван", "admin", "Иванов", "admin@mail.com", 35, admin));
            Set<Role> user = new HashSet<>();
            user.add(new Role("USER"));
            userDao.addUser(new User("Петр", "user", "Петров", "user@mail.com", 25, user));
        }
    }
}
