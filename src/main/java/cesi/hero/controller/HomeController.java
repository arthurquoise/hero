package cesi.hero.controller;

import cesi.hero.model.Hero;
import cesi.hero.model.Incident;
import cesi.hero.repositories.HeroRepository;
import cesi.hero.repositories.IncidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private IncidentRepository _incidentRepository;

    @Autowired
    private HeroRepository _heroRepository;

    @GetMapping("/")
    public ModelAndView getHome(){
        ModelAndView modelAndView;
        modelAndView = new ModelAndView("home");
        List<Incident> incidents = (List<Incident>) this._incidentRepository.findAll();
        modelAndView.addObject("incidents", incidents);
        return modelAndView;
    }

    @PostMapping("/search")
    public String searchHeroes(
            @RequestParam(name="incidentId") Integer incidentId,
            @RequestParam(name="latitude") String latitude,
            @RequestParam(name="longitude") String longitude,
            @RequestParam(name="ville") String ville){

        List<Hero>Heroes;
        Incident incident = this._incidentRepository.findById(incidentId).get();

        if(incident != null){
            Heroes = this._heroRepository.FindHeroesWithSpecificIncident(incident.getIncidentId());
            System.out.println(Heroes.size());
        }
        return "";
    }

    @GetMapping("/search")
    public String getMap(){
        return "search";
    }
}
