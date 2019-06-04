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
        
        ///TEST BULLETIN -------------------------------------------------------------------------------------------
        DAO<bulletin> bulletinDAO = adf.getBulletinDAO();
        bulletin newBu = new bulletin(0,"AB",0,0);
        bulletinDAO.create(newBu);
        
        bulletin bubu = bulletinDAO.find(1);
        System.out.println("ID BULLETIN: " + bubu.getID());
        System.out.println("Appreciation : " + bubu.getAppreciation());
        System.out.println("ID inscription : " + bubu.getIDinscription());
        System.out.println("ID trimestre " + bubu.getIDtrimestre());
        
        
        //bulletinDAO.delete(bubu);
        
        ///TEST ANNEESCOLAIRE -------------------------------------------------------------------------------------------
        
        ///PB ca n'increment pas tout seul et ca s'est embetant ... A rectifier
        
        DAO<anneescolaire> anneescolaireDAO = adf.getAnneeScolaireDAO();
        anneescolaire newAS = new anneescolaire(1);
        
        //anneescolaireDAO.create(newAS);
        
        anneescolaire anan = anneescolaireDAO.find(1);
        System.out.println("ID ANNEE SCOLAIRE: " + anan.getID());
        
        
        //anneescolaireDAO.delete(anan);
        
        
        ///TEST CLASSE -------------------------------------------------------------------------------------------
        
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
        
        ///TEST DETAIL BULLETIN -------------------------------------------------------------------------------------------
        
        DAO<detailbulletin> detailBulletinDAO = adf.getDetailBulletinDAO();
        
        //creation
        detailbulletin newDbubu = new detailbulletin(0,"Bon travail",0,0);
        detailBulletinDAO.create(newDbubu);
        
        //find
        detailbulletin dbubu = detailBulletinDAO.find(3);
        System.out.println("ID DETAIL BULLETIN: " + dbubu.getID());
        System.out.println("Appreciation : " + dbubu.getAppreciation());
        System.out.println("ID bulletin : " + dbubu.getBulletin());
        System.out.println("ID enseignement " + dbubu.getEnseignement());
        
        //delete
        //detailBulletinDAO.delete(dbubu);
        
        
        ///TEST DISCIPLINE -------------------------------------------------------------------------------------------
        
        DAO<discipline> disciplineDAO = adf.getDisciplineDAO();
        
        //creation
        discipline newdidi = new discipline(0,"art");
        disciplineDAO.create(newdidi);
        
        //find
        discipline didi = disciplineDAO.find(1);
        System.out.println("ID DISCIPLINE: " + didi.getID());
        System.out.println("Nom : " + didi.getNom());
        
        //delete
        //disciplineDAO.delete(didi);
        
        ///TEST ECOLE -------------------------------------------------------------------------------------------
        
        DAO<ecole> ecoleDAO = adf.getEcoleDAO();
        
        //creation
        ecole newecole = new ecole(0,"Lycee Richelieu", "rue Gorges Sand, Rueil Malmaison");
        ecoleDAO.create(newecole);
        
        //find
        ecole eco = ecoleDAO.find(2);
        System.out.println("ID ECOLE: " + eco.getID());
        System.out.println("Nom : " + eco.getNom());
        System.out.println("Adresse : " + eco.getAdresse());
        
        //delete
        //ecoleDAO.delete(eco);
        
        
        ///TEST ENSEIGNEMENT -------------------------------------------------------------------------------------------
        DAO<enseignement> enseignementDAO = adf.getEnseignementDAO();
              
        //creation
        enseignement newEns = new enseignement(0,0,0,0);
        enseignementDAO.create(newEns);
        
        //find 
        enseignement ens = enseignementDAO.find(1);
        System.out.println("ID ENSEIGNEMENT: " + ens.getID());
        System.out.println("Classe : " + ens.getClasse());
        System.out.println("Discipline : " + ens.getDiscipline());
        System.out.println("Personne : " + ens.getPersonne());
        
        //delete
        //enseignement.delete(ens);
        
        
        
        
        
        
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
