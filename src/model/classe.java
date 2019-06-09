/*
 * contient les données à afficher
 */
package model;

/**
 *
 * @author helen
 */
public class classe {
    ///attribut
    private int id =0;
    private String nom = "";
    private int id_ecole = 0;
    private int id_niveau = 0;
    private int id_anneeScolaire = 0;
    
    
    /**
   * constructor
   */
    public classe(){}
    
    /**
     * constructor surchargé
     * @param id le futur id de l'objet
     * @param nom le futur nom de l'objet
     * @param idE le futur id de l'école de l'objet
     * @param idN le futur id du niveau de l'objet
     * @param itA le futur id de l'annee scolaire de l'objet
     */
    public classe(int id, String nom, int idE, int idN, int itA)
    {
        this.id = id;
        this.nom = nom;
        id_ecole = idE;
        id_niveau = idN;
        id_anneeScolaire = itA;
    }
    
    /**
   * setter
     * @param id le futur id de l'objet
   */
    public void setID(int id){this.id = id;}
    /** setter
     * @param nom le futur nom de l'objet
   */
    public void setNom(String nom){this.nom = nom;}
    /**
     * setter
     * @param id le futur id de l'ecole de l'objet
     */
    public void setEcole(int id){this.id_ecole = id;}
    /**
     * setter
     * @param id le futur id du niveau de l'objet
     */
    public void setNiveau(int id){this.id_niveau = id;}
    /**
     * setter
     * @param id le futur id de l'annee scolaire de l'objet 
     */
    public void setAnneeScolaire(int id){this.id_anneeScolaire = id;}
    
    /**
     * getter
     * @return l'id de l'objet
     */
    public int getID(){return id;}
    /**
     * getter
     * @return le nom de l'objet
     */
    public String getNom(){return nom;}
    /**
     * getter
     * @return l ecole de l'objet
     */
    public int getEcole(){return id_ecole;}
    /**
     * getter
     * @return le niveau de l'objet
     */
    public int getNiveau(){return id_niveau;}
    /**
     * getter
     * @return l annee scolaire  de l'objet
     */
    public int getAnneeScolaire(){return id_anneeScolaire;}
    
}
