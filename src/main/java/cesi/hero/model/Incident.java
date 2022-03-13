package cesi.hero.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Incident")
public class Incident {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IncidentID")
    private int incidentId;

    @Column(name = "Libelle", nullable = false)
    private String libelle;

    @ManyToMany(mappedBy = "incidents")
    private List<Hero> heroes;

    public Incident(){

    }

    public int getIncidentId() {
        return incidentId;
    }

    public void setIncidentId(int incidentId) {
        this.incidentId = incidentId;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }


    public List<Hero> getHeroes() {
        return heroes;
    }

    public void setHeroes(List<Hero> heroes) {
        this.heroes = heroes;
    }
}
