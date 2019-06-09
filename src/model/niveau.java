/*
 * contient les données à afficher
 */
package model;

/**
 *
 * @author helen
 */
public class niveau {
     ///attribut
    private int id =0;
    private String nom = "";
    
    
    ///constructors
    public niveau(){}
    
    public niveau(int id, String nom)
    {
        this.id = id;
        this.nom = nom;
    }
    
    ///setters 
    public void setID(int id){this.id = id;}
    public void setNom(String nom){this.nom = nom;}
    
    ///getters
    public int getID(){return id;}
    public String getNom(){return nom;}
    
}
