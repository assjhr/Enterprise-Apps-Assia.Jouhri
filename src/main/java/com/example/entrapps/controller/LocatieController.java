package com.example.entrapps.controller;

import com.example.entrapps.model.Locatie;
import com.example.entrapps.repository.LocatieRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class LocatieController {

    @Autowired
    private LocatieRepository locatieRepository;

    @GetMapping("/locaties")
    public String locaties(Model model) {
        model.addAttribute("locaties", locatieRepository.findAll());
        model.addAttribute("locatie", new Locatie());
        return "locaties";
    }

    @PostMapping("/locaties")
    public String saveLocatie(@Valid @ModelAttribute("locatie") Locatie locatie,
                              BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("locaties", locatieRepository.findAll());
            return "locaties";
        }
        locatieRepository.save(locatie);
        return "redirect:/locaties";
    }

    @GetMapping("/locaties/delete/{id}")
    public String deleteLocatie(@PathVariable Long id) {
        locatieRepository.deleteById(id);
        return "redirect:/locaties";
    }
}
