package ru.VladHendel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.VladHendel.domain.Ganre;
import ru.VladHendel.domain.Session;
import ru.VladHendel.domain.Show;
import ru.VladHendel.repos.GanreRepo;
import ru.VladHendel.repos.SessionRepo;
import ru.VladHendel.repos.ShowRepo;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
public class MainController {
    @Autowired
    private ShowRepo showRepo;
    @Autowired
    private GanreRepo ganreRepo;

    @Autowired
    private SessionRepo sessionRepo;
    @GetMapping("/")
    public String greeting(Map<String, Object> model) {

        return "greeting";
    }

    @GetMapping("/main")
    public String main(@RequestParam(required = false, defaultValue = "") String filter, Model model) {
        Iterable<Show> show = showRepo.findAll();
        if (filter != null && !filter.isEmpty()) {
            show = showRepo.findByTitle(filter);
        } else {
            show = showRepo.findAll();
        }
        Iterable<Ganre> ganre = ganreRepo.findAll();
        model.addAttribute("shows", show);
        model.addAttribute("filter", filter);
        model.addAttribute("ganres", ganre);
        return "main";
    }



    @GetMapping("/shows/{showId}")
    public String showDetails(@PathVariable Long showId, Model model) {
        Show show = showRepo.findById(showId)
                .orElseThrow(() -> new RuntimeException("Спектакль не найден"));

        model.addAttribute("show", show);
        return "showDetails";
    }



}