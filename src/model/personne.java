/**
 * contient les données à afficher
 */
package model;

public class personne {
    protected int id = 0;
    protected String nom = "";
    protected String prenom = "";
    protected String type_ = "";
    protected String userP = "";
    protected String mdp = "";
    protected int id_classe=0;

    /**
     * constructeur par default
     */
    public personne() {}
    /**
     * constructeur surchargé
     * @param id le futur id de l'objet
     * @param name le futur nom de l'objet
     * @param firstname le futur prenom de l'objet
     * @param type le futur type de l'objet ("Eleve" ou "Prof")
     * @param user le futur pseudo de l'objet
     * @param motdp le futur mot de passe de l'objet
     * @param classe le futur id de la classe de l'objet
     */
    public personne(int id,String name, String firstname, String type, String user, String motdp,int classe) {
        this.nom = name;
        this.prenom = firstname;
        this.id = id;
        this.type_ = type;
        this.userP = user;
        this.mdp = motdp;
        this.id_classe=classe;
    }

    /**
     * getter nom
     * @return le nom de l'objet
     */
    public String getName() {return nom;}
    /**
     * getter prenom
     * @return le prenom de l'objet
     */
    public String getFirstname() {return prenom;}
    /**
     * getter ID
     * @return l'id de l'objet
     */
    public int getID() {return id;}
    /**
     * getter type
     * @return le type de l'objet (prof ou eleve)
     */
    public String getType(){return type_;}
    /**
     * getter Pseudo
     * @return le pseudo de l'objet
     */
    public String getUser(){return userP;}
    /**
     * getter mot de passe
     * @return le mot de passe de l'objet
     */
    public String getmdp(){return mdp;}
    /**
     * getter ID classe
     * @return l'id de la classe de l'objet
     */
    public int getId_classe() {
        return id_classe;
    }

    /**
     * setter nom
     * @param name le nouveau nom de l'objet 
     */
    public void setName(String name) {this.nom = name;}
    /**
     * setter prenom
     * @param firstname le nouveau prenom de l'objet 
     */
    public void setFirstname(String firstname) {this.prenom = firstname;}
    /**
     * setter ID
     * @param id le nouvel id de l'objet 
     */
    public void setId(int id) {this.id = id;}
    /**
     * setter Type
     * @param type le nouveau Type de l'objet (Prof ou Eleve) 
     */
    public void setType(String type){this.type_ = type;}
    /**
     * setter Pseudo
     * @param user le nouveau pseudo de la personne
     */
    public void setUser(String user){this.userP = user;}
    /**
     * setter mot de passe
     * @param mdp le nouveau mot de passe de l'objet
     */
    public void setMDP(String mdp){this.mdp = mdp;}
}
