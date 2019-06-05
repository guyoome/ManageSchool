/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author helen
 */
public abstract class AbstractDAOFactory {
  public static final int DAO_FACTORY = 0;
  public static final int XML_DAO_FACTORY = 1;

  
  //Retourne un objet Bulletin interagissant avec la BDD
  public abstract DAO getBulletinDAO();
  public abstract DAO getAnneeScolaireDAO();
  public abstract DAO getClasseDAO();
  public abstract DAO getDetailBulletinDAO();
  public abstract DAO getDisciplineDAO();
  public abstract DAO getEcoleDAO();
  public abstract DAO getEnseignementDAO();
  public abstract DAO getEvaluationDAO();
  public abstract DAO getInscriptionDAO();
  public abstract DAO getNiveauDAO();
  public abstract DAO getPersonneDAO();
  public abstract DAO getTrimestreDAO();
    
  
   
  
  //Méthode permettant de récupérer les Factory
  public static AbstractDAOFactory getFactory(int type){
    switch(type){
      case DAO_FACTORY:
        return new DAOFactory();
      case XML_DAO_FACTORY: 
        return new XMLDAOFactory();
      default:
        return null;
    }
  }
}