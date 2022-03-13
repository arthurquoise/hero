CREATE TABLE Hero(
   HeroID INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
   Nom VARCHAR(50)  NOT NULL,
   Ville VARCHAR(50)  NOT NULL,
   VilleLatitude VARCHAR(50)  NOT NULL,
   VilleLongitude VARCHAR(50)  NOT NULL,
   Telephone VARCHAR(10)  NOT NULL
);

CREATE TABLE Incident(
   IncidentID INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
   Libelle VARCHAR(50)  NOT NULL
);

CREATE TABLE IncidentHero(
   HeroID INT,
   IncidentID INT,
   PRIMARY KEY(HeroID, IncidentID),
   FOREIGN KEY(HeroID) REFERENCES Hero(HeroID),
   FOREIGN KEY(IncidentID) REFERENCES Incident(IncidentID)
);

INSERT INTO incident (Libelle)
VALUES
    ('Incendie'),
    ('Accident routier'),
    ('Accident fluviale'),
    ('Accident aérien'),
    ('Invasion de serpent'),
    ('Fuite de gaz'),
    ('Manifestation'),
    ('Braquage'),
    ('Evasion d’un prisonnier')
