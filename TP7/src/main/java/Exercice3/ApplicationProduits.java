package Exercice3;

import java.util.Scanner;

public class ApplicationProduits {
    public static void main(String[] args) {
        MetierProduitImpl produitMetier = new MetierProduitImpl("produits.dat");
        Scanner scanner = new Scanner(System.in);
        int choix;

        do {
            System.out.println("\nMenu Gestion des Produits :");
            System.out.println("1. Afficher la liste des produits");
            System.out.println("2. Rechercher un produit par son nom");
            System.out.println("3. Ajouter un nouveau produit");
            System.out.println("4. Supprimer un produit par nom");
            System.out.println("5. Sauvegarder les produits");
            System.out.println("6. Quitter");
            System.out.print("Votre choix : ");
            choix = scanner.nextInt();
            scanner.nextLine(); // Consommer la ligne restante

            switch (choix) {
                case 1:
                    System.out.println("\nListe des Produits :");
                    produitMetier.getAll().forEach(System.out::println);
                    break;

                case 2:
                    System.out.print("\nNom du produit à rechercher : ");
                    String nomRecherche = scanner.nextLine();
                    Produit produit = produitMetier.findByNom(nomRecherche);
                    if (produit != null) {
                        System.out.println("\nProduit trouvé : " + produit);
                    } else {
                        System.out.println("\nAucun produit trouvé avec ce nom.");
                    }
                    break;

                case 3:
                    System.out.print("\nNom du produit : ");
                    String nom = scanner.nextLine();
                    System.out.print("Marque : ");
                    String marque = scanner.nextLine();
                    System.out.print("Prix : ");
                    double prix = scanner.nextDouble();
                    System.out.print("Description : ");
                    scanner.nextLine(); // Consommer la ligne restante
                    String description = scanner.nextLine();
                    System.out.print("Nombre en stock : ");
                    int stock = scanner.nextInt();
                    produitMetier.add(new Produit(nom, marque, prix, description, stock));
                    System.out.println("\nProduit ajouté avec succès.");
                    break;

                case 4:
                    System.out.print("\nNom du produit à supprimer : ");
                    String nomSuppression = scanner.nextLine();
                    produitMetier.delete(nomSuppression);
                    System.out.println("\nProduits supprimés avec succès.");
                    break;

                case 5:
                    produitMetier.saveAll();
                    System.out.println("\nProduits sauvegardés avec succès.");
                    break;

                case 6:
                    System.out.println("\nAu revoir !");
                    break;

                default:
                    System.out.println("\nChoix invalide, veuillez réessayer.");
            }
        } while (choix != 6);

        scanner.close();
    }
}

