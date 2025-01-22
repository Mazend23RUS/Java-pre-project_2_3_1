package hiber.service;

import hiber.DAO.ImplementUserInterface;
import hiber.DAO.UserInterface;
import hiber.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class ServiceUserImplements implements ServiceUserInterface {
   @Autowired
   private UserInterface userInterface;

    @Override
    public void addUser(User user){
        userInterface.saveUser(user);
    }

    @Override
    public List<User> getAllUsersList() {
        return userInterface.getAllUsers();
    }
    @Override
    public void deleteUser(Long id) { userInterface.deleteUser(id);}

    @Override
    public void updateUser(User user){
        userInterface.updateUser(user);
    }

    @Override
    public User getUserById(Long id){

        return userInterface.getUserById(id);
    }
}
