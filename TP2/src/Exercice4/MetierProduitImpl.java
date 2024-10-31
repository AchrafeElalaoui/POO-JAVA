package Exercice4;

import java.util.ArrayList;
import java.util.List;

public class MetierProduitImpl implements IMetierProduit{
    private List<Produit> produits=new ArrayList<>();

    public MetierProduitImpl() {
        Produit p1 = new Produit(1L,"tide","001","produit1",2200,3);
        Produit p2 = new Produit(2L,"tide","051","produit2",212,210);
        Produit p3 = new Produit(3L,"parapluit","101","produit",123,200);
        produits.add(p1);
        produits.add(p2);
        produits.add(p3);
    }

    @Override
    public void add(Produit p) {
        produits.add(p);
        System.out.println("added");
    }

    @Override
    public List<Produit> getAll() {
        return produits;
    }

    @Override
    public List<Produit> findByNom(String motCle) {
        List<Produit> produits1=new ArrayList<>();
        for (Produit p : produits) {
            if (p.getNom().equals(motCle)){
                produits1.add(p);
            }
        }
        return produits1;
    }

    @Override
    public Produit findById(long id) {
        for (Produit p : produits) {
            if (p.getId() == id){
                return p;
            }
        }
        return null;
    }

    @Override
    public void delete(long id) {
        int i=0;
        for (Produit p : produits) {
            if (p.getId() == id){
                produits.remove(p);
                System.out.println("deleted");
                i=1;
            }
        }
        if (i==0){
            System.out.println("produits n'existe pas");
        }
    }
}
