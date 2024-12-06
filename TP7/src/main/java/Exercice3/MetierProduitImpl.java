package Exercice3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MetierProduitImpl implements IMetier<Produit> {
    private List<Produit> produits = new ArrayList<>();
    private final String fileName;

    public MetierProduitImpl(String fileName) {
        this.fileName = fileName;
        this.produits = getAll(); // Charger les données du fichier
    }

    @Override
    public Produit add(Produit o) {
        produits.add(o);
        saveAll(); // Sauvegarder après l'ajout
        return o;
    }

    @Override
    public List<Produit> getAll() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (List<Produit>) ois.readObject();
        } catch (FileNotFoundException e) {
            return new ArrayList<>(); // Retourne une liste vide si le fichier n'existe pas
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public Produit findByNom(String nom) {
        for (Produit produit : produits) {
            if (produit.getNom().equals(nom)) {
                return produit;
            }
        }
        return null;
    }

    @Override
    public void delete(String nom) {
        produits.removeIf(produit -> produit.getNom().equals(nom));
        saveAll(); // Sauvegarder après suppression
    }

    @Override
    public void saveAll() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(produits);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

