package ru.kata.spring.boot_security.demo.controllers;



import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kata.spring.boot_security.demo.entity.User;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String showAllUsers(ModelMap model) {
        if(userService.getAllUsers().isEmpty()) {
            return "zeroPage";
        } else {
            List<User> users = new ArrayList<>();
            for(User user: userService.getAllUsers()) {
                users.add(user);
            }
            model.addAttribute("users", users);
            return "UsersView";
        }
    }

    @GetMapping("add")
    public String addUser(ModelMap modelMap) {
        modelMap.addAttribute("user", new User());
        return "addUser";
    }

    @PostMapping("save")
    public String saveNewUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/";
    }

    @PostMapping("delete")
    public String deleteUser(@RequestParam("Id") String id) {
        userService.deleteUserById(Integer.parseInt(id));
        return "redirect:/";
    }

    @PostMapping("update")
    public String updateUser(@RequestParam("user") String Id, ModelMap model) {
        model.addAttribute("user", userService.getUserById(Integer.parseInt(Id)));
        return "updateUser";
    }

    @PostMapping("updating")
    public String updatingUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/";
    }
}
