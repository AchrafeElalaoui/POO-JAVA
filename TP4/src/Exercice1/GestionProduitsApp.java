package Exercice1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestionProduitsApp {
    public static void main(String[] args) {
        List<Produit> produits = new ArrayList();
        produits.add(new Produit(1, "Pizza", 200.0));
        produits.add(new Produit(2, "danon", 1.0));
        produits.add(new Produit(3, "cheese", 2.0));
        produits.add(new Produit(4, "ola", 2.5));

        produits.remove(0);

        produits.forEach(produit -> System.out.println(produit.toString()));
        produits.set(1, new Produit(1,"tesla",1234000.0));
        Scanner input =new Scanner(System.in);
        System.out.println("Entre a name: ");
        String nom = input.nextLine();

        int i=0;
        for(Produit p :produits){
            if (p.getNom().equals(nom)){
                System.out.println(p.toString());
                break;
            }
            else i++;
        }

        if(i==produits.size()){
            System.out.println("Produit n'existe pas !");
        }
    }
}