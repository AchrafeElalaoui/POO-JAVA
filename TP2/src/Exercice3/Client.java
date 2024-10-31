package Exercice3;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private String nom;
    private String prenom;
    private String adresse;
    private String telephone;
    private String email;
    private String ville;
    private List<Commande> commandes;

    public Client(String nom, String prenom, String adresse, String telephone, String email, String ville) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.telephone = telephone;
        this.email = email;
        this.ville = ville;
        commandes=new ArrayList<>();
    }

    public Client() {}

    public void ajouterCommande(Commande c){
        if (commandes == null){
            commandes = new ArrayList<Commande>();
            commandes.add(c);
        }
        else{
            commandes.add(c);
        }
    }
    public void supprimerCommande(Commande c){
        int i=0;
        for(Commande commande : commandes ){
            if(commande.equals(c)){
                commandes.remove(commande);
                i=1;
                break;
            }
        }
        if (i==0){
            System.out.println("Le commende n'existe pas");
        }
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public List<Commande> getCommandes() {
        return commandes;
    }

    @Override
    public String toString() {
        return "Client{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", ville='" + ville + '\'' +
                ", commandes=" + commandes +
                '}';
    }

}
