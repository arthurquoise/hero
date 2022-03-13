CREATE TABLE Hero(
   HeroID INT,
   Nom VARCHAR(50)  NOT NULL,
   Ville VARCHAR(50)  NOT NULL,
   VilleLatitude VARCHAR(50)  NOT NULL,
   VilleLongitude VARCHAR(50)  NOT NULL,
   Telephone VARCHAR(10)  NOT NULL,
   PRIMARY KEY(HeroID)
);

CREATE TABLE Incident(
   IncidentID INT,
   Libelle VARCHAR(50)  NOT NULL,
   PRIMARY KEY(IncidentID)
);

CREATE TABLE IncidentHero(
   HeroID INT,
   IncidentID INT,
   PRIMARY KEY(HeroID, IncidentID),
   FOREIGN KEY(HeroID) REFERENCES Hero(HeroID),
   FOREIGN KEY(IncidentID) REFERENCES Incident(IncidentID)
);
