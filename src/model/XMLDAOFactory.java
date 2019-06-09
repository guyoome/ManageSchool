/*
 * contient les données à afficher
 */
package model;

/**
 *@source https://openclassrooms.com/en/courses/26832-apprenez-a-programmer-en-java/26830-liez-vos-tables-avec-des-objets-java-le-pattern-dao
 * @author helen
 *  classe necessaire pour relier les tables et les classes
 */
public class XMLDAOFactory extends AbstractDAOFactory {
  
    
   @Override
   public DAO getBulletinDAO() {
    return null;
   }
   
   @Override
    public DAO getAnneeScolaireDAO() {
        return null;
    }
    
    @Override
    public DAO getClasseDAO() {
        return null;
    }
    
    @Override
    public DAO getDetailBulletinDAO() {
        return null;
    }
    
    @Override
    public DAO getDisciplineDAO() {
        return null;
    }
    
    @Override
    public DAO getEcoleDAO() {
        return null;
    }
    
    @Override
    public DAO getEnseignementDAO() {
        return null;
    }
    
    @Override
    public DAO getEvaluationDAO() {
        return null;
    }
    
    @Override
    public DAO getInscriptionDAO() {
        return null;
    }
    
    @Override
    public DAO getNiveauDAO() {
        return null;
    }
    
    @Override
    public DAO getPersonneDAO() {
        return null;
    }
    
    @Override
    public DAO getTrimestreDAO() {
        return null;
    }
}