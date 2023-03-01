package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.repository.RoleRepository;
import ru.kata.spring.boot_security.demo.service.UserService;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;

    private final RoleRepository roleRepository;

    @Autowired
    public AdminController(UserService userService, RoleRepository roleRepository) {
        this.userService = userService;
        this.roleRepository = roleRepository;
    }

    @GetMapping("/admin")
    public String showAdmin(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "admin";
    }

    @GetMapping("{id}/edit")
    public String edit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("user", userService.getUserById(id));
        model.addAttribute("allRoles", roleRepository.findAll());
        return "edit";
    }

    /*@GetMapping("/create")
    public String createUser(User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("listRoles", userService.roleList());
        return "create";
    }
    @PostMapping("/create")
    public String create(User user) {
        userService.cryptPass(user.getPassword(), user);
        userService.addUser(user);
        return "redirect:/admin";
    }

    @PostMapping()
    public String addUser(@ModelAttribute("user") User user) {
        userService.cryptPass(user.getPassword(), user);
        userService.addUser(user);
        return "redirect:/admin";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.removeUser(id);
        return "redirect:/admin";
    }

    @PatchMapping("/{id}")
    public String editUser(@PathVariable("id") int id, @ModelAttribute("user") User user) {
        userService.cryptPass(user.getPassword(), user);
        userService.updateUser(id, user);
        return "redirect:/admin";
    }*/
}
