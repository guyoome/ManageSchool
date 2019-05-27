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
public class anneescolaire {
    ///attribut
    //ID
    private int id = 0;
    
    
    ///constructors
    public anneescolaire(int id)
    {
        this.id = id;
    }
    
    public anneescolaire(){}
    
    ///getters and setters
    public void setID(int id)
    {
        this.id = id;
    }
    
    public int getID()
    {
        return id;
    }
    
}
