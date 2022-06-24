package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Set;

@Controller
public class AnimalShelterControl {

    private AnimalRepository animalRepository;

    public AnimalShelterControl(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @GetMapping("/")
    public String home(Model model) {
        Set<AnimalService> animals = animalRepository.findAll();
        model.addAttribute("animals", animals);
        return "home";
    }


    @GetMapping("/zwierzak")
    public String details(@RequestParam String imie, Model model) {
        AnimalService animal = animalRepository.findByName(imie);

        if(animal != null) {
            model.addAttribute("animal", animal);
            return "animal";
        } else {
            return "redirect:/";
        }
    }
}
