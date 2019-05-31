/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author helen
 */
public class bulletinDAO extends DAO<bulletin>{
    ///attributs
    
    private PreparedStatement findOne;
    
    
    public bulletinDAO(Connexion conn) throws SQLException {
    super(conn);
    
    findOne = this.connect.getConnect().prepareStatement("ecrire quelque chose en SQL ici");
    }

    @Override
  public boolean create(bulletin obj) {
    return false;
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
      String requete = "SELECT * FROM eleve WHERE elv_id = " + id;
      this.connect.ajouterRequete(requete);
      if(result.first())
        b = new bulletin(
          id,
          result.getString("appreciation"),
          result.getString("id_trimestre"),
          result.getString("id_inscription")
        );         
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return b;
  }
    
    
    
}
