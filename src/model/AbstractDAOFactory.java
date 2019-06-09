/*
 * contient les données à afficher
 */
package model;

/**
 * Une des classes qui permet de lier les tables et les classes
 * @author helen
 * @source https://openclassrooms.com/en/courses/26832-apprenez-a-programmer-en-java/26830-liez-vos-tables-avec-des-objets-java-le-pattern-dao
 */
public abstract class AbstractDAOFactory {
  public static final int DAO_FACTORY = 0;
  public static final int XML_DAO_FACTORY = 1;

  
  /**
 * lie la table bulletin avec la classe
 * @author helen 
 * @return un objet Bulletin interagissant avec la BDD
 */
  public abstract DAO getBulletinDAO();
 /**
 * lie la table anneScolaire avec la classe
 * @author helen 
 * @return un objet AnneeScolaire interagissant avec la BDD
 */
  public abstract DAO getAnneeScolaireDAO();
  /**
 * lie la table Classe avec la classe
 * @author helen 
 * @return un objet Classe interagissant avec la BDD
 */
  public abstract DAO getClasseDAO();
 /**
 * lie la table detail bulletin avec la classe
 * @author helen 
 * @return un objet Detail Bulletin interagissant avec la BDD
 */
  public abstract DAO getDetailBulletinDAO();
  /**
 * lie la table discipline avec la classe
 * @author helen 
 * @return un objet discipline interagissant avec la BDD
 */
  public abstract DAO getDisciplineDAO();
  /**
 * lie la table ecole avec la classe
 * @author helen 
 * @return un objet ecole interagissant avec la BDD
 */
  public abstract DAO getEcoleDAO();
  /**
 * lie la table enseignement avec la classe
 * @author helen 
 * @return un objet enseignement interagissant avec la BDD
 */
  public abstract DAO getEnseignementDAO();
  /**
 * lie la table evaluation avec la classe
 * @author helen 
 * @return un objet evaluation interagissant avec la BDD
 */
  public abstract DAO getEvaluationDAO();
  /**
 * lie la table Inscription avec la classe
 * @author helen 
 * @return un objet Inscription interagissant avec la BDD
 */
  public abstract DAO getInscriptionDAO();
  /**
 * lie la table Niveau avec la classe
 * @author helen 
 * @return un objet niveau interagissant avec la BDD
 */
  public abstract DAO getNiveauDAO();
  /**
 * lie la table Personne avec la classe
 * @author helen 
 * @return un objet personne interagissant avec la BDD
 */
  public abstract DAO getPersonneDAO();
  /**
 * lie la table trimestre avec la classe
 * @author helen 
 * @return un objet trimestre interagissant avec la BDD
 */
  public abstract DAO getTrimestreDAO();
    
  
   
  
  /**
 * Méthode permettant de récupérer les Factory
 * @author helen 
     * @param type = public static final int DAO_FACTORY (paramètre de la classe)
 * @return une AbstractDAOFactory qui va lier les tables et les classes
 */
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