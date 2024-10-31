package Exercice4;

public class Produit {
    private Long id;
    private String nom;
    private String marque;
    private String description;
    private int nbrStock;
    private float prix;

    public Produit(Long id, String nom, String marque, String description, int nbrStock, float prix) {
        this.id = id;
        this.nom = nom;
        this.marque = marque;
        this.description = description;
        this.nbrStock = nbrStock;
        this.prix = prix;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Produit {" +
                "id=" + id +"\n"+
                ", nom='" + nom + "\n" +
                ", marque='" + marque + "\n" +
                ", description='" + description + "\n"+
                ", nbrStock=" + nbrStock +"\n"+
                ", prix=" + prix +
                "}\n";
    }
}
