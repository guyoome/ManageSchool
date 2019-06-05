package controller;



import java.util.Calendar;
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
        
        ///TEST EVALUATION -------------------------------------------------------------------------------------------
        DAO<evaluation> evaluationDAO = adf.getEvaluationDAO();
              
        //creation
        evaluation newEv = new evaluation(0,"Attention aux fautes de calculs",13,0);
        evaluationDAO.create(newEv);
        
        //find 
        evaluation ev = evaluationDAO.find(1);
        System.out.println("ID EVALUATION: " + ev.getID());
        System.out.println("Appreciation : " + ev.getAppreciation());
        System.out.println("Note : " + ev.getNote());
        System.out.println("DetailBulletin : " + ev.getDetailBulletin());
        
        //delete
        //evaluationDAO.delete(ev);
        
        ///TEST INSCRIPTION -------------------------------------------------------------------------------------------
        DAO<inscription> inscriptionDAO = adf.getInscriptionDAO();
              
        //creation
        inscription newIns = new inscription(0,1,3);
        inscriptionDAO.create(newIns);
        
        //find 
        inscription ins = inscriptionDAO.find(1);
        System.out.println("ID INSCRIPTION: " + ins.getID());
        System.out.println("classe : " + ins.getClasse());
        System.out.println("personne : " + ins.getPersonne());
        
        //delete
        //inscriptionDAO.delete(ins);
        
        ///TEST NIVEAU -------------------------------------------------------------------------------------------
        DAO<niveau> niveauDAO = adf.getNiveauDAO();
              
        //creation
        niveau newNiv = new niveau(0,"CE1");
        niveauDAO.create(newNiv);
        
        //find 
        niveau niv = niveauDAO.find(2);
        System.out.println("ID NIVEAU: " + niv.getID());
        System.out.println("nom : " + niv.getNom());
        
        //delete
        //niveauDAO.delete(niv);
        
        ///TEST PERSONNE -------------------------------------------------------------------------------------------
        DAO<personne> personneDAO = adf.getPersonneDAO();
              
        //creation
        personne moi = new personne(0,"Helene", "Carlier-Gubler", "Prof", "LogNep", "coucou");
        personneDAO.create(moi);
        
        //find 
        personne toi = personneDAO.find(2);
        System.out.println("ID PERSONNE: " + toi.getID());
        System.out.println("nom : " + toi.getName());
        System.out.println("prenom : " + toi.getFirstname());
        System.out.println("type : " + toi.getType());
        System.out.println("user : " + toi.getUser());
        System.out.println("mdp : " + toi.getmdp());
        
        //delete
        //personneDAO.delete(toi);
        
        ///TEST TRIMESTRE -------------------------------------------------------------------------------------------
        DAO<trimestre> trimestreDAO = adf.getTrimestreDAO();
              
        //creation
        trimestre Newtrim = new trimestre(0,3,"01/09/2018","31/06/2019", 0);
        trimestreDAO.create(Newtrim);
        
        //find 
        trimestre trim = trimestreDAO.find(1);
        System.out.println("ID TRIMESTRE: " + trim.getID());
        System.out.println("numero : " + trim.getNum());
        System.out.println("debut : " + trim.getDebut());
        System.out.println("fin : " + trim.getFin());
        System.out.println("annee scolaire : " + trim.getAnneeScolaire());
        
        //delete
        //personneDAO.delete(toi);
        
        
        
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
