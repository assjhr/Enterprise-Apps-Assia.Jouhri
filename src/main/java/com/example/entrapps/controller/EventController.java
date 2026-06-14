package com.example.entrapps.controller;

import com.example.entrapps.model.ContactMessage;
import com.example.entrapps.model.Event;
import com.example.entrapps.model.Locatie;
import com.example.entrapps.repository.EventRepository;
import com.example.entrapps.repository.LocatieRepository;
import com.example.entrapps.service.MailService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class EventController {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private LocatieRepository locatieRepository;

    @Autowired
    private MailService mailService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("events", eventRepository.findTop10ByOrderByTijdstipDesc());
        return "index";
    }

    @GetMapping("/new")
    public String newEvent(Model model) {
        model.addAttribute("event", new Event());
        model.addAttribute("locaties", locatieRepository.findAll());
        return "new";
    }

    @PostMapping("/new")
    public String saveEvent(@Valid @ModelAttribute("event") Event event,
                            BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("locaties", locatieRepository.findAll());
            return "new";
        }
        eventRepository.save(event);
        return "redirect:/";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable Long id, Model model) {
        Event event = eventRepository.findById(id).orElse(null);
        model.addAttribute("event", event);
        return "details";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/contact")
    public String contact(Model model) {
        model.addAttribute("message", new ContactMessage());
        return "contact";
    }

    @PostMapping("/contact")
    public String sendContact(@Valid @ModelAttribute("message") ContactMessage message,
                              BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "contact";
        }
        mailService.sendContactEmail(message.getEmail(), message.getNaam(), message.getBericht());
        model.addAttribute("sent", true);
        return "contact";
    }
}
