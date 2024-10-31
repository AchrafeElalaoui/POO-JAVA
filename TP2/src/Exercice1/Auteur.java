package Exercice1;

public class Auteur extends Personne {
    private int numAuteur;

    public Auteur(String nom, String prenom, int age, String email, String telephone, int numAuteur) {
        super(nom, prenom, age, email, telephone);
        this.numAuteur = numAuteur;
    }

    @Override
    public void affiche() {
        System.out.println("l'auteur :");
        super.affiche();
        System.out.println("Num Auteur: " + numAuteur);
        System.out.println();
    }
}
