package spring.openshift.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spring.openshift.entity.User;
import spring.openshift.exceptions.NullUserException;
import spring.openshift.exceptions.UsernameNotFoundException;
import spring.openshift.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/users/graphic")
public class UserGUIController {

    private UserService userService;

    public UserGUIController(UserService theUserService) {
        userService = theUserService;
    }

    @PostMapping("/add")
    public String addNewUser(@ModelAttribute("user") User user) throws NullUserException {
        userService.save(user);
        return "redirect:/users/graphic/allUsers";
    }

    @GetMapping("/remove")
    public String deleteUser(@RequestParam("userId") int id) throws UsernameNotFoundException {
        userService.deleteById(id);
        return "redirect:/users/graphic/allUsers";
    }

    @GetMapping("/allUsers")
    public String findAllUsers(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "/users/list-users";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "/users/user-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("userId") int theId,
                                    Model model) throws UsernameNotFoundException {
        User user = userService.findById(theId);
        model.addAttribute("user", user);
        return "/users/user-form";
    }
}
