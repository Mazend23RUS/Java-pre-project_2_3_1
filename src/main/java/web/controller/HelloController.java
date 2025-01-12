package web.controller;

import hiber.models.User;
import hiber.service.ServiceUserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@Controller
//@RestController
//@RequestMapping(value = "/", method = RequestMethod.GET)
public class HelloController {

    @Autowired
    private ServiceUserInterface serviceUserInterface;


    @GetMapping("/")
    public String printWelcome(ModelMap model) {
        model.addAttribute("allUsers", serviceUserInterface.getAllUsersList());
        return "index";
    }


//    @GetMapping(value = "calculator")
//    public String printCalculator(@RequestParam (value = "a" ,required = false) int a,
//                                  @RequestParam (value = "b", required = false) int b,
//                                  @RequestParam (value = "action", required = false) String action,  Model model){
//    model.addAttribute("calcul","Результат вычислений : " + a + action + b);
//    return "calculator";
//    }

//    @RequestMapping(value = "users/{userName}", method = RequestMethod.POST)
    @PostMapping("/adduser")
    public String saveNewUser(@RequestParam String userName,
                              @RequestParam (required = false) String userSurname,
                              @RequestParam (required = false) Integer age, ModelMap model) {
        User user = new User(userName, userSurname, age);

        model.addAttribute("user", user);
        serviceUserInterface.addUser(user);

        return "confirmation";
    }

    @GetMapping("/adduser")
    public String savePage() {
        return "adduser";
    }

//    @PostMapping("/")
//    public String saveUser(@ModelAttribute("user"), ModelMap map){}
//
//    @GetMapping("/cars/{count}")
//    public String indexId(@RequestParam("count") int count, Model model) {
//        Car car = new Car();
//        model.addAttribute("carResultPage", car.getListbyID(count));
//        return "resultList";
//    }
//
//    @GetMapping(value = "/quantityOfCars")
//    public String getQuantityOfCars(Model model) {
//        int quantityOfCars;
//        Car car1 = new Car();
//        quantityOfCars = car1.creatingListCars().size();
//        model.addAttribute("quantity", quantityOfCars);
//        return "quantityOfCars";
//
//    }
}