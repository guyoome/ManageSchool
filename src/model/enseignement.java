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
public class enseignement {
    ///attributs
    private int id = 0;
    private int id_classe = 0;
    private int id_discipline = 0;
    private int id_personne = 0;
    
    ///constructors
    public enseignement(){}
    
    public enseignement(int id, int idC, int idD, int idP)
    {
        this.id = id;
        this.id_classe = idC;
        this.id_discipline = idD;
        this.id_personne = idP;
    }
    
     ///setters 
    public void setID(int id){this.id = id;}
    public void setClasse(int id){this.id_classe = id;}
    public void setDiscipline(int id){this.id_discipline = id;}
    public void setPersonne(int id){this.id_personne = id;}
    
    ///getters
    public int getID(){return id;}
    public int getClasse(){return id_classe;}
    public int getDiscipline(){return id_discipline;}
    public int getPersonne(){return id_personne;}
    
}
