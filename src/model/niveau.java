/*
 * contient les données à afficher
 */
package model;

/**
 *la classe qui créer les niveaux
 * @author helen
 */
public class niveau {
     ///attribut
    private int id =0;
    private String nom = "";
    
    
    /**
     * constructeur par default
     */
    public niveau(){}
    /**
     * constructeur surchargé
     * @param id le futur id de l'objet
     * @param nom le futur nom de l'objet
     */
    public niveau(int id, String nom)
    {
        this.id = id;
        this.nom = nom;
    }
    
    /**
     * setter ID
     * @param id le nouvel id de l'objet 
     */ 
    public void setID(int id){this.id = id;}
    /**
     * setter nom
     * @param nom le novueau nom de l'objet 
     */
    public void setNom(String nom){this.nom = nom;}
    
    /**
     * getter ID
     * @return l'id de l'objet
     */
    public int getID(){return id;}
    /**
     * getter Nom
     * @return le nom de l'objet
     */
    public String getNom(){return nom;}
    
}
