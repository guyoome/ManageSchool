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
public class DAOFactory extends AbstractDAOFactory{
  protected static final Connection conn = SdzConnection.getInstance();   

  public DAO getClasseDAO(){
    return new ClasseDAO(conn);
  }

  public DAO getProfesseurDAO(){
    return new ProfesseurDAO(conn);
  }

  public DAO getEleveDAO(){
    return new EleveDAO(conn);
  }

  public DAO getMatiereDAO(){
    return new MatiereDAO(conn);
  }   
}