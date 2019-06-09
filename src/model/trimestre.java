/*
 * contient les données à afficher
 */
package model;

/**
 *la classe qui créer les trimestre
 * @author helen
 */
public class trimestre {
    ///attribut
    private int id = 0;
    private int numero = 0;
    private String debut = "";
    private String fin = "";
    private int id_anneeScolaire = 0;
    
    /**
     * constructeur par default
     */
    public trimestre(){}
    /**
     * constructeur surchargé
     * @param id le futur id de l'objet
     * @param num le futur numero de l'objet
     * @param debut la futur date de debut de l'objet
     * @param fin la future date de fin de l'objet
     * @param idA le futur id de l'annee scolaire de l'objet
     */
    public trimestre(int id, int num, String debut, String fin, int idA)
    {
        this.id = id;
        this.numero = num;
        this.debut = debut;
        this.fin = fin;
        this.id_anneeScolaire = idA;
    }
    
    /**
     * setter ID
     * @param id le nouvel ID de l'objet 
     */
    public void setID(int id){this.id = id;}
    /**
     * setter numero
     * @param num le nouveau numero de l'objet
     */
    public void setNum(int num){this.numero=num;}
    /**
     * setter date debut
     * @param debut la nouvelle date de debut de l'objet
     */
    public void setDebut(String debut){this.debut = debut;}
    /**
     * setter date fin
     * @param fin la nouvelle date de fin de l'objet
     */
    public void setFin(String fin){this.fin = fin;}
    /**
     * setter id de l'annee scolaire
     * @param id le nouvel id de l'annee scolaire de l'objet
     */
    public void setAnneeScolaire(int id){this.id_anneeScolaire = id;}
    
    /**
     * getter id
     * @return l'id de l'objet
     */
    public int getID(){return id;}
    /**
     * getter numero
     * @return le numero de l'objet
     */
    public int getNum(){return numero;}
    /**
     * getter date debut
     * @return la date de debut de l'objet
     */
    public String getDebut(){return debut;}
    /**
     * getter date fin
     * @return la date de fin de l'objet
     */
    public String getFin(){return fin;}
    /**
     * getter ID annee scolaire
     * @return l'id de l'annee scolaire de l'objet
     */
    public int getAnneeScolaire(){return id_anneeScolaire;}
}
