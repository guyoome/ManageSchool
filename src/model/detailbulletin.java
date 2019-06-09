/*
 * contient les données à afficher
 */
package model;

/**
 *
 * @author helen
 */
public class detailbulletin {
    ///attribut
    private int id = 0;
    private String appreciation = "";
    private int id_bulletin = 0;
    private int id_enseignement = 0;
    
    /**
     * constructeur par default
     */
    public detailbulletin(){}
    
    /**
     * constructeur surchargé
     * @param id le futur id de l'objet
     * @param appreciation la futur appreciation de l'objet
     * @param idB le futur id du bulletin de l'objet
     * @param idE  le futur id de l'enseignement de l'objet
     */
    public detailbulletin(int id, String appreciation, int idB, int idE)
    {
        this.id = id;
        this.appreciation = appreciation;
        id_bulletin = idB;
        id_enseignement = idE;
    }
    
    /**
     * setter ID
     * @param id le nouvel id de l'objet
     */
    public void setID(int id){this.id = id;}
    /**
     * setter appreciation
     * @param app la nouvelle appreociation de l'objet
     */
    public void setAppreciation(String app){this.appreciation = app;}
    /**
     * setter id bulletin
     * @param id le futur id du bulletin de l'objet
     */
    public void setBulletin(int id){this.id_bulletin = id;}
    /**
     * setter id enseignement
     * @param id le futur id de l'enseignement de l'objet
     */
    public void setEnseignement(int id){this.id_enseignement = id;}
    
    /**
     * getter ID
     * @return l'id de l'objet
     */
    public int getID(){return id;}
    /**
     * getter appreciation
     * @return l'appreciation de l'objet
     */
    public String getAppreciation(){return appreciation;}
    /**
     * getter de l'id bulletin
     * @return l'id du bulletin de l'objet
     */
    public int getBulletin(){return id_bulletin;}
    /**
     * getter de l'id enseignement
     * @return l'id de l'enseignement de l'objet
     */
    public int getEnseignement(){return id_enseignement;}
    
    
}
