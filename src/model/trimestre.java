/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
/**
 *
 * @author helen
 */
public class trimestre {
    ///attribut
    private int id = 0;
    private int numero = 0;
    private Date debut = null;
    private Date fin = null;
    private int id_anneeScolaire = 0;
    
    ///constructor
    public trimestre(){}
    public trimestre(int id, int num, Date debut, Date fin, int idA)
    {
        this.id = id;
        this.numero = num;
        this.debut = debut;
        this.fin = fin;
        this.id_anneeScolaire = idA;
    }
    
    ///setter
    public void setID(int id){this.id = id;}
    public void setNum(int num){this.numero=num;}
    public void setDebut(Date debut){this.debut = debut;}
    public void setFin(Date fin){this.fin = fin;}
    public void setAnneeScolaire(int id){this.id_anneeScolaire = id;}
    
    ///getter
    public int getID(){return id;}
    public int getNum(){return numero;}
    public Date getDebut(){return debut;}
    public Date getFin(){return fin;}
    public int getAnneeScolaire(){return id_anneeScolaire;}
}
