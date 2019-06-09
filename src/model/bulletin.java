/*
 * contient les données à afficher
 */
package model;

/**
 * classe des bulletins
 * @author helen
 */
public class bulletin {
    ///attributs
    private int id = 0;
    private String appreciation= "";
    private int id_trimestre = 0;
    private int id_inscription = 0;
    private int id_eleve =0;
    
  /**
   * constructor
   */
    public bulletin(){}
    
    /**
     * constructor surchargé
     * @param id deviendra l'id de l'objet
     * @param app deviendra l'appreciation de l'objet
     * @param idT deviendra l'id du trimestre de l'objet
     * @param idI deviendra l'id de l'inscription de l'objet
     * @param eleve deviendra l'id de l'eleve de l'objet
     */
    public bulletin(int id, String app, int idT, int idI,int eleve)
    {
        this.id = id;
        appreciation = app;
        id_trimestre = idT;
        id_inscription = idI;
        this.id_eleve=eleve;
    }
    
    
    /**
     * setter ID
     * @param id deviendra l'id de l'objet
     */
    public void setID(int id)
    {
        this.id = id;
    }
    /**
     * setter appreciation
     * @param app deviendra l'appreciation de l'objet
     */
    public void setAppreciation(String app)
    {
        appreciation = app;
    }
    /**
     * setter id trimestre
     * @param id deviendra l'id du trimestre de l'objet
     */
    public void setIDtrimestre(int id)
    {
        id_trimestre = id;
    }
    /**
     * setter id inscription
     * @param id deviendra l'id de l'inscription de l'objet
     */
    public void setIDinscription(int id)
    {
        id_inscription = id;
    }

    
    /**
     * getter id
     * @return l'id de l'objet
     */
    public int getID()
    {
        return id;
    }
    /**
     * getter Appreciation
     * @return l'appreciation de l'objet
     */
    public String getAppreciation()
    {
        return appreciation;
    }
    /**
     * getter id trimestre
     * @return l'id du trimestre de l'objet
     */
    public int getIDtrimestre()
    {
        return id_trimestre;
    }
    /**
     * getter id inscription
     * @return l'id de l'inscription de l'objet
     */
    public int getIDinscription()
    {
        return id_inscription;
    }
    /**
     * getter id eleve
     * @return l'id de l'eleve de l'objet
     */
    public int getId_eleve() {
        return id_eleve;
    }
}
