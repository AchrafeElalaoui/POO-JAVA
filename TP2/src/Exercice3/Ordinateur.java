package Exercice3;

public class Ordinateur {
    private String nom;
    private String marque;
    private double prix;
    private String description;
    private int nbrStock;

    public Ordinateur(int nbrStock, String description, double prix, String marque, String nom) {
        this.nbrStock = nbrStock;
        this.description = description;
        this.prix = prix;
        this.marque = marque;
        this.nom = nom;
    }

    public Ordinateur() {}

    public double getPrixQ(int quantite) {
        return prix*quantite;
    }

    public double getPrix() {
        return prix;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNbrStock() {
        return nbrStock;
    }

    public void setNbrStock(int nbrStock) {
        this.nbrStock = nbrStock;
    }

    @Override
    public String toString() {
        return "Ordinateur{" +
                "nom='" + nom + '\'' +
                ", marque='" + marque + '\'' +
                ", prix=" + prix +
                ", description='" + description + '\'' +
                ", nbrStock=" + nbrStock +
                '}';
    }
}
