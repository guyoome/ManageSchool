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
public class classeDAO extends DAO<classe>{
    private PreparedStatement findOne;
    private PreparedStatement findAll;
    private PreparedStatement create;
    
    
    public classeDAO(Connection conn) throws SQLException {
        super(conn);
    
        //findOne = this.connect.getConnect().prepareStatement("SELECT ");
        findAll = this.connect.prepareStatement("SELECT * FROM classe");
        create = this.connect.prepareStatement("INSERT INTO classe (nom, id_ecole, id_niveau, id_anneeScolaire) VALUES (?, ?, ?, ?)");
    }

    @Override
    @SuppressWarnings("empty-statement")
  public boolean create(classe obj) {
     try{
        create.setObject(1, obj.getNom());
        create.setObject(2, obj.getEcole());
        create.setObject(3, obj.getNiveau());
        create.setObject(4, obj.getAnneeScolaire());
        
        create.executeUpdate();
        System.out.println("COUCOU : classe créée !!");
      }
     catch(SQLException sql){
         System.out.println("COUCOU : classe PAS créée !!");
         sql.printStackTrace();
         //this.closeStatements();
         return false;        
      }
    //this.closeStatements();
    return true;
  }
   
    @Override
  public classe find(int id) {
    classe b = new classe();      
      
    try {
      
      ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM classe WHERE id = " + id);
      
      //String requete = "SELECT * FROM eleve WHERE id = " + id;
      //this.connect.ajouterRequete(requete);
      if(result.first())
        b = new classe(
          id,
          result.getString("nom"),
          result.getInt("id_ecole"),
          result.getInt("id_niveau"),
          result.getInt("id_anneeScolaire")
        );         
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return b;
  } 

    @Override
    public boolean delete(classe obj) {
        try {
            PreparedStatement delete = this.connect.prepareStatement("DELETE FROM classe WHERE id = " + obj.getID());         
            delete.executeUpdate();
            System.out.println("classe supprimée !");
        } catch (SQLException ex) {
            Logger.getLogger(bulletinDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    return true;
    }

    @Override
    public boolean update(classe obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}