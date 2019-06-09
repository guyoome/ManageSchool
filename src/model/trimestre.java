/*
 * contient les données à afficher
 */
package model;

/**
 *
 * @author helen
 */
public class trimestre {
    ///attribut
    private int id = 0;
    private int numero = 0;
    private String debut = "";
    private String fin = "";
    private int id_anneeScolaire = 0;
    
    ///constructor
    public trimestre(){}
    public trimestre(int id, int num, String debut, String fin, int idA)
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
    public void setDebut(String debut){this.debut = debut;}
    public void setFin(String fin){this.fin = fin;}
    public void setAnneeScolaire(int id){this.id_anneeScolaire = id;}
    
    ///getter
    public int getID(){return id;}
    public int getNum(){return numero;}
    public String getDebut(){return debut;}
    public String getFin(){return fin;}
    public int getAnneeScolaire(){return id_anneeScolaire;}
}
