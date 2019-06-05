CREATE TABLE Ecole(
id_ecole int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
nom_ecole varchar(255) NOT NULL ,
adresse varchar(255) NOT NULL
);

CREATE TABLE AnneeScolaire(
id int(11) NOT NULL PRIMARY KEY
);

CREATE TABLE Trimestre(
id int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
numero int(11) NOT NULL,
debut varchar(255) NOT NULL,
fin varchar(255) NOT NULL,
id_anneeScolaire int(11) NOT NULL,
FOREIGN KEY (id_anneeScolaire) REFERENCES AnneeScolaire(id)
);

CREATE TABLE Niveau(
id int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
nom varchar(255) NOT NULL
);

CREATE TABLE Classe(
id int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
nom varchar(255) NOT NULL ,
id_ecole int(11) NOT NULL,
id_niveau int(11) NOT NULL,
id_anneeScolaire int(11) NOT NULL,
FOREIGN KEY (id_ecole) REFERENCES Ecole(id_ecole),
FOREIGN KEY (id_niveau) REFERENCES Niveau(id),
FOREIGN KEY (id_anneeScolaire) REFERENCES AnneeScolaire(id)
);

CREATE TABLE Discipline(
id int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
nom varchar(255) NOT NULL
);

CREATE TABLE Personne(
id int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
nom varchar(255) NOT NULL ,
prenom varchar(255) NOT NULL ,
type_ varchar(255) NOT NULL
);

CREATE TABLE Enseignement(
id int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
id_classe int(11) NOT NULL,
id_discipline int(11) NOT NULL,
id_personne int(11) NOT NULL,
FOREIGN KEY (id_classe) REFERENCES Classe(id),
FOREIGN KEY (id_discipline) REFERENCES Discipline(id),
FOREIGN KEY (id_personne) REFERENCES Personne(id)
);

CREATE TABLE Inscription(
id int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
id_classe int(11) NOT NULL,
id_personne int(11) NOT NULL,
FOREIGN KEY (id_classe) REFERENCES Classe(id),
FOREIGN KEY (id_personne) REFERENCES Personne(id)
);

CREATE TABLE Bulletin(
id int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
appreciation varchar(255) NOT NULL ,
id_trimestre int(11) NOT NULL,
id_inscription int(11) NOT NULL,
FOREIGN KEY (id_trimestre) REFERENCES Trimestre(id),
FOREIGN KEY (id_inscription) REFERENCES Inscription(id)
);

CREATE TABLE DetailBulletin(
id int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
appreciation varchar(255) NOT NULL ,
id_bulletin int(11) NOT NULL,
id_enseignement int(11) NOT NULL,
FOREIGN KEY (id_bulletin) REFERENCES Bulletin(id),
FOREIGN KEY (id_enseignement) REFERENCES Enseignement(id)
);

CREATE TABLE Evaluation(
id int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
appreciation varchar(255) NOT NULL ,
note int(11) NOT NULL,
id_detail_bulletin int(11) NOT NULL,
FOREIGN KEY (id_detail_bulletin) REFERENCES DetailBulletin(id)
);