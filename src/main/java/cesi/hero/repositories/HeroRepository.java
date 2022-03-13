package cesi.hero.repositories;

import cesi.hero.model.Hero;
import org.springframework.data.repository.CrudRepository;

public interface HeroRepository extends CrudRepository<Hero, Integer> {

}
