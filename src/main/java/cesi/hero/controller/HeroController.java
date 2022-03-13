package cesi.hero.controller;

import cesi.hero.model.Hero;
import cesi.hero.repositories.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@Controller
public class HeroController {

    final
    HeroRepository _heroRepository;

    public HeroController(HeroRepository _heroRepository) {
        this._heroRepository = _heroRepository;
    }

    @RequestMapping("/")
    public String getHeroes(Model model){
        List<Hero> heroes = (List<Hero>) _heroRepository.findAll();
        model.addAttribute("heroes", heroes);
        return "heroes";
    }
}
