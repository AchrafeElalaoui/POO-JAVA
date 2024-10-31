package Exercice2;

public abstract class Employe {
    protected String nom;
    protected String prenom;
    protected String email;
    protected String telephone;
    protected float salaire;

    public Employe(float salaire, String telephone, String email, String prenom, String nom) {
        this.salaire = salaire;
        this.telephone = telephone;
        this.email = email;
        this.prenom = prenom;
        this.nom = nom;
    }
    public Employe(){}
    public abstract float calculerSalire();

    @Override
    public String toString() {
        return "\nnom : "+nom+"\nprenom : "+prenom+"\nemail : "+email+"\nsalaire : "+salaire+"\ntelephone : "+telephone;
    }
}
