package spring.openshift.controller;

import org.springframework.web.bind.annotation.*;
import spring.openshift.entity.User;
import spring.openshift.exceptions.NullUserException;
import spring.openshift.exceptions.UpdateUserException;
import spring.openshift.exceptions.UsernameNotFoundException;
import spring.openshift.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService theUserService) {
        userService = theUserService;
    }

    @GetMapping("/findUserById")
    public User getUserDetailsById(@RequestParam int userId) throws UsernameNotFoundException {
        return userService.findById(userId);
    }

    @GetMapping("/findUserByName")
    public User getUserDetailsByName(@RequestParam String name) throws UsernameNotFoundException {
        return userService.findByName(name);
    }

    @PostMapping("/add")
    public String addNewUser(@RequestBody User user) throws NullUserException {
        userService.save(user);
        return "User " + user.getName() + " saved successfully";
    }

    @DeleteMapping("/remove/{id}")
    public String deleteUser(@PathVariable int id) throws UsernameNotFoundException {
        userService.deleteById(id);
        return "User with id " + id + " was deleted successfully";
    }

    @PutMapping("/update/{id}")
    User replaceUser(@RequestBody User newUser, @PathVariable int id) throws UpdateUserException {
        return userService.updateUserById(newUser, id);
    }

    @GetMapping("/allUsers")
    public List<User> findAllUsers() {
        return userService.findAll();
    }
}
