package Exercice1;

public class Adherent extends Personne{
    private int numAdherent;

    public Adherent(String nom, String prenom, int age, String email, String telephone,int numAdherent) {
        super(nom, prenom, age, email, telephone);
        this.numAdherent = numAdherent;
    }

    @Override
    public void affiche() {
        super.affiche();
        System.out.println("num Adherent : " + numAdherent);
        System.out.println();
    }
}
