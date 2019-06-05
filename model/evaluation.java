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
public class evaluation {
    ///attribut
    private int id = 0;
    private String appreciation = "";
    private double note = 0.0;
    private int id_detail_bulletin = 0;
    
    ///constructors 
    public evaluation(){}
    
    public evaluation(int id, String app, double note, int idD)
    {
        this.id = id;
        this.appreciation = app;
        this.note = note;
        this.id_detail_bulletin = idD;
    }
    
     ///setters 
    public void setID(int id){this.id = id;}
    public void setAppreciation(String app){this.appreciation = app;}
    public void setNote(double note){this.note = note;}
    public void setDetailBulletin(int id){this.id_detail_bulletin = id;}
    
    ///getters
    public int getID(){return id;}
    public String getAppreciation(){return appreciation;}
    public double getNote(){return note;}
    public int getDetailBulletin(){return id_detail_bulletin;}
    
}
