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
        DAO<bulletin> bulletinDAO = adf.getBulletinDAO();
        bulletin newBu = new bulletin(0,"TB",0,0);
        bulletinDAO.create(newBu);
        
        bulletin bubu = bulletinDAO.find(1);
        System.out.println("ID : " + bubu.getID());
        System.out.println("Appreciation : " + bubu.getAppreciation());
        System.out.println("ID inscription : " + bubu.getIDinscription());
        System.out.println("ID trimestre " + bubu.getIDtrimestre());
        
        
        bulletinDAO.delete(bubu);
        

                
        System.out.println("SCHOOL MANAGEMENT");
        String user, mdp;
        Scanner sc = new Scanner(System.in);
        System.out.print("user : ");
        user = sc.nextLine();
        System.out.print("mdp : ");
        mdp = sc.nextLine();
        connection(user, mdp);
        
        //Testons des élèves
        /*DAO<bulletin> bulletinDao = new bulletinDAO.(SdzConnection.getInstance());
    for(int i = 1; i < 5; i++){
      Eleve eleve = eleveDao.find(i);
      System.out.println("Elève N°" + eleve.getId() + "  - " + eleve.getNom() + " " + eleve.getPrenom());
    }


    */
}
}
