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
public class evaluationDAO extends DAO<evaluation>{
     private PreparedStatement findOne;
    private PreparedStatement findAll;
    private PreparedStatement create;
    
    
    public evaluationDAO(Connection conn) throws SQLException {
    super(conn);

        findOne = this.connect.prepareStatement("SELECT ");
        findAll = this.connect.prepareStatement("SELECT * FROM evaluation");
        create = this.connect.prepareStatement("INSERT INTO evaluation (appreciation, note, id_detail_bulletin) VALUES (?, ?, ?)");
    }

    @Override
    @SuppressWarnings("empty-statement")
  public boolean create(evaluation obj) {
     try{
        create.setObject(1, obj.getAppreciation());
        create.setObject(2, obj.getNote());
        create.setObject(3, obj.getDetailBulletin());
        
        create.executeUpdate();
        System.out.println("COUCOU : evaluation créé !!");
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
  public boolean delete(evaluation obj) {
    try {
            PreparedStatement delete = this.connect.prepareStatement("DELETE FROM evaluation WHERE id = " + obj.getID());         
            delete.executeUpdate();
            System.out.println("evaluation supprimée !");
        } catch (SQLException ex) {
            Logger.getLogger(bulletinDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("evaluation PAS supprimée ! ");
            return false;
        }
        return true;
  }
   
    @Override
  public boolean update(evaluation obj) {
    return false;
  }

    @Override
    public evaluation find(int id) {
        evaluation o = new evaluation();

        try {

            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM evaluation WHERE id = " + id);
            if(result.first())
                o = new evaluation(
                        id,
                        result.getString("appreciation"),
                        result.getInt("note"),
                        result.getInt("id_detail_bulletin")
                );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return o;
    }
    
}
