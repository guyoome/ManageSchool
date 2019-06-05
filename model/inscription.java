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
public class inscription {
    ///attribut
    private int id = 0;
    private int id_classe = 0;
    private int id_personne = 0;
    
    ///constructors
    public inscription(){}
    public inscription(int id, int idC, int idP)
    {
        this.id = id;
        this.id_classe = idC;
        this.id_personne = idP;
    }
    
    ///setters 
    public void setID(int id){this.id = id;}
    public void setClasse(int id){this.id_classe = id;}
    public void setPersonne(int id){this.id_personne = id;}
    
    ///getters
    public int getID(){return id;}
    public int getClasse(){return id_classe;}
    public int getPersonne(){return id_personne;}
    
}
