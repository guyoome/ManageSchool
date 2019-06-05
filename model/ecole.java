/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author helen
 */
public class ecole {
    ///attributs
    private int id_ecole = 0;
    private String nom_ecole = "";
    private String adresse = "";
    
     ///constructors
    public ecole(){}
    
    public ecole(int id, String nom, String adresse)
    {
        this.id_ecole = id;
        this.nom_ecole = nom;
        this.adresse = adresse;
    }
    
    ///setters 
    public void setID(int id){this.id_ecole = id;}
    public void setNom(String nom){this.nom_ecole = nom;}
    public void setAdresse(String adresse){this.adresse = adresse;}
    
    ///getters
    public int getID(){return id_ecole;}
    public String getNom(){return nom_ecole;}
    public String getAdresse(){return adresse;}
}
