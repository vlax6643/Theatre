package ru.VladHendel.controller;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.VladHendel.domain.Ganre;
import ru.VladHendel.domain.Hall;
import ru.VladHendel.domain.Show;
import ru.VladHendel.repos.HallRepo;

import java.util.Map;

@Controller
@RequestMapping("/hall")
public class HallsController {
    @Autowired
    HallRepo hallRepo;

    @GetMapping
    public String hallsList(Model model){
        model.addAttribute("halls", hallRepo.findAll());
        return "hallList";
    }


    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/addHall")
    public String addHall(@RequestParam String hallName,
                          @RequestParam int seatCapacity,
                          Map<String, Object> model) {
        if (hallName != null && !hallName.isEmpty()) {
            Hall hall = new Hall();
            hall.setName(hallName);
            hall.setSeatCapacity(seatCapacity);
            hallRepo.save(hall);
        }
        Iterable<Hall> halls = hallRepo.findAll();
        model.put("halls", halls);
        return "redirect:/hall/admin";
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/delete")
    public String deleteHall(@RequestParam Long hallId) {
        hallRepo.deleteById(hallId);
        return "redirect:/hall/admin";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/admin")
    public String adminHallsList(Model model) {
        model.addAttribute("halls", hallRepo.findAll());
        return "hallsAdmin";
    }

}
