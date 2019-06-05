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
public class personneDAO extends DAO<personne>{
     private PreparedStatement findOne;
    private PreparedStatement findAll;
    private PreparedStatement create;
    
    
    public personneDAO(Connection conn) throws SQLException {
    super(conn);

        findOne = this.connect.prepareStatement("SELECT ");
        findAll = this.connect.prepareStatement("SELECT * FROM personne");
        create = this.connect.prepareStatement("INSERT INTO personne (nom, prenom, type_, userP,mdp) VALUES (?, ?, ?, ?, ?)");
    }

    @Override
    @SuppressWarnings("empty-statement")
  public boolean create(personne obj) {
     try{
        create.setObject(1, obj.getName());
        create.setObject(2, obj.getFirstname());
        create.setObject(3, obj.getType());
        create.setObject(4, obj.getUser());
        create.setObject(5, obj.getmdp());
        
        create.executeUpdate();
        System.out.println("COUCOU : personne créé !!");
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
  public boolean delete(personne obj) {
    try {
            PreparedStatement delete = this.connect.prepareStatement("DELETE FROM personne WHERE id = " + obj.getID());         
            delete.executeUpdate();
            System.out.println("personne supprimée !");
        } catch (SQLException ex) {
            Logger.getLogger(personneDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("personne PAS supprimée ! ");
            return false;
        }
        return true;
  }
   
    @Override
  public boolean update(personne obj) {
    return false;
  }

    @Override
    public personne find(int id) {
        personne o = new personne();

        try {

            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM personne WHERE id = " + id);
            if(result.first())
                o = new personne(
                        id,
                        result.getString("nom"),
                        result.getString("prenom"),
                        result.getString("type_"),
                        result.getString("userP"),
                        result.getString("mdp")
                );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return o;
    }
    
}
