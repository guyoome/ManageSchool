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
public class anneescolaireDAO extends DAO<anneescolaire>{
    ///attributs
    
    private PreparedStatement findOne;
    private PreparedStatement findAll;
    private PreparedStatement create;
    
    
    public anneescolaireDAO(Connexion conn) throws SQLException {
    super(conn);
    
    //findOne = this.connect.getConnect().prepareStatement("SELECT ");
    findAll = this.connect.prepareStatement("SELECT * FROM anneescolaire");
    create = this.connect.prepareStatement("INSERT INTO anneescolaire () VALUES ()");
    }

    @SuppressWarnings("empty-statement")
  public boolean create(bulletin obj) {
    //this.closeStatements();
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
  public anneescolaire find(int id) {
    anneescolaire b = new anneescolaire();      
      
    try {
      
      ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM anneescolaire WHERE id = " + id);
      
      //String requete = "SELECT * FROM eleve WHERE id = " + id;
      //this.connect.ajouterRequete(requete);
      if(result.first())
        b = new anneescolaire(
          id
        );         
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return b;
  }
    
    
    
}
