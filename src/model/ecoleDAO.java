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
 * @author helen
 */
public class ecoleDAO extends DAO<ecole> {
    private PreparedStatement findOne;
    private PreparedStatement findAll;
    private PreparedStatement create;


    public ecoleDAO(Connection conn) throws SQLException {
        super(conn);
        findOne = this.connect.prepareStatement("SELECT ");
        findAll = this.connect.prepareStatement("SELECT * FROM ecole");
        create = this.connect.prepareStatement("INSERT INTO ecole (nom_ecole, adresse) VALUES (?, ?)");
    }

    @Override
    @SuppressWarnings("empty-statement")
    public boolean create(ecole obj) {
        try {
            //create = this.connect.getConnect().prepareStatement("INSERT INTO bulletin (appreciation, id_trimestre, id_inscription) VALUES (?, ?, ?)")
            create.setObject(1, obj.getNom());
            create.setObject(2, obj.getAdresse());

            create.executeUpdate();
            System.out.println("COUCOU : ecole créé !!");
            
        } catch (SQLException sql) {
            sql.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(ecole obj) {
        try {
            PreparedStatement delete = this.connect.prepareStatement("DELETE FROM ecole WHERE id_ecole = " + obj.getID());         
            delete.executeUpdate();
            System.out.println("ecole supprimée !");
        } catch (SQLException ex) {
            Logger.getLogger(bulletinDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ecole PAS supprimée ! ");
            return false;
        }
        return true;
    }

    @Override
    public boolean update(ecole obj) {
        return false;
    }

    @Override
    public ecole find(int id) {
        ecole o = new ecole();
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM ecole WHERE id_ecole = " + id);
            if (result.first())
                o = new ecole(
                        id,
                        result.getString("nom_ecole"),
                        result.getString("adresse")
                );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return o;
    }

    @Override
    public ArrayList<ecole> findAll() {
       ArrayList<ecole> maListe = new ArrayList<>();

        int id = 0;
        String nom = "";
        String adresse = "";
        
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM ecole");
            while(result.next())
            {
                id = result.getInt("id_ecole");
                nom = result.getString("nom_ecole");
                adresse = result.getString("adresse");
                ecole newBulletin = new ecole(id, nom, adresse);
                maListe.add(newBulletin);
            }   
        } catch (SQLException ex) {
            Logger.getLogger(ecoleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return maListe; 
    }
}