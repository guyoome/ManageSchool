/*
 * contient les données à afficher
 */
package model;

/**
 * la classe qui créer les ecoles
 * @author helen
 */
public class ecole {
    ///attributs
    private int id_ecole = 0;
    private String nom_ecole = "";
    private String adresse = "";
    
    /**
     * constructeur par default
     */
    public ecole(){}
    /**
     * constructeur surchargé
     * @param id le futur id de l'objet
     * @param nom le futur nom de l'objet
     * @param adresse la future adresse de l'objet
     */
    public ecole(int id, String nom, String adresse)
    {
        this.id_ecole = id;
        this.nom_ecole = nom;
        this.adresse = adresse;
    }
    
    /**
     * setter ID
     * @param id le nouvel id de l'objet
     */
    public void setID(int id){this.id_ecole = id;}
    /**
     * setter Nom
     * @param nom le nouveau nom de l'objet 
     */
    public void setNom(String nom){this.nom_ecole = nom;}
    /**
     * setter Adresse
     * @param adresse la nouvelle adresse de l'objet 
     */
    public void setAdresse(String adresse){this.adresse = adresse;}
    
    /**
     * getter ID
     * @return l'id de l'objet
     */
    public int getID(){return id_ecole;}
    /**
     * getter Nom
     * @return le nom de l'objet
     */
    public String getNom(){return nom_ecole;}
    /**
     * getter Adresse
     * @return l'adresse de l'objet
     */
    public String getAdresse(){return adresse;}
}
