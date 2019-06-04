package controller;



import java.util.Scanner;
import model.DAO;
import model.bulletin;
import model.*;

public class App {
    //private People session = null;//variable de session

    public static Boolean connection(String user, String mdp) {
        Boolean isAUTH = false;
        if (user.equals("gui")) {//if user&mdp in database fct
            isAUTH = true;
            System.out.println("Connection allowed");
        } else {//if not then connection not allowed
            //error msg
            System.out.println("Connection not allowed");
        }
        return isAUTH;
    }

    public static void main(String[] args) {
        // write your code here
        
        AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
        //On récupère un objet faisant le lien entre la base et nos objets 
        
        ///TEST BULLETIN
        DAO<bulletin> bulletinDAO = adf.getBulletinDAO();
        bulletin newBu = new bulletin(0,"AB",0,0);
        bulletinDAO.create(newBu);
        
        bulletin bubu = bulletinDAO.find(1);
        System.out.println("ID BULLETIN: " + bubu.getID());
        System.out.println("Appreciation : " + bubu.getAppreciation());
        System.out.println("ID inscription : " + bubu.getIDinscription());
        System.out.println("ID trimestre " + bubu.getIDtrimestre());
        
        
        //bulletinDAO.delete(bubu);
        
        ///TEST ANNEESCOLAIRE
        
        ///PB ca n'increment pas tout seul et ca s'est embetant ... A rectifier
        
        DAO<anneescolaire> anneescolaireDAO = adf.getAnneeScolaireDAO();
        anneescolaire newAS = new anneescolaire(1);
        
        //anneescolaireDAO.create(newAS);
        
        anneescolaire anan = anneescolaireDAO.find(1);
        System.out.println("ID ANNEE SCOLAIRE: " + anan.getID());
        
        
        //anneescolaireDAO.delete(anan);
        
        
        ///TEST CLASSE
        
        DAO<classe> classeDAO = adf.getClasseDAO();
        
        //creation
        classe newClass = new classe(2, "CE1a", 0,0,0);
        classeDAO.create(newClass);
        
        //find
        classe clacla = classeDAO.find(2);
        System.out.println("ID CLASSE: " + clacla.getID());
        System.out.println("Nom : " + clacla.getNom());
        System.out.println("ID annee scolaire : " + clacla.getAnneeScolaire());
        System.out.println("ID ecole " + clacla.getEcole());
        System.out.println("ID niveau " + clacla.getNiveau());
        
        //delete
        //classeDAO.delete(clacla);
        
        
        
        
         /*       
        System.out.println("SCHOOL MANAGEMENT");
        String user, mdp;
        Scanner sc = new Scanner(System.in);
        System.out.print("user : ");
        user = sc.nextLine();
        System.out.print("mdp : ");
        mdp = sc.nextLine();
        connection(user, mdp);
        */
        
    }
}
