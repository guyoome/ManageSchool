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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author helen
 */
public class disciplineDAO extends DAO<discipline>{
    private PreparedStatement findOne;
    private PreparedStatement findAll;
    private PreparedStatement create;
    
    
    public disciplineDAO(Connection conn) throws SQLException {
    super(conn);
    
    //findOne = this.connect.getConnect().prepareStatement("SELECT ");
    findAll = this.connect.prepareStatement("SELECT * FROM discipline");
    create = this.connect.prepareStatement("INSERT INTO discipline (nom) VALUES (?)");
    }

    @Override
    @SuppressWarnings("empty-statement")
  public boolean create(discipline obj) {
     try{
        create.setObject(1, obj.getNom());
        
        create.executeUpdate();
        System.out.println("COUCOU : discipline créée !!");
      }
     catch(SQLException sql){
         sql.printStackTrace();
         //this.closeStatements();
         return false;        
      }
    //this.closeStatements();
    return true;
  }
   
    @Override
  public discipline find(int id) {
    discipline b = new discipline();      
      
    try {
      
      ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM discipline WHERE id = " + id);
      
      //String requete = "SELECT * FROM eleve WHERE id = " + id;
      //this.connect.ajouterRequete(requete);
      if(result.first())
        b = new discipline(
          id,
          result.getString("nom")
        );         
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return b;
  }

    @Override
    public boolean delete(discipline obj) {
        try {
            PreparedStatement delete = this.connect.prepareStatement("DELETE FROM discipline WHERE id = " + obj.getID());         
            delete.executeUpdate();
            System.out.println("discipline supprimée !");
        } catch (SQLException ex) {
            Logger.getLogger(bulletinDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("discipline PAS supprimée ! ");
            return false;
        }
        return true;
    }

    @Override
    public boolean update(discipline obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}