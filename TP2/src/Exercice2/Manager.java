package Exercice2;

public class Manager extends Employe{
    private String service;

    public Manager(float salaire, String telefone, String email, String prenom, String nome, String service) {
        super(salaire, telefone, email, prenom, nome);
        this.service = service;
    }

    @Override
    public float calculerSalire() {
        return salaire+salaire*0.15f;
    }
    public String toString() {
        return "Manger : "+super.toString()+"\nservice : "+service;
    }
}
