/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author helen
 */
public class DAOFactory extends AbstractDAOFactory{
  protected static final Connection conn;
  protected static Connexion newConnection;
  
  /**
     * this is a specific way to init final variable throwing exceptions
     */
    static{
        Connection tmp = null;
        
        try {
            // subscribe to your DriverManager as we use mysql-connector add this :
            Class.forName("com.mysql.jdbc.Driver"); 
            // get the connection variable
            // jdbc:mysl:// is the protocol URI (like http:// is for http)
            // localhost cause we are from a wamp server
            // ecole is the name of database
            // second parameter the id for connecting to the mysql db ( on phpmyadmin)
            // thirs parameter is the password
            tmp = DriverManager.getConnection("jdbc:mysql://localhost/projetjava","root","");
         } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(DAOFactory.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("SALUT GUILLAUME");
         }
        conn = tmp;
      /*try {
          newConnection = new Connexion("projetjava", "root", "");
          newConnection.setConnect(conn);
      } catch (SQLException | ClassNotFoundException ex) {
          Logger.getLogger(DAOFactory.class.getName()).log(Level.SEVERE, null, ex);
      }*/
        
    }

/*  public DAO getAnnneScolaireDAO(){
    return new anneescolaireDAO(conn);
  }*/

  @Override
  public DAO getBulletinDAO(){
      try {
          return new bulletinDAO(conn);
      } catch (SQLException ex) {
          Logger.getLogger(DAOFactory.class.getName()).log(Level.SEVERE, null, ex);
      }
      return null;
  }
  
  @Override
  public DAO getAnneeScolaireDAO(){
      try {
          return new anneescolaireDAO(conn);
      } catch (SQLException ex) {
          Logger.getLogger(DAOFactory.class.getName()).log(Level.SEVERE, null, ex);
      }
      return null;
  }
  
  @Override
  public DAO getClasseDAO(){
      try {
          return new classeDAO(conn);
      } catch (SQLException ex) {
          Logger.getLogger(DAOFactory.class.getName()).log(Level.SEVERE, null, ex);
      }
      return null;
  }
  
  
  @Override
  public DAO getDetailBulletinDAO(){
      try {
          return new detailbulletinDAO(conn);
      } catch (SQLException ex) {
          Logger.getLogger(DAOFactory.class.getName()).log(Level.SEVERE, null, ex);
      }
      return null;
  }
  
  @Override
  public DAO getDisciplineDAO(){
      try {
          return new disciplineDAO(conn);
      } catch (SQLException ex) {
          Logger.getLogger(DAOFactory.class.getName()).log(Level.SEVERE, null, ex);
      }
      return null;
  }
  
  @Override
  public DAO getEcoleDAO(){
      try {
          return new ecoleDAO(conn);
      } catch (SQLException ex) {
          Logger.getLogger(DAOFactory.class.getName()).log(Level.SEVERE, null, ex);
      }
      return null;
  }

}