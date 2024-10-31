package Exercice4;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        MetierProduitImpl mpi = new MetierProduitImpl();
        for(Produit p : mpi.getAll()){
            System.out.println(p);
        }
        System.out.println("le(s) produit(s) cherche est(sont) :"+mpi.findByNom("tide"));

        mpi.add(new Produit(66L,"stylo","11","produit_7",1000,1));
        System.out.println("produit par id :"+mpi.findById(2L));
        mpi.delete(2L);
    }
}
