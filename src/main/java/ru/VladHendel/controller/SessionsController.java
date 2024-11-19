package ru.VladHendel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.VladHendel.domain.Hall;
import ru.VladHendel.domain.Session;
import ru.VladHendel.domain.Show;
import ru.VladHendel.repos.HallRepo;
import ru.VladHendel.repos.SessionRepo;
import ru.VladHendel.repos.ShowRepo;

import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping("/session")
public class SessionsController {
    @Autowired
    SessionRepo sessionRepo;
    @Autowired
    ShowRepo showRepo;
    @Autowired
    HallRepo hallRepo;

    @GetMapping
    public String sesionList(Model model) {
        model.addAttribute("sessions", sessionRepo.findAll());
        return "sessionList";
    }


    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/addSession")
    public String addSession(@RequestParam Long showId,
                             @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") Date date,
                             @RequestParam Long hallId,
                             Map<String, Object> model) {
        Show show = showRepo.findById(showId).orElse(null);
        Hall hall = hallRepo.findById(hallId).orElse(null);

        if (show != null && hall != null && date != null) {
            Session session = new Session();
            session.setShow(show);
            session.setDate(date);
            session.setHall(hall);
            session.setAvailableSeats(hall.getSeatCapacity());
            sessionRepo.save(session);
        }
        Iterable<Session> sessions = sessionRepo.findAll();
        model.put("sessions", sessions);
        return "redirect:/session/admin";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/delete")
    public String deleteSession(@RequestParam Long sessionId) {
        sessionRepo.deleteById(sessionId);
        return "redirect:/session/admin";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/admin")
    public String adminSessions(Model model) {
        model.addAttribute("sessions", sessionRepo.findAll());
        model.addAttribute("shows", showRepo.findAll());
        model.addAttribute("halls", hallRepo.findAll());
        return "sessionsAdmin";
    }

    
}
