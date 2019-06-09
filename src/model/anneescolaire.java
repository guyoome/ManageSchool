/*
 * contient les données à afficher
 */
package model;

import java.sql.Connection;

/**
 * classe des annees scolaire
 * @author helen
 */
public class anneescolaire {
    ///attribut
    //ID
    private int id = 0;
    
    
    /**
 * constructeur surchargé
     * @param id l'ID de l'annee scolaire
 */
    public anneescolaire(int id)
    {
        this.id = id;
    }
    
    /**
     * constructeur basique
     */
    public anneescolaire(){}

    anneescolaire(Connection conn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * setter : change l'id
     * @param id qui deviendra l'id de la classe
     */
    public void setID(int id)
    {
        this.id = id;
    }
    
    /**
     * getter : retourne l'id de l'objet
     * @return id l'id de l'objet
     */
    public int getID()
    {
        return id;
    }
    
}
