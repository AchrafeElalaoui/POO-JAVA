package Exercice2;

public class Ingenieur extends Employe{
    private String specialite;

    public Ingenieur(float salaire, String telefone, String email, String prenom, String nome, String specialite) {
        super(salaire, telefone, email, prenom, nome);
        this.specialite = specialite;
    }

    @Override
    public float calculerSalire() {
        return  salaire+salaire*0.15f;
    }

    @Override
    public String toString() {
        return "ingenieur : "+super.toString()+"\nspecialite : "+specialite;
    }
}
