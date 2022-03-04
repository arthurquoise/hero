package cesi.hero.model;

import javax.persistence.*;


@Entity
@Table(name = "Hero")
public class Hero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "HeroID")
    private int heroId;

    @Column(name = "Nom", nullable = false)
    private String nom;

    @Column(name = "Ville", nullable = false)
    private String ville;

    @Column(name = "VilleLatitude", nullable = false)
    private String villeLatitude;

    @Column(name = "VilleLongitude", nullable = false)
    private String villeLongitude;

    @Column(name = "Telephone", nullable = false)
    private String telephone;

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
}
