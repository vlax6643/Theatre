package ru.VladHendel.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.VladHendel.domain.Role;
import ru.VladHendel.domain.User;
import ru.VladHendel.repos.UsersRepo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/user")
@PreAuthorize("hasAuthority('ADMIN')")
public class UserController {
    @Autowired
    UsersRepo usersRepo;

    @GetMapping
    public String userList(Model model){
        model.addAttribute("users", usersRepo.findAll());
        return "userList";
    }

    @GetMapping("{user}")
    public String userEditForm(@PathVariable User user, Model model){
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());
        return "userEdit";
    }

    @PostMapping
    public String userSave(
            @RequestParam String username,
            @RequestParam(required = false) String[] roles,
            @RequestParam("userId") User user) {

        user.setUsername(username);
        user.getRoles().clear();

        if (roles != null) {
            for (String role : roles) {
                user.getRoles().add(Role.valueOf(role));
            }
        }

        usersRepo.save(user);
        return "redirect:/user";
    }

    @PostMapping("/deleteUser")
    public String deleteUser(@RequestParam Long userId) {
        usersRepo.deleteById(userId);
        return "redirect:/user";
    }

}
