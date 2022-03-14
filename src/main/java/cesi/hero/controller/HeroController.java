package cesi.hero.controller;

import cesi.hero.model.Hero;
import cesi.hero.model.Incident;
import cesi.hero.repositories.HeroRepository;
import cesi.hero.repositories.IncidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.EntityNotFoundException;
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
    public ModelAndView getHeroes(){
        List<Hero> heroes = (List<Hero>) _heroRepository.findAll();
        ModelAndView modelAndView = new ModelAndView("heroes");
        modelAndView.addObject("heroes", heroes);
        return modelAndView;
    }

    @GetMapping("/register")
    public String RegisterForm(Model model){
        List<Incident> incidents = (List<Incident>) this._incidentRepository.findAll();
        model.addAttribute("hero", new Hero());
        model.addAttribute("incidents", incidents);
        return "register";
    }

    @PostMapping("/register")
    public String RegisterSubmit(
            @ModelAttribute Hero hero,
            @RequestParam(value="incidents", required = false) int[]incidents,
            BindingResult bindingResult,
            Model model){

        if(incidents != null){

            for(int i = 0; i < incidents.length; i++){
                Incident incident;
                System.out.println(incidents[i]);
                if (_incidentRepository.existsById(incidents[i])){
                    incident = _incidentRepository.findById(incidents[i]).get();
                    hero.getIncidents().add(incident);
                }

            }


        }
    return "";
    }
}
