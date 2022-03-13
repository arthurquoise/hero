package cesi.hero.repositories;

import cesi.hero.model.Incident;
import org.springframework.data.repository.CrudRepository;

public interface IncidentRepository extends CrudRepository<Incident, Integer> {

}
