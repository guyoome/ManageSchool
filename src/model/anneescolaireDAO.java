/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author helen
 */
public class anneescolaireDAO extends DAO<anneescolaire>{
    ///attributs
    
    private PreparedStatement findOne;
    private PreparedStatement findAll;
    private PreparedStatement create;
    
    
    public anneescolaireDAO(Connection conn) throws SQLException {
        super(conn);
    
    //findOne = this.connect.getConnect().prepareStatement("SELECT ");
    findAll = this.connect.prepareStatement("SELECT * FROM anneescolaire");
    create = this.connect.prepareStatement("INSERT INTO anneescolaire (id) VALUES (?)");
    }

    @SuppressWarnings("empty-statement")
    @Override
  public boolean create(anneescolaire obj) {
    try{
        create.setObject(1, obj.getID());
        create.executeUpdate();
        System.out.println("COUCOU : anneescolaire créée !!");
      }
     catch(SQLException sql){
         sql.printStackTrace();
         return false;        
      }
    return true;
  }

    @Override
  public boolean delete(anneescolaire obj) {
    try {
            PreparedStatement delete = this.connect.prepareStatement("DELETE FROM anneescolaire WHERE id = " + obj.getID());         
            delete.executeUpdate();
            System.out.println("anneescolaire supprimée !");
        } catch (SQLException ex) {
            Logger.getLogger(bulletinDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    return true;
  }
   
  @Override
    public boolean update(anneescolaire obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    @Override
  public anneescolaire find(int id) {
    anneescolaire b = new anneescolaire();      
    
    try {
      
      ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM anneescolaire WHERE id = " + id);
      
      if(result.first())
        b = new anneescolaire(id);         
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return b;
  }

    @Override
    public ArrayList<anneescolaire> findAll() {
        ArrayList<anneescolaire> maListe = new ArrayList<>();

        int id = 0;
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM anneescolaire");
            while(result.next())
            {
                id = result.getInt("ID");
                anneescolaire newAnneeScolaire = new anneescolaire(id);
                maListe.add(newAnneeScolaire);
            }   
        } catch (SQLException ex) {
            Logger.getLogger(anneescolaireDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return maListe;
    }

    
    
    
    
}
