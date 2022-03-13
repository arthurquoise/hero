package cesi.hero.controller;

import cesi.hero.model.Hero;
import cesi.hero.model.Incident;
import cesi.hero.repositories.HeroRepository;
import cesi.hero.repositories.IncidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@Controller
public class HeroController {

    final
    HeroRepository _heroRepository;
    IncidentRepository _incidentRepository;

    public HeroController(HeroRepository _heroRepository, IncidentRepository _incidentRepository) {
        this._heroRepository = _heroRepository;
        this._incidentRepository = _incidentRepository;
    }

    @RequestMapping("/")
    public String getHeroes(Model model){
        List<Hero> heroes = (List<Hero>) _heroRepository.findAll();
        model.addAttribute("heroes", heroes);
        return "heroes";
    }

    @RequestMapping("/register")
    public String RegisterForm(Model model){
        List<Incident> incidents = (List<Incident>) this._incidentRepository.findAll();
        model.addAttribute("hero", new Hero());
        model.addAttribute("incidents", incidents);
        return "register";
    }

    @PostMapping("/register")
    public String RegisterSubmit(@ModelAttribute Hero hero, Model model){

    return "";
    }
}
