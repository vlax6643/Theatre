package ru.VladHendel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.VladHendel.domain.Role;
import ru.VladHendel.domain.User;
import ru.VladHendel.repos.UsersRepo;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;

@Controller
public class RegistrationController {
    @Autowired
    private UsersRepo usersRepo;
    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("registration")
    public String addUser(User user, Model model){
        User userFromDb = (User) usersRepo.findByUsername(user.getUsername());
        if (userFromDb != null){
            model.addAttribute("message", "User exists");
            return "registration";
        }
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        usersRepo.save(user);

        return "redirect:/login";
    }
}
