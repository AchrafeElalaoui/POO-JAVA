package Exercice3;

import java.util.Scanner;

public class ApplicationClients {
    public static void main(String[] args) {
        MetierClientImpl clientMetier = new MetierClientImpl("clients.dat");
        Scanner scanner = new Scanner(System.in);
        int choix;

        do {
            System.out.println("\nMenu Gestion des Clients :");
            System.out.println("1. Afficher la liste des clients");
            System.out.println("2. Rechercher un client par son nom");
            System.out.println("3. Ajouter un nouveau client");
            System.out.println("4. Supprimer un client par nom");
            System.out.println("5. Sauvegarder les clients");
            System.out.println("6. Quitter");
            System.out.print("Votre choix : ");
            choix = scanner.nextInt();
            scanner.nextLine(); // Consommer la ligne restante

            switch (choix) {
                case 1:
                    System.out.println("\nListe des Clients :");
                    clientMetier.getAll().forEach(System.out::println);
                    break;

                case 2:
                    System.out.print("\nNom du client à rechercher : ");
                    String nomRecherche = scanner.nextLine();
                    Client client = clientMetier.findByNom(nomRecherche);
                    if (client != null) {
                        System.out.println("\nClient trouvé : " + client);
                    } else {
                        System.out.println("\nAucun client trouvé avec ce nom.");
                    }
                    break;

                case 3:
                    System.out.print("\nNom : ");
                    String nom = scanner.nextLine();
                    System.out.print("Prénom : ");
                    String prenom = scanner.nextLine();
                    System.out.print("Adresse : ");
                    String adresse = scanner.nextLine();
                    System.out.print("Téléphone : ");
                    String tel = scanner.nextLine();
                    System.out.print("Email : ");
                    String email = scanner.nextLine();
                    clientMetier.add(new Client(nom, prenom, adresse, tel, email));
                    System.out.println("\nClient ajouté avec succès.");
                    break;

                case 4:
                    System.out.print("\nNom du client à supprimer : ");
                    String nomSuppression = scanner.nextLine();
                    clientMetier.delete(nomSuppression);
                    System.out.println("\nClients supprimés avec succès.");
                    break;

                case 5:
                    clientMetier.saveAll();
                    System.out.println("\nClients sauvegardés avec succès.");
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

