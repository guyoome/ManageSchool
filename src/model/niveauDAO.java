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
    String update = "UPDATE niveau SET ";
      boolean succeed = false;
      
        if("".equals(obj.getNom())){
        } 
        else {
            update += "nom = "+"'" +obj.getNom()+"'" ;
            succeed = true;
            
        }
        
        //s'il y a quelque chose à changer
        if(succeed == true)
        {
            update += " WHERE id = " + obj.getID();
            try {
                PreparedStatement updateStm = this.connect.prepareStatement(update);         
                updateStm.executeUpdate();
                System.out.println("niveau modifié !");
            } catch (SQLException ex) {
                Logger.getLogger(niveauDAO.class.getName()).log(Level.SEVERE, null, ex);
                succeed = false;
            }  
        } 
    return succeed;
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
        ArrayList<niveau> maListe = new ArrayList<>();

        int id = 0;
        String nom = "";
        
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM niveau");
            while(result.next())
            {
                id = result.getInt("id");
                nom = result.getString("nom");
                niveau newBulletin = new niveau(id, nom);
                maListe.add(newBulletin);
            }   
        } catch (SQLException ex) {
            Logger.getLogger(niveauDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return maListe; 
    }

    @Override
    public ArrayList<niveau> rechercher(String parametreTable, String parametre) {
        niveau b = new niveau();
        ArrayList<niveau> bb = new ArrayList<>();
    
    try {
      
      ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM niveau WHERE " + parametreTable + " LIKE " + "'" + parametre + "'");
      
        while(result.next())
        {    
            b = new niveau(result.getInt("id"), result.getString("nom")); 
            bb.add(b);
        }
        } catch (SQLException e) {
         e.printStackTrace();
        }
        return bb;
    }

    @Override
    public ArrayList<niveau> rechercher(String parametreTable, int parametre) {
        niveau b = new niveau();
        ArrayList<niveau> bb = new ArrayList<>();
    
    try {
      
      ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM niveau WHERE " + parametreTable + " LIKE " + "'" + parametre + "'");
      
        while(result.next())
        {    
            b = new niveau(result.getInt("id"), result.getString("nom")); 
            bb.add(b);
        }
        } catch (SQLException e) {
         e.printStackTrace();
        }
        return bb;
    }
    
}
