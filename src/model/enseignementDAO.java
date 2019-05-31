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
        create = this.connect.prepareStatement("INSERT INTO enseignement (classe, discipline, personne) VALUES (?, ?, ?)");
    }

    @Override
    @SuppressWarnings("empty-statement")
  public boolean create(enseignement obj) {
     try{
        create.setObject(1, obj.getClasse());
        create.setObject(2, obj.getDiscipline());
        create.setObject(3, obj.getPersonne());
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
    return false;
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
