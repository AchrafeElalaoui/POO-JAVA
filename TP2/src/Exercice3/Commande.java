package Exercice3;

import java.util.Date;

public class Commande {
    private String reference;
    private Client client;
    private Date dateCommande;
    private String etatCommande;

    public Commande() {}

    public Commande(String reference, Client client, Date dateCommande, String etatCommande) {
        this.reference = reference;
        this.client = client;
        this.dateCommande = dateCommande;
        this.etatCommande = etatCommande;
    }

    public String getEtatCommande() {
        return etatCommande;
    }

    public void setEtatCommande(String etatCommande) {
        this.etatCommande = etatCommande;
    }

    public Date getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    @Override
    public String toString() {
        return "Commande{" +
                "reference='" + reference + '\'' +
                ", client=" + client +
                ", dateCommande=" + dateCommande +
                ", etatCommande='" + etatCommande + '\'' +
                '}';
    }
}
