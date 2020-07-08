package springBoot.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springBoot.web.dao.UserDao;
import springBoot.web.model.Role;
import springBoot.web.model.User;
import springBoot.web.util.DtoToEntity;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServerServiceImp implements UserService {

    private UserDao dao;
    private DtoToEntity dtoToEntity;

    @Autowired
    public void setUtilService(DtoToEntity dtoToEntity) {
        this.dtoToEntity = dtoToEntity;
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
            List<Role> roles = user.getRoles();
            List<Role> indexRoles = new ArrayList();
            Role role;
            if (roles.size() == 2) {
                role = roles.get(0);
                indexRoles.add(dao.getRoleByName(role.getName()));
                role = roles.get(1);
                indexRoles.add(dao.getRoleByName(role.getName()));
                user.setRoles(indexRoles);
                dao.addUser(user);
                return true;
            } else {
                role = roles.get(0);
                indexRoles.add(dao.getRoleByName(role.getName()));
                user.setRoles(indexRoles);
                dao.addUser(user);
                return true;
            }
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
            List<Role> roles = user.getRoles();
            List<Role> indexRoles = new ArrayList();
            Role role;
            if (roles.size() == 2) {
                role = roles.get(0);
                indexRoles.add(dao.getRoleByName(role.getName()));
                role = roles.get(1);
                indexRoles.add(dao.getRoleByName(role.getName()));
                user.setRoles(indexRoles);
                dao.updateUser(user);
                return true;
            } else {
                role = roles.get(0);
                indexRoles.add(dao.getRoleByName(role.getName()));
                user.setRoles(indexRoles);
                dao.updateUser(user);
                return true;
            }
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