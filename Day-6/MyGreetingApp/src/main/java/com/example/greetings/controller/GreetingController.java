package com.example.greetings.controller;

import com.example.greetings.model.Greeting;
import com.example.greetings.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class GreetingController {

    private final GreetingRepository repository;

    @Autowired
    public GreetingController(GreetingRepository repository) {
        this.repository = repository;
    }

    //READ - home page shows all greetings and create form
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("greetings", repository.findAll());
        model.addAttribute("greeting", new Greeting());
        return "index";
    }

    // CREATE - saves a new greeting
    @PostMapping("/greetings")
    public String create(@RequestParam String name, @RequestParam String message) {
        repository.save(new Greeting(name, message));
        return "redirect:/";
    }

    // READ - shows one greeting
    @GetMapping("/greetings/{id}")
    public String show(@PathVariable Long id, Model model) {
        model.addAttribute("greeting", repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Greeting not found: " + id)));
        return "greeting";
    }

    // UPDATE - shows edit form
    @GetMapping("/greetings/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("greeting", repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Greeting not found: " + id)));
        return "edit";
    }

    // UPDATE - saves edited greeting
    @PostMapping("/greetings/{id}")
    public String update(@PathVariable Long id, @RequestParam String name, @RequestParam String message) {
        Greeting greeting = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Greeting not found: " + id));
        greeting.setName(name);
        greeting.setMessage(message);
        repository.save(greeting);
        return "redirect:/";
    }

    // DELETE - removes a greeting
    @PostMapping("/greetings/{id}/delete")
    public String delete(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/";
    }
}
