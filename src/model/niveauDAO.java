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
public class niveauDAO extends DAO<niveau>{
     private PreparedStatement findOne;
    private PreparedStatement findAll;
    private PreparedStatement create;
    
    
    public niveauDAO(Connection conn) throws SQLException {
    super(conn);

        findOne = this.connect.prepareStatement("SELECT ");
        findAll = this.connect.prepareStatement("SELECT * FROM niveau");
        create = this.connect.prepareStatement("INSERT INTO niveau (nom) VALUES (?)");
    }

    @Override
    @SuppressWarnings("empty-statement")
  public boolean create(niveau obj) {
     try{
        create.setObject(1, obj.getNom());
        
        create.executeUpdate();
        System.out.println("COUCOU : niveau créé !!");
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
  public boolean delete(niveau obj) {
    try {
            PreparedStatement delete = this.connect.prepareStatement("DELETE FROM niveau WHERE id = " + obj.getID());         
            delete.executeUpdate();
            System.out.println("niveau supprimée !");
        } catch (SQLException ex) {
            Logger.getLogger(niveauDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("niveau PAS supprimée ! ");
            return false;
        }
        return true;
  }
   
    @Override
  public boolean update(niveau obj) {
    return false;
  }

    @Override
    public niveau find(int id) {
        niveau o = new niveau();

        try {

            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM niveau WHERE id = " + id);
            if(result.first())
                o = new niveau(
                        id,
                        result.getString("nom")
                );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return o;
    }

    @Override
    public ArrayList<niveau> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
