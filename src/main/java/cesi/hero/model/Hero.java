package cesi.hero.model;

import javax.validation.constraints.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;


@Entity
@Table(name = "Hero")
public class Hero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "HeroID")
    private int heroId;

    @Size(min = 1)
    @NotNull(message = "La saisie du nom est obligatoire")
    @Column(name = "Nom", nullable = false)
    private String nom;

    @Size(min = 1)
    @NotNull(message = "La saisie de la vill est obligatoire")
    @Column(name = "Ville", nullable = false)
    private String ville;

    @Size(min = 1)
    @NotNull(message = "La saisie de la latitude est obligatoire")
    @Column(name = "VilleLatitude", nullable = false)
    private String villeLatitude;

    @Size(min = 1)
    @NotNull(message = "La saisie de la longitude est obligatoire")
    @Column(name = "VilleLongitude", nullable = false)
    private String villeLongitude;

    @NotNull
    @Size(min = 10, max = 10, message = "La saisie du numéro doit faire 10 caractères")
    @Column(name = "Telephone", nullable = false)
    private String telephone;

    @NotNull
    @Size(min = 1, max = 3, message = "Il faut choisir entre 1 et 3 incidents")
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "HeroIncident",
    joinColumns = {@JoinColumn(name = "HeroID")},
    inverseJoinColumns = {@JoinColumn(name = "IncidentID")})
    private List<Incident> incidents;

    public Hero(){

    }

    public Hero(String nom, String ville, String villeLatitude, String villeLongitude, String telephone) {
        this.nom = nom;
        this.ville = ville;
        this.villeLatitude = villeLatitude;
        this.villeLongitude = villeLongitude;
        this.telephone = telephone;
    }


    public int getHeroId() {
        return heroId;
    }

    public void setHeroId(int heroId) {
        this.heroId = heroId;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getVilleLatitude() {
        return villeLatitude;
    }

    public void setVilleLatitude(String villeLatitude) {
        this.villeLatitude = villeLatitude;
    }

    public String getVilleLongitude() {
        return villeLongitude;
    }

    public void setVilleLongitude(String villeLongitude) {
        this.villeLongitude = villeLongitude;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Incident> getIncidents() {
        return incidents;
    }

    public void setIncidents(List<Incident> incidents) {
        this.incidents = incidents;
    }
}
