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
public class classe {
    ///attribut
    private int id =0;
    private String nom = "";
    private int id_ecole = 0;
    private int id_niveau = 0;
    private int id_anneeScolaire = 0;
    
    
    ///constructors
    public classe(){}
    
    public classe(int id, String nom, int idE, int idN, int itA)
    {
        this.id = id;
        this.nom = nom;
        id_ecole = idE;
        id_niveau = idN;
        id_anneeScolaire = itA;
    }
    
    ///setters 
    public void setID(int id){this.id = id;}
    public void setNom(String nom){this.nom = nom;}
    public void setEcole(int id){this.id_ecole = id;}
    public void setNiveau(int id){this.id_niveau = id;}
    public void setAnneeScolaire(int id){this.id_anneeScolaire = id;}
    
    ///getters
    public int getID(){return id;}
    public String getNom(){return nom;}
    public int getEcole(){return id_ecole;}
    public int getNiveau(){return id_niveau;}
    public int getAnneeScolaire(){return id_anneeScolaire;}
    
}
