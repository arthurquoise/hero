package cesi.hero.controller;

import cesi.hero.model.Hero;
import cesi.hero.model.Incident;
import cesi.hero.repositories.HeroRepository;
import cesi.hero.repositories.IncidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("getHeroes")
public class HeroRestController {

    @Autowired
    private HeroRepository _heroRepository;

    @Autowired
    private IncidentRepository _incidentRepository;

    @GetMapping(value = "/{id}", produces = "application/json")
    public List<Hero> getHeroesByIncident(@PathVariable Integer id){
        List<Hero>heroes = new ArrayList<>();

        Incident incident = this._incidentRepository.findById(id).get();

        if(incident != null) {

            heroes = this._heroRepository.FindHeroesWithSpecificIncident(incident.getIncidentId());

            return heroes;
        }

        return heroes;
    }
}
