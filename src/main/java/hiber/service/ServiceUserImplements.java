package hiber.service;

import hiber.DAO.ImplementUserInterface;
import hiber.DAO.UserInterface;
import hiber.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
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
}
