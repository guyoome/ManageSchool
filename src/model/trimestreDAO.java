/*
 * contient les données à afficher
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
public class trimestreDAO extends DAO<trimestre>{
     private final PreparedStatement findOne;
    private final PreparedStatement findAll;
    private final PreparedStatement create;
    
    
    public trimestreDAO(Connection conn) throws SQLException {
    super(conn);

        findOne = this.connect.prepareStatement("SELECT ");
        findAll = this.connect.prepareStatement("SELECT * FROM trimestre");
        create = this.connect.prepareStatement("INSERT INTO trimestre (numero, debut, fin, id_anneeScolaire) VALUES (?, ?, ?, ?)");
    }

    @Override
    @SuppressWarnings("empty-statement")
  public boolean create(trimestre obj) {
     try{
        create.setObject(1, obj.getNum());
        create.setObject(2, obj.getDebut());
        create.setObject(3, obj.getFin());
        create.setObject(4, obj.getAnneeScolaire());
        
        create.executeUpdate();
        System.out.println("COUCOU : trimestre créé !!");
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
  public boolean delete(trimestre obj) {
    try {
            PreparedStatement delete = this.connect.prepareStatement("DELETE FROM trimestre WHERE id = " + obj.getID());         
            delete.executeUpdate();
            System.out.println("trimestre supprimée !");
        } catch (SQLException ex) {
            Logger.getLogger(trimestreDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("trimestre PAS supprimée ! ");
            return false;
        }
        return true;
  }
   
    @Override
  public boolean update(trimestre obj) {
    String update = "UPDATE trimestre SET ";
      boolean succeed = false;
      
        if("".equals(obj.getDebut())){
        } 
        else {
            update += "debut= '" +obj.getDebut()+"'" ;
            succeed = true;
            if(!("".equals(obj.getFin())) ||
                 -1 != obj.getAnneeScolaire() ||
                 -1 != obj.getNum())
            {
                update += " , ";     
            }
        }
        if(!("".equals(obj.getFin()))){
            update += "fin= "+"'" +obj.getFin()+"'" ;
            succeed = true;
            if(-1 != obj.getAnneeScolaire() ||
                 -1 != obj.getNum())
            {
                update += " , ";     
            }
        }
        if(-1 != obj.getAnneeScolaire()){
            update += "id_anneeScolaire = '" +obj.getAnneeScolaire()+"'" ;
            succeed = true;
            if(-1 != obj.getNum())
            {
                update += " , ";     
            }
        }
        if(-1 != obj.getNum()){
            update += "numero = '" +obj.getNum()+"'" ;
            succeed = true;
        }
        
        //s'il y a quelque chose à changer
        if(succeed == true)
        {
            update += " WHERE id = " + obj.getID();
            try {
                PreparedStatement updateStm = this.connect.prepareStatement(update);         
                updateStm.executeUpdate();
                System.out.println("trimestre modifié !");
            } catch (SQLException ex) {
                Logger.getLogger(detailbulletinDAO.class.getName()).log(Level.SEVERE, null, ex);
                succeed = false;
            }  
        } 
    return succeed;
  }

    @Override
    public trimestre find(int id) {
        trimestre o = new trimestre();

        try {

            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM trimestre WHERE id = " + id);
            if(result.first())
                o = new trimestre(
                        id,
                        result.getInt("numero"),
                        result.getString("debut"),
                        result.getString("fin"),
                        result.getInt("id_anneeScolaire")
                );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return o;
    }

    @Override
    public ArrayList<trimestre> findAll() {
        ArrayList<trimestre> maListe = new ArrayList<>();

        int id = 0;
        int numero = 0;
        String debut = "";
        String fin = "";
        int id_anneeScolaire = 0;
        
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM trimestre");
            while(result.next())
            {
                id = result.getInt("id");
                numero = result.getInt("numero");
                debut = result.getString("debut");
                fin = result.getString("fin");
                id_anneeScolaire = result.getInt("id_anneeScolaire");
                trimestre newBulletin = new trimestre(id, numero,debut,fin,id_anneeScolaire);
                maListe.add(newBulletin);
            }   
        } catch (SQLException ex) {
            Logger.getLogger(trimestreDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return maListe; 
    }

    @Override
    public ArrayList<trimestre> rechercher(String parametreTable, String parametre) {
        trimestre b = new trimestre();
        ArrayList<trimestre> bb = new ArrayList<>();
    
    try {
      
      ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM trimestre WHERE " + parametreTable + " LIKE " + "'" + parametre + "'");
      
        while(result.next())
        {    
            b = new trimestre(result.getInt("id"), result.getInt("numero"), result.getString("debut"), result.getString("fin"), result.getInt("id_anneeScolaire")); 
            bb.add(b);
        }
        } catch (SQLException e) {
         e.printStackTrace();
        }
        return bb;
    }

    @Override
    public ArrayList<trimestre> rechercher(String parametreTable, int parametre) {
        trimestre b = new trimestre();
        ArrayList<trimestre> bb = new ArrayList<>();
    
    try {
      
      ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM trimestre WHERE " + parametreTable + " LIKE " + "'" + parametre + "'");
      
        while(result.next())
        {    
            b = new trimestre(result.getInt("id"), result.getInt("numero"), result.getString("debut"), result.getString("fin"), result.getInt("id_anneeScolaire")); 
            bb.add(b);
        }
        } catch (SQLException e) {
         e.printStackTrace();
        }
        return bb;
    }
    
}
