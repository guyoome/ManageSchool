/*
 * contient les données à afficher
 */
package model;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author helen
 * @param <T> object de type T
 * @source https://openclassrooms.com/en/courses/26832-apprenez-a-programmer-en-java/26830-liez-vos-tables-avec-des-objets-java-le-pattern-dao
 */
public abstract class DAO<T> {
  protected Connection connect = null;
   
  public DAO(Connection conn){
    this.connect = conn;
  }
   
  /**
  * Méthode de création
  * @param obj
  * @return boolean 
  */
  public abstract boolean create(T obj);

  /**
  * Méthode pour effacer
  * @param obj
  * @return boolean 
  */
  public abstract boolean delete(T obj);

  /**
  * Méthode de mise à jour
  * @param obj
  * @return boolean
  */
  public abstract boolean update(T obj);


    /**
  * Méthode de recherche des informations
  * @param id
  * @return T
  */
  public abstract T find(int id);



    /**
  * Méthode de recherche des informations
     * @return ArrayList<T> une arrayList contenant l'ensemble des informations de la table du type T
  */
  public abstract ArrayList<T> findAll();
  
  /**
  * Méthode de recherche des informations
     * @param parametreTable le nom dans la table
     * @param parametre le nom du paramètre contenu dans la table
     * @return ArrayList<T> les objets trouvés
  */
  public abstract ArrayList<T> rechercher(String parametreTable, String parametre);
  
  /**
  * Méthode de recherche des informations
     * @param parametreTable le nom dans la table
     * @param parametre le nom du paramètre contenu dans la table
     * @return ArrayList<T> les objets trouvés
  */
  public abstract ArrayList<T> rechercher(String parametreTable, int parametre);

}
