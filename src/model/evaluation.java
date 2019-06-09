/*
 * contient les données à afficher
 */
package model;

/**
 * la classe qui créer les evaluations
 * @author helen
 */
public class evaluation {
    ///attribut
    private int id = 0;
    private String appreciation = "";
    private double note = 0.0;
    private int id_detail_bulletin = 0;
    
    /**
     * constructeur par default
     */
    public evaluation(){}
    /**
     * constructeur surchargé
     * @param id le futur id de l'objet
     * @param app la future appreciation de l'objet
     * @param note la future note de l'objet
     * @param idD le futur id du detail bulletin de l'objet
     */
    public evaluation(int id, String app, double note, int idD)
    {
        this.id = id;
        this.appreciation = app;
        this.note = note;
        this.id_detail_bulletin = idD;
    }
    
    /**
     * setter ID
     * @param id le nouvel id de l'objet 
     */ 
    public void setID(int id){this.id = id;}
    /**
     * setter appreciation
     * @param app la nouvelle appreciation de l'objet
     */
    public void setAppreciation(String app){this.appreciation = app;}
    /**
     * setter note
     * @param note la nouvelle note de l'objet 
     */
    public void setNote(double note){this.note = note;}
    /**
     * setter id detail bulletin
     * @param id le nouvel id du detail bulletin de l'objet
     */
    public void setDetailBulletin(int id){this.id_detail_bulletin = id;}
    
    /**
     * getter ID
     * @return l'id de l'objet
     */
    public int getID(){return id;}
    /**
     * getter appreciation
     * @return l'appreciation de l'objet
     */
    public String getAppreciation(){return appreciation;}
    /**
     * getter note
     * @return la note de l'objet
     */
    public double getNote(){return note;}
    /**
     * getter ID detail bulletin
     * @return l'id du detail bulletin de l'objet
     */
    public int getDetailBulletin(){return id_detail_bulletin;}
    
}
