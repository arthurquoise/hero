package cesi.hero.controller;

import cesi.hero.model.Incident;
import cesi.hero.repositories.IncidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class IncidentController {

    final
    IncidentRepository _incidentRepository;

    public IncidentController(IncidentRepository _incidentRepository) {
        this._incidentRepository = _incidentRepository;
    }

    @RequestMapping("/incidents")
    public String getIncidents(Model model){
        List<Incident> incidents = (List<Incident>) _incidentRepository.findAll();
        model.addAttribute("incidents", incidents);
        return("incidents");
    }
}
