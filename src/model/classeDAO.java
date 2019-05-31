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
public class classeDAO extends DAO<classe>{
    private PreparedStatement findOne;
    private PreparedStatement findAll;
    private PreparedStatement create;
    
    
    public classeDAO(Connexion conn) throws SQLException {
    super(conn);
    
    //findOne = this.connect.getConnect().prepareStatement("SELECT ");
    findAll = this.connect.getConnect().prepareStatement("SELECT * FROM class");
    create = this.connect.getConnect().prepareStatement("INSERT INTO class (nom, id_ecole, id_niveau, id_anneeScolaire) VALUES (?, ?, ?, ?)");
    }

    @Override
    @SuppressWarnings("empty-statement")
  public boolean create(classe obj) {
     try{
        create.setObject(1, obj.getNom());
        create.setObject(2, obj.getEcole());
        create.setObject(3, obj.getNiveau());
        create.setObject(4, obj.getAnneeScolaire());
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
      
      ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM personne WHERE id = " + id);
      
      //String requete = "SELECT * FROM eleve WHERE id = " + id;
      //this.connect.ajouterRequete(requete);
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