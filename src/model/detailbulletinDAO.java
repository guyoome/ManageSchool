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
public class detailbulletinDAO extends DAO<detailbulletin>{
    private PreparedStatement findOne;
    private PreparedStatement findAll;
    private PreparedStatement create;
    
    
    public detailbulletinDAO(Connection conn) throws SQLException {
    super(conn);
    
    //findOne = this.connect.getConnect().prepareStatement("SELECT ");
    findAll = this.connect.prepareStatement("SELECT * FROM detailbulletin");
    create = this.connect.prepareStatement("INSERT INTO detailbulletin (appreciation, id_bulletin, id_enseignement) VALUES (?, ?, ?)");
    }

    @Override
    @SuppressWarnings("empty-statement")
  public boolean create(detailbulletin obj) {
     try{
        create.setObject(1, obj.getAppreciation());
        create.setObject(2, obj.getBulletin());
        create.setObject(3, obj.getEnseignement());
        
        create.executeUpdate();
        System.out.println("COUCOU : detailbulletin créée !!");
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
  public detailbulletin find(int id) {
    detailbulletin b = new detailbulletin();      
      
    try {
      
      ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM detailbulletin WHERE id = " + id);
      
      //String requete = "SELECT * FROM eleve WHERE id = " + id;
      //this.connect.ajouterRequete(requete);
      if(result.first())
        b = new detailbulletin(
          id,
          result.getString("appreciation"),
          result.getInt("id_bulletin"),
          result.getInt("id_enseignement")
        );         
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return b;
  }

    @Override
    public boolean delete(detailbulletin obj) {
        try {
            PreparedStatement delete = this.connect.prepareStatement("DELETE FROM detailbulletin WHERE id = " + obj.getID());         
            delete.executeUpdate();
            System.out.println("detailbulletin supprimée !");
        } catch (SQLException ex) {
            Logger.getLogger(bulletinDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("detailbulletin PAS supprimée ! ");
            return false;
        }
    return true;
    }

    @Override
    public boolean update(detailbulletin obj) {
        String update = "UPDATE detailbulletin SET ";
      boolean succeed = false;
      
        if("".equals(obj.getAppreciation())){
        } 
        else {
            update += "appreciation= "+"'" +obj.getAppreciation()+"'" ;
            succeed = true;
            if(-1 != obj.getBulletin()||
                    -1 != obj.getEnseignement())
            {
                update += " , ";     
            }
        }
        if( -1 != obj.getBulletin() ){
            update += "id_bulletin = '" + obj.getBulletin() + "'"; 
            succeed = true;
            if(-1 != obj.getEnseignement())
            {
                 update += " , ";     
            }
        }
        if( -1 != obj.getEnseignement() ){
           update += "id_enseignement = '" + obj.getEnseignement()+ "'";  
           succeed = true;
        }
        
        //s'il y a quelque chose à changer
        if(succeed == true)
        {
            update += " WHERE id = " + obj.getID();
            try {
                PreparedStatement updateStm = this.connect.prepareStatement(update);         
                updateStm.executeUpdate();
                System.out.println("detailBulletin modifié !");
            } catch (SQLException ex) {
                Logger.getLogger(detailbulletinDAO.class.getName()).log(Level.SEVERE, null, ex);
                succeed = false;
            }  
        } 
    return succeed;
    }
    

    @Override
    public ArrayList<detailbulletin> findAll() {
       ArrayList<detailbulletin> maListe = new ArrayList<>();

        int id = 0;
        String appreciation = "";
        int id_bulletin = 0;
        int id_enseignement = 0;
        
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM detailbulletin");
            while(result.next())
            {
                id = result.getInt("ID");
                appreciation = result.getString("appreciation");
                id_bulletin = result.getInt("id_bulletin");
                id_enseignement = result.getInt("id_enseignement");
                detailbulletin newBulletin = new detailbulletin(id, appreciation, id_bulletin, id_enseignement);
                maListe.add(newBulletin);
            }   
        } catch (SQLException ex) {
            Logger.getLogger(detailbulletinDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return maListe; 
    }

    @Override
    public ArrayList<detailbulletin> rechercher(String parametreTable, String parametre) {
        detailbulletin b = new detailbulletin();
        ArrayList<detailbulletin> bb = new ArrayList<>();
    
    try {
      
      ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM detailbulletin WHERE " + parametreTable + " LIKE " + "'" + parametre + "'");
      
        while(result.next())
        {    
            b = new detailbulletin(result.getInt("id"), result.getString("appreciation"), result.getInt("id_bulletin"), result.getInt("id_enseignement")); 
            bb.add(b);
        }
        } catch (SQLException e) {
         e.printStackTrace();
        }
        return bb;
    }

    @Override
    public ArrayList<detailbulletin> rechercher(String parametreTable, int parametre) {
        detailbulletin b = new detailbulletin();
        ArrayList<detailbulletin> bb = new ArrayList<>();
    
    try {
      
      ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM detailbulletin WHERE " + parametreTable + " LIKE " + "'" + parametre + "'");
      
        while(result.next())
        {    
            b = new detailbulletin(result.getInt("id"), result.getString("appreciation"), result.getInt("id_bulletin"), result.getInt("id_enseignement")); 
            bb.add(b);
        }
        } catch (SQLException e) {
         e.printStackTrace();
        }
        return bb;
    }
}
