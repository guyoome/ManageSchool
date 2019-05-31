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
    
    
    public bulletinDAO(Connexion conn) throws SQLException {
    super(conn);
    
    //findOne = this.connect.getConnect().prepareStatement("SELECT ");
    findAll = this.connect.getConnect().prepareStatement("SELECT * FROM bulletin");
    create = this.connect.getConnect().prepareStatement("INSERT INTO bulletin (appreciation, id_trimestre, id_inscription) VALUES (?, ?, ?)");
    }

    @Override
    @SuppressWarnings("empty-statement")
  public boolean create(bulletin obj) {
     try{
        create.setObject(1, obj.getAppreciation());
        create.setObject(2, obj.getIDtrimestre());
        create.setObject(3, obj.getIDinscription());;
      }
     catch(SQLException sql){
         sql.printStackTrace();
         return false;        
      }
        try {
            create.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(bulletinDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    return true;
  }

    @Override
  public boolean delete(bulletin obj) {
    return false;
  }
   
    @Override
  public boolean update(bulletin obj) {
    return false;
  }
   
    @Override
  public bulletin find(int id) {
    bulletin b = new bulletin();      
      
    try {
      /*
      ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM personne WHERE id = " + id);*/
      ResultSet result = null;
      result = findAll.executeQuery();
      
      
      String requete = "SELECT * FROM eleve WHERE id = " + id;
      this.connect.ajouterRequete(requete);
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
