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

  //Retourne un objet Classe interagissant avec la BDD
  public abstract DAO getClasseDAO();
   
  //Retourne un objet Professeur interagissant avec la BDD
  public abstract DAO getProfesseurDAO();
   
  //Retourne un objet Eleve interagissant avec la BDD
  public abstract DAO getEleveDAO();
   
  //Retourne un objet Matiere interagissant avec la BDD
  public abstract DAO getMatiereDAO();
   
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