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
public class bulletin {
    ///attributs
    private int id = 0;
    private String appreciation= "";
    private int id_trimestre = 0;
    private int id_inscription = 0;
    
    ///constructors
    public bulletin(){}
    
    public bulletin(int id, String app, int idT, int idI)
    {
        this.id = id;
        appreciation = app;
        id_trimestre = idT;
        id_inscription = idI;
    }
    
    
    ///setters
    public void setID(int id)
    {
        this.id = id;
    }
    
    public void setAppreciation(String app)
    {
        appreciation = app;
    }
    
    public void setIDtrimestre(int id)
    {
        id_trimestre = id;
    }
    
    public void setIDinscription(int id)
    {
        id_inscription = id;
    }
    
    ///getters
    public int getID()
    {
        return id;
    }
    
    public String getAppreciation()
    {
        return appreciation;
    }
    
    public int getIDtrimestre()
    {
        return id_trimestre;
    }
    
    public int getIDinscription()
    {
        return id_inscription;
    }
}
