package cesi.hero.repositories;

import cesi.hero.model.Hero;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HeroRepository extends CrudRepository<Hero, Integer> {

    @Query("select i.heroes from Incident i join i.heroes where i.incidentId = :id")
    List<Hero> FindHeroesWithSpecificIncident(@Param("id") Integer id);
}
