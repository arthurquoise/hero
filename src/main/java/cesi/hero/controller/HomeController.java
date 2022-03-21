package cesi.hero.controller;

import cesi.hero.model.Hero;
import cesi.hero.model.Incident;
import cesi.hero.repositories.HeroRepository;
import cesi.hero.repositories.IncidentRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
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

//    @PostMapping("/search")
//    public ModelAndView searchHeroes(
//            Map<String, Object> model,
//            @RequestParam(name="incidentId") Integer incidentId,
//            @RequestParam(name="latitude") String latitude,
//            @RequestParam(name="longitude") String longitude,
//            @RequestParam(name="ville") String ville) throws JsonProcessingException {
//
//        String json = "";
//        ModelAndView modelAndView;
//        List<Hero>heroes;
//        ObjectMapper mapper = new ObjectMapper();
//        mapper.enable(SerializationFeature.INDENT_OUTPUT);
//        modelAndView = new ModelAndView("search");
//
//        Incident incident = this._incidentRepository.findById(incidentId).get();
//
//        if(incident != null){
//
//            heroes = this._heroRepository.FindHeroesWithSpecificIncident(incident.getIncidentId());
//
//            try {
//
//                // get Organisation object as a json string
//                json = mapper.writeValueAsString(heroes);
//
//                // Displaying JSON String
//                System.out.println(json);
//            }
//
//            catch (IOException e) {
//                e.printStackTrace();
//            }
//
//
//            String city = String.format("[%s, %s]", latitude, longitude);
//            model.put("heroes", json);
//            model.put("city", city);
//        }
//
//        return modelAndView;
//
//    }

    @GetMapping("/search")
    public String getMap(){
        return "search";
    }
}
