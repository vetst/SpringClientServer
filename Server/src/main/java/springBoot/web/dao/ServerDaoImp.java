package springBoot.web.dao;

import org.springframework.stereotype.Repository;
import springBoot.web.model.Role;
import springBoot.web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ServerDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }
    @Override
    public void addRole(Role role){
        entityManager.persist(role);
    }

    @Override
    public Role getRoleByName(String name) {
        return (Role) entityManager.createQuery("SELECT u FROM Role u WHERE u.name =?1")
                .setParameter(1, name).getSingleResult();
    }
    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void removeUser(long id) {

        entityManager.createQuery("DELETE from User where id = :id")
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public boolean isNotReg(String email) {
        return getAllUsers()
                .stream()
                .anyMatch((e) -> e.getEmail().equals(email));
    }

    @Override
    public User getUserById(long id) {
        return (User) entityManager.createQuery("From User where id =:id")
                .setParameter("id", id).getSingleResult();
    }

    @Override
    public User getUserByName(String email) {
        return (User) entityManager.createQuery("From User where email =:email")
                .setParameter("email", email).getSingleResult();
    }
}
