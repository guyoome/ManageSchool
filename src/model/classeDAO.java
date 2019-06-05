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
        String update = "UPDATE classe SET ";
      boolean succeed = false;
      
        if("".equals(obj.getNom())){
        } 
        else {
            update += "nom= "+"'" +obj.getNom()+"'" ;
            succeed = true;
            if(-1 != obj.getEcole()||
                    -1 != obj.getNiveau() ||
                    -1 != obj.getAnneeScolaire())
            {
                update += " , ";     
            }
        }
        if( -1 != obj.getEcole() ){
            update += "id_ecole = '" + obj.getEcole() + "'"; 
            succeed = true;
            if(-1 != obj.getNiveau() ||
                    -1 != obj.getAnneeScolaire())
            {
                 update += " , ";     
            }
        }
        if( -1 != obj.getNiveau() ){
            update += "id_niveau = '" + obj.getNiveau() + "'"; 
            succeed = true;
            if(-1 != obj.getAnneeScolaire())
            {
                 update += " , ";     
            }
        }
        if( -1 != obj.getAnneeScolaire() ){
           update += "id_anneeScolaire = '" + obj.getAnneeScolaire()+ "'";  
           succeed = true;
        }
        
        //s'il y a quelque chose à changer
        if(succeed == true)
        {
            update += " WHERE id = " + obj.getID();
            try {
                PreparedStatement updateStm = this.connect.prepareStatement(update);         
                updateStm.executeUpdate();
                System.out.println("classe modifié !");
            } catch (SQLException ex) {
                Logger.getLogger(classeDAO.class.getName()).log(Level.SEVERE, null, ex);
                succeed = false;
            }  
        } 
    return succeed;
    }

    @Override
    public ArrayList<classe> findAll() {
        ArrayList<classe> maListe = new ArrayList<>();

        int id = 0;
        String nom = "";
        int id_ecole = 0;
        int id_niveau = 0;
        int id_anneeScolaire = 0;
        
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM classe");
            while(result.next())
            {
                id = result.getInt("ID");
                nom = result.getString("nom");
                id_ecole = result.getInt("id_ecole");
                id_niveau = result.getInt("id_niveau");
                id_anneeScolaire = result.getInt("id_anneeScolaire");
                classe newBulletin = new classe(id, nom, id_ecole, id_niveau, id_anneeScolaire);
                maListe.add(newBulletin);
            }   
        } catch (SQLException ex) {
            Logger.getLogger(classeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return maListe;
    }

    @Override
    public ArrayList<classe> rechercher(String parametreTable, String parametre) {
        classe b = new classe();
        ArrayList<classe> bb = new ArrayList<>();
    
    try {
      
      ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM classe WHERE " + parametreTable + " LIKE " + "'" + parametre + "'");
      
        while(result.next())
        {    
            b = new classe(result.getInt("id"), result.getString("nom"), result.getInt("id_ecole"), result.getInt("id_niveau"), result.getInt("id_anneeScolaire")); 
            bb.add(b);
        }
        } catch (SQLException e) {
         e.printStackTrace();
        }
        return bb;
    }

    @Override
    public ArrayList<classe> rechercher(String parametreTable, int parametre) {
        classe b = new classe();
        ArrayList<classe> bb = new ArrayList<>();
    
    try {
      
      ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM classe WHERE " + parametreTable + " LIKE " + "'" + parametre + "'");
      
        while(result.next())
        {    
            b = new classe(result.getInt("id"), result.getString("nom"), result.getInt("id_ecole"), result.getInt("id_niveau"), result.getInt("id_anneeScolaire")); 
            bb.add(b);
        }
        } catch (SQLException e) {
         e.printStackTrace();
        }
        return bb;
    }
}