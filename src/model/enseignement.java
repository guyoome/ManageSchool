/*
 * contient les données à afficher
 */
package model;

/**
 *
 * @author helen
 */
public class enseignement {
    ///attributs
    private int id = 0;
    private int id_classe = 0;
    private int id_discipline = 0;
    private int id_personne = 0;
    
    /**
     * constructeur par default
     */
    public enseignement(){}
    /**
     * constructeur surchargé
     * @param id le futur id de l'objet
     * @param idC le futur id de la classe de l'objet
     * @param idD le futur id de la discipline de l'objet
     * @param idP la futur id de la personne de l'objet
     */
    public enseignement(int id, int idC, int idD, int idP)
    {
        this.id = id;
        this.id_classe = idC;
        this.id_discipline = idD;
        this.id_personne = idP;
    }
    
    /**
     * setter ID
     * @param id le nouvel id de l'objet
     */
    public void setID(int id){this.id = id;}
    /**
     * setter ID Classe
     * @param id le nouvel id de la classe de l'objet
     */
    public void setClasse(int id){this.id_classe = id;}
    /**
     * setter ID discipline
     * @param id le nouvel id de la discipline de l'objet
     */
    public void setDiscipline(int id){this.id_discipline = id;}
    /**
     * setter ID personne
     * @param id le nouvel id de l'enseignant de l'objet
     */
    public void setPersonne(int id){this.id_personne = id;}
    
    /**
     * getter ID
     * @return l'id de l'objet
     */
    public int getID(){return id;}
    /**
     * getter Classe
     * @return l'id de le classe de l'objet
     */
    public int getClasse(){return id_classe;}
    /**
     * getter discipline
     * @return l'id de la discipline de l'objet 
     */
    public int getDiscipline(){return id_discipline;}
    /**
     * getter Personne
     * @return l'id de la personne de l'objet
     */
    public int getPersonne(){return id_personne;}
    
}
