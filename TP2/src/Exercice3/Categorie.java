package Exercice3;

import java.util.ArrayList;
import java.util.List;

public class Categorie {
    private String nom;
    private String description;
    private List<Ordinateur> ordinateurs;

    public Categorie() {
    }

    public Categorie(String nom, String description, Ordinateur...ordinateurs) {
        this.nom = nom;
        this.description = description;
        this.ordinateurs = List.of(ordinateurs);
    }

    public void ajouterOrdinateur(Ordinateur o){
        if (ordinateurs == null){
            ordinateurs = new ArrayList<Ordinateur>();
            ordinateurs.add(o);
        }
        else{
            ordinateurs.add(o);
        }
    }
    public void supprimerOrdinateur(Ordinateur o){
        int i=0;
        for(Ordinateur ordinateur : ordinateurs ){
            if(ordinateur.equals(o)){
                ordinateurs.remove(ordinateur);
                i=1;
                break;
            }
        }
        if (i==0){
            System.out.println("Le Ordinateur n'existe pas");
        }
    }
    public List<Ordinateur> rechercherParPrix(Double prix) {
        List<Ordinateur> ord = new ArrayList();
        for (Ordinateur o : ordinateurs) {
            if (o.getPrix()==prix){
                ord.add(o);
            }
        }
        return ord;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Ordinateur> getOrdinateurs() {
        return ordinateurs;
    }

    public void setOrdinateurs(List<Ordinateur> ordinateurs) {
        this.ordinateurs = ordinateurs;
    }

    @Override
    public String toString() {
        return "Categorie{" +
                "nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", ordinateurs=" + ordinateurs +
                '}';
    }
}
