/*
 * contient les données à afficher
 */
package model;

/**
 * la classe qui créer les inscription 
 * @author helen
 */
public class inscription {
    ///attribut
    private int id = 0;
    private int id_classe = 0;
    private int id_personne = 0;
    
    /**
     * constructeur par default
     */
    public inscription(){}
    /**
     * constructeur surchargé
     * @param id le futur id de l'objet
     * @param idC le futur id de la classe de l'objet
     * @param idP le futur id de la personne de l'objet
     */
    public inscription(int id, int idC, int idP)
    {
        this.id = id;
        this.id_classe = idC;
        this.id_personne = idP;
    }
    
    /**
     * setter id
     * @param id le nouvel id de l'objet 
     */
    public void setID(int id){this.id = id;}
    /**
     * setter id classe
     * @param id le nouvel id de la classe de l'objet
     */
    public void setClasse(int id){this.id_classe = id;}
    /**
     * setter personne 
     * @param id le nouvel id de la personne de l'objet
     */
    public void setPersonne(int id){this.id_personne = id;}
    
    /**
     * getter ID
     * @return l'id de l'objet
     */
    public int getID(){return id;}
    /**
     * getter id classe
     * @return l'id de la classe de l'objet
     */
    public int getClasse(){return id_classe;}
    /**
     * getter id Personne
     * @return l'id de la personne de l'objet
     */
    public int getPersonne(){return id_personne;}
    
}
