package Exercice3;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Application3 {
    public static void main(String[] args) {
        List<Ordinateur> ordinateurs = new ArrayList<Ordinateur>();
        Ordinateur ordinateur1=new Ordinateur(14,"un ordinateur hp",3500,"i5","hp i5");
        Ordinateur ordinateur2=new Ordinateur(10,"un ordinateur ThinkPad",3600,"i7","Thinkpad i7");
        Ordinateur ordinateur3=new Ordinateur(12,"un ordinateur mac",3400,"i6","hp i6");
        ordinateurs.add(ordinateur1);
        ordinateurs.add(ordinateur2);
        ordinateurs.add(ordinateur3);
        Categorie categorie =new Categorie("hp","les pc hp",ordinateur1);
        Client client =new Client("achraf","abidal","casa","0654535216","ach@gmail.com","casa");
        Commande commande=new Commande("123",client,new Date(),"encours de preparation");
        LigneCommande ligneCommande1=new LigneCommande(12,commande,ordinateur1);
        LigneCommande ligneCommande2=new LigneCommande(5,commande,ordinateur2);
        LigneCommande ligneCommande3=new LigneCommande(3,commande,ordinateur3);
        List<LigneCommande> ligneCommandeList=new ArrayList<>();
        ligneCommandeList.add(ligneCommande1);
        ligneCommandeList.add(ligneCommande2);
        ligneCommandeList.add(ligneCommande3);
        System.out.println(commande.toString());

    }
}
