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
public class enseignementDAO extends DAO<enseignement>{
     private PreparedStatement findOne;
    private PreparedStatement findAll;
    private PreparedStatement create;
    
    
    public enseignementDAO(Connection conn) throws SQLException {
    super(conn);

        findOne = this.connect.prepareStatement("SELECT ");
        findAll = this.connect.prepareStatement("SELECT * FROM enseignement");
        create = this.connect.prepareStatement("INSERT INTO enseignement (id_classe, id_discipline, id_personne) VALUES (?, ?, ?)");
    }

    @Override
    @SuppressWarnings("empty-statement")
  public boolean create(enseignement obj) {
     try{
        create.setObject(1, obj.getClasse());
        create.setObject(2, obj.getDiscipline());
        create.setObject(3, obj.getPersonne());
        
        create.executeUpdate();
        System.out.println("COUCOU : enseignement créé !!");
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
  public boolean delete(enseignement obj) {
    try {
            PreparedStatement delete = this.connect.prepareStatement("DELETE FROM enseignement WHERE id = " + obj.getID());         
            delete.executeUpdate();
            System.out.println("enseignement supprimée !");
        } catch (SQLException ex) {
            Logger.getLogger(bulletinDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("enseignement PAS supprimée ! ");
            return false;
        }
        return true;
  }
   
    @Override
  public boolean update(enseignement obj) {
    return false;
  }

    @Override
    public enseignement find(int id) {
        enseignement o = new enseignement();

        try {

            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM enseignement WHERE id = " + id);
            if(result.first())
                o = new enseignement(
                        id,
                        result.getInt("id_classe"),
                        result.getInt("id_discipline"),
                        result.getInt("id_personne")
                );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return o;
    }
    
}
