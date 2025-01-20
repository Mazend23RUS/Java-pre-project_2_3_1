package hiber.service;


import hiber.models.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;


public interface ServiceUserInterface {

    List<User> getAllUsersList();

    void addUser(User user);

    void deleteUser(Long id);


}
