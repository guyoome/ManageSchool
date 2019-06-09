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

    public personne() {}

    public personne(int id,String name, String firstname, String type, String user, String motdp,int classe) {
        this.nom = name;
        this.prenom = firstname;
        this.id = id;
        this.type_ = type;
        this.userP = user;
        this.mdp = motdp;
        this.id_classe=classe;
    }


    public String getName() {return nom;}
    public String getFirstname() {return prenom;}
    public int getID() {return id;}
    public String getType(){return type_;}
    public String getUser(){return userP;}
    public String getmdp(){return mdp;}

    public int getId_classe() {
        return id_classe;
    }

    public void setName(String name) {this.nom = name;}
    public void setFirstname(String firstname) {this.prenom = firstname;}
    public void setId(int id) {this.id = id;}
    public void setType(String type){this.type_ = type;}
    public void setUser(String user){this.userP = user;}
    public void setMDP(String mdp){this.mdp = mdp;}
}
