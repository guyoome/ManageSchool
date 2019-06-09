/*
 * contient les données à afficher
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
public class disciplineDAO extends DAO<discipline>{
    private PreparedStatement findOne;
    private PreparedStatement findAll;
    private PreparedStatement create;
    
    
    public disciplineDAO(Connection conn) throws SQLException {
    super(conn);
    
    //findOne = this.connect.getConnect().prepareStatement("SELECT ");
    findAll = this.connect.prepareStatement("SELECT * FROM discipline");
    create = this.connect.prepareStatement("INSERT INTO discipline (nom) VALUES (?)");
    }

    @Override
    @SuppressWarnings("empty-statement")
  public boolean create(discipline obj) {
     try{
        create.setObject(1, obj.getNom());
        
        create.executeUpdate();
        System.out.println("COUCOU : discipline créée !!");
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
  public discipline find(int id) {
    discipline b = new discipline();      
      
    try {
      
      ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM discipline WHERE id = " + id);
      
      //String requete = "SELECT * FROM eleve WHERE id = " + id;
      //this.connect.ajouterRequete(requete);
      if(result.first())
        b = new discipline(
          id,
          result.getString("nom")
        );         
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return b;
  }

    @Override
    public boolean delete(discipline obj) {
        try {
            PreparedStatement delete = this.connect.prepareStatement("DELETE FROM discipline WHERE id = " + obj.getID());         
            delete.executeUpdate();
            System.out.println("discipline supprimée !");
        } catch (SQLException ex) {
            Logger.getLogger(bulletinDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("discipline PAS supprimée ! ");
            return false;
        }
        return true;
    }

    @Override
    public boolean update(discipline obj) {
        String update = "UPDATE discipline SET ";
      boolean succeed = false;
      
        if("".equals(obj.getNom())){
        } 
        else {
            update += "nom= "+"'" +obj.getNom()+"'" ;
            succeed = true;
        }
                
        //s'il y a quelque chose à changer
        if(succeed == true)
        {
            update += " WHERE id = " + obj.getID();
            try {
                PreparedStatement updateStm = this.connect.prepareStatement(update);         
                updateStm.executeUpdate();
                System.out.println("discipline modifié !");
            } catch (SQLException ex) {
                Logger.getLogger(disciplineDAO.class.getName()).log(Level.SEVERE, null, ex);
                succeed = false;
            }  
        } 
    return succeed;
    }

    @Override
    public ArrayList<discipline> findAll() {
       ArrayList<discipline> maListe = new ArrayList<>();

        int id = 0;
        String nom = "";
        
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM discipline");
            while(result.next())
            {
                id = result.getInt("ID");
                nom = result.getString("nom");
                discipline newBulletin = new discipline(id, nom);
                maListe.add(newBulletin);
            }   
        } catch (SQLException ex) {
            Logger.getLogger(disciplineDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return maListe;  
    }

    @Override
    public ArrayList<discipline> rechercher(String parametreTable, String parametre) {
        discipline b = new discipline();
        ArrayList<discipline> bb = new ArrayList<>();
    
    try {
      
      ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM discipline WHERE " + parametreTable + " LIKE " + "'" + parametre + "'");
      
        while(result.next())
        {    
            b = new discipline(result.getInt("id"), result.getString("nom")); 
            bb.add(b);
        }
        } catch (SQLException e) {
         e.printStackTrace();
        }
        return bb;
    }

    @Override
    public ArrayList<discipline> rechercher(String parametreTable, int parametre) {
        discipline b = new discipline();
        ArrayList<discipline> bb = new ArrayList<>();
    
    try {
      
      ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM discipline WHERE " + parametreTable + " LIKE " + "'" + parametre + "'");
      
        while(result.next())
        {    
            b = new discipline(result.getInt("id"), result.getString("nom")); 
            bb.add(b);
        }
        } catch (SQLException e) {
         e.printStackTrace();
        }
        return bb;
    }

}