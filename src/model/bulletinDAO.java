/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author helen
 */
public class bulletinDAO extends DAO<bulletin>{
    ///attributs
    
    private PreparedStatement findOne;
    private PreparedStatement findAll;
    private PreparedStatement create;
    
    
    public bulletinDAO(Connection conn) throws SQLException {
    super(conn);
    
    findOne = this.connect.prepareStatement("SELECT ");
    findAll = this.connect.prepareStatement("SELECT * FROM bulletin");
    create = this.connect.prepareStatement("INSERT INTO bulletin (appreciation, id_trimestre, id_inscription) VALUES (?, ?, ?)");
    
    }

    @Override
    @SuppressWarnings("empty-statement")
  public boolean create(bulletin obj) {
     try{
         //create = this.connect.getConnect().prepareStatement("INSERT INTO bulletin (appreciation, id_trimestre, id_inscription) VALUES (?, ?, ?)")
        create.setObject(1, obj.getAppreciation());
        create.setObject(2, obj.getIDtrimestre());
        create.setObject(3, obj.getIDinscription());
        
        create.executeUpdate();
        System.out.println("COUCOU : bulletin créé !!");
      }
     catch(SQLException sql){
         sql.printStackTrace();
         return false;        
      }
    return true;
  }

    @Override
  public boolean delete(bulletin obj) {
        try {
            PreparedStatement delete = this.connect.prepareStatement("DELETE FROM bulletin WHERE id = " + obj.getID());         
            delete.executeUpdate();
            System.out.println("bulletin supprimé !");
        } catch (SQLException ex) {
            Logger.getLogger(bulletinDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    return true;
  }
   
    @Override
  public boolean update(bulletin obj) {
    return false;
  }
   
    @Override
  public bulletin find(int id) {
    bulletin b = new bulletin();      
      
    try {
      
      ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM bulletin WHERE id = " + id);
      
      /*
      ResultSet result = null;ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM personne WHERE id = " + id);
      result = findAll.executeQuery();      
      String requete = "SELECT * FROM eleve WHERE id = " + id;
      this.connect.ajouterRequete(requete);
       */
      
      if(result.first())
        b = new bulletin(
          id,
          result.getString("appreciation"),
          result.getInt("id_trimestre"),
          result.getInt("id_inscription")
        );         
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return b;
  }
    
    
    
}
