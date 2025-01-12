package hiber.DAO;

import hiber.models.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Component
public class ImplementUserInterface implements UserInterface {

//    @Autowired
//    LocalContainerEntityManagerFactoryBean entityManagerFactoryBean;


    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public List<User> getAllUsers() {
        @SuppressWarnings("unchecked")
        List allUsers = entityManager.createQuery("select p from User p",User.class)
                .getResultList();
        return allUsers;
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        entityManager.persist(user);
    }


}
