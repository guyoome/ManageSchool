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
public class inscriptionDAO extends DAO<inscription>{
     private PreparedStatement findOne;
    private PreparedStatement findAll;
    private PreparedStatement create;
    
    
    public inscriptionDAO(Connection conn) throws SQLException {
    super(conn);

        findOne = this.connect.prepareStatement("SELECT ");
        findAll = this.connect.prepareStatement("SELECT * FROM inscription");
        create = this.connect.prepareStatement("INSERT INTO inscription (id_classe, id_personne) VALUES (?, ?)");
    }

    @Override
    @SuppressWarnings("empty-statement")
  public boolean create(inscription obj) {
     try{
        create.setObject(1, obj.getClasse());
        create.setObject(2, obj.getPersonne());
        
        create.executeUpdate();
        System.out.println("COUCOU : inscription créé !!");
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
  public boolean delete(inscription obj) {
    try {
            PreparedStatement delete = this.connect.prepareStatement("DELETE FROM inscription WHERE id = " + obj.getID());         
            delete.executeUpdate();
            System.out.println("inscription supprimée !");
        } catch (SQLException ex) {
            Logger.getLogger(bulletinDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("inscription PAS supprimée ! ");
            return false;
        }
        return true;
  }
   
    @Override
  public boolean update(inscription obj) {
    return false;
  }

    @Override
    public inscription find(int id) {
        inscription o = new inscription();

        try {

            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM inscription WHERE id = " + id);
            if(result.first())
                o = new inscription(
                        id,
                        result.getInt("id_classe"),
                        result.getInt("id_personne")
                );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return o;
    }

    @Override
    public ArrayList<inscription> findAll() {
        ArrayList<inscription> maListe = new ArrayList<>();

        int id = 0;
        int id_classe = 0;
        int id_personne = 0;
        
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM inscription");
            while(result.next())
            {
                id = result.getInt("id");
                id_classe = result.getInt("id_classe");
                id_personne = result.getInt("id_personne");
                inscription newBulletin = new inscription(id, id_classe, id_personne);
                maListe.add(newBulletin);
            }   
        } catch (SQLException ex) {
            Logger.getLogger(inscriptionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return maListe; 
    }

    @Override
    public ArrayList<inscription> rechercher(String parametreTable, String parametre) {
        inscription b = new inscription();
        ArrayList<inscription> bb = new ArrayList<>();
    
    try {
      
      ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM inscription WHERE " + parametreTable + " LIKE " + "'" + parametre + "'");
      
        while(result.next())
        {    
            b = new inscription(result.getInt("id"), result.getInt("id_classe"),result.getInt("id_personne")); 
            bb.add(b);
        }
        } catch (SQLException e) {
         e.printStackTrace();
        }
        return bb;
    }

    @Override
    public ArrayList<inscription> rechercher(String parametreTable, int parametre) {
        inscription b = new inscription();
        ArrayList<inscription> bb = new ArrayList<>();
    
    try {
      
      ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM inscription WHERE " + parametreTable + " LIKE " + "'" + parametre + "'");
      
        while(result.next())
        {    
            b = new inscription(result.getInt("id"), result.getInt("id_classe"),result.getInt("id_personne")); 
            bb.add(b);
        }
        } catch (SQLException e) {
         e.printStackTrace();
        }
        return bb;
    }
    
}
