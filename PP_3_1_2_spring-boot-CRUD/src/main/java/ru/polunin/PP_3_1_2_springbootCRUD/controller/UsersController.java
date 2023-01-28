package ru.polunin.PP_3_1_2_springbootCRUD.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.polunin.PP_3_1_2_springbootCRUD.model.User;
import ru.polunin.PP_3_1_2_springbootCRUD.service.UserService;


@Controller
//@RequestMapping("/users")
public class UsersController {
    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String getUsersTable(Model model) {
        model.addAttribute("userList", userService.findAll());
        return "users";
    }
    @GetMapping(value = "/{id}")
    public String getUserById(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.findById(id));
        return "user";
    }
    @GetMapping(value = "/new")
    public String newUser(/*@ModelAttribute("User") User user*/ Model model) {
        model.addAttribute("user", new User());
        return "new";
    }
    @PostMapping("/")
    public String addUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/";
    }
    @GetMapping(value = "/{id}/edit")
    public String editUser(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.findById(id));
        return "edit";
    }
    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("user") User user, @PathVariable("id") Long id) {
        userService.update(id, user);
        return "redirect:/";
    }
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.delete(id);
        return "redirect:/";
    }
}
