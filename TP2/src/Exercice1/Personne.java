package Exercice1;

public class Personne {
    protected String nom;
    protected String prenom;
    protected int age;
    protected String email;
    protected String telephone;

    public Personne(String nom, String prenom, int age, String email, String telephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.email = email;
        this.telephone = telephone;
    }
    public void affiche() {
        System.out.println("Nom: " + nom);
        System.out.println("Prenom: " + prenom);
        System.out.println("Age: " + age);
        System.out.println("Email: " + email);
        System.out.println("Telephone: " + telephone);
    }
}
