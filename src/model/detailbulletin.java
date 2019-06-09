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
    
    ///constructors
    public detailbulletin(){}
    
    public detailbulletin(int id, String appreciation, int idB, int idE)
    {
        this.id = id;
        this.appreciation = appreciation;
        id_bulletin = idB;
        id_enseignement = idE;
    }
    
    ///setters 
    public void setID(int id){this.id = id;}
    public void setAppreciation(String app){this.appreciation = app;}
    public void setBulletin(int id){this.id_bulletin = id;}
    public void setEnseignement(int id){this.id_enseignement = id;}
    
    ///getters
    public int getID(){return id;}
    public String getAppreciation(){return appreciation;}
    public int getBulletin(){return id_bulletin;}
    public int getEnseignement(){return id_enseignement;}
    
    
}
