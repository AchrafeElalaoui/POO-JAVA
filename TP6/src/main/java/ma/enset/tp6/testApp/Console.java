package ma.enset.tp6.testApp;

import ma.enset.tp6.metier.ImpImetier;
import ma.enset.tp6.models.Departement;
import ma.enset.tp6.models.Professeur;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class Console {
    public static void main(String[] args) {
        ImpImetier metier = new ImpImetier(); // Instantiate the implementation class
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Afficher tous les professeurs");
            System.out.println("2. Rechercher des professeurs par mot clé");
            System.out.println("3. Ajouter un professeur");
            System.out.println("4. Modifier un professeur");
            System.out.println("5. Supprimer un professeur");
            System.out.println("6. Afficher tous les départements");
            System.out.println("7. Ajouter un département");
            System.out.println("8. Modifier un département");
            System.out.println("9. Supprimer un département");
            System.out.println("10. Afficher les professeurs d'un département");
            System.out.println("0. Quitter");

            System.out.print("\nVotre choix: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> {
                    List<Professeur> professeurs = metier.getProfesseurs();
                    professeurs.forEach(System.out::println);
                }
                case 2 -> {
                    System.out.print("Entrez le mot clé: ");
                    String motCle = scanner.nextLine();
                    List<Professeur> resultats = metier.chercherParMotCle(motCle);
                    resultats.forEach(System.out::println);
                }
                case 3 -> {
                    Professeur professeur = new Professeur();
                    System.out.print("Nom: ");
                    professeur.setNom(scanner.nextLine());
                    System.out.print("Prénom: ");
                    professeur.setPrenom(scanner.nextLine());
                    System.out.print("CIN: ");
                    professeur.setCin(scanner.nextLine());
                    System.out.print("Adresse: ");
                    professeur.setAdresse(scanner.nextLine());
                    System.out.print("Téléphone: ");
                    professeur.setTelephone(scanner.nextLine());
                    System.out.print("Email: ");
                    professeur.setEmail(scanner.nextLine());
                    System.out.print("Date de recrutement (YYYY-MM-DD): ");
                    professeur.setDate_recrutement(Date.valueOf(scanner.nextLine()));
                    System.out.print("ID Département: ");
                    professeur.setId_deprat(scanner.nextInt());
                    scanner.nextLine(); // Consume newline

                    metier.ajouterProfesseur(professeur);
                    System.out.println("Professeur ajouté avec succès.");
                }
                case 4 -> {
                    Professeur professeur = new Professeur();
                    System.out.print("ID du professeur à modifier: ");
                    professeur.setId_prof(scanner.nextInt());
                    scanner.nextLine(); // Consume newline
                    System.out.print("Nom: ");
                    professeur.setNom(scanner.nextLine());
                    System.out.print("Prénom: ");
                    professeur.setPrenom(scanner.nextLine());
                    System.out.print("CIN: ");
                    professeur.setCin(scanner.nextLine());
                    System.out.print("Adresse: ");
                    professeur.setAdresse(scanner.nextLine());
                    System.out.print("Téléphone: ");
                    professeur.setTelephone(scanner.nextLine());
                    System.out.print("Email: ");
                    professeur.setEmail(scanner.nextLine());
                    System.out.print("Date de recrutement (YYYY-MM-DD): ");
                    professeur.setDate_recrutement(Date.valueOf(scanner.nextLine()));
                    System.out.print("ID Département: ");
                    professeur.setId_deprat(scanner.nextInt());
                    scanner.nextLine(); // Consume newline

                    metier.modifierProfesseur(professeur);
                    System.out.println("Professeur modifié avec succès.");
                }
                case 5 -> {
                    System.out.print("ID du professeur à supprimer: ");
                    int idProf = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    metier.supprimerProfesseur(idProf);
                    System.out.println("Professeur supprimé avec succès.");
                }
                case 6 -> {
                    List<Departement> departements = metier.getDepartements();
                    departements.forEach(System.out::println);
                }
                case 7 -> {
                    Departement departement = new Departement();
                    System.out.print("Nom du département: ");
                    departement.setNom(scanner.nextLine());

                    metier.ajouterDepartement(departement);
                    System.out.println("Département ajouté avec succès.");
                }
                case 8 -> {
                    Departement departement = new Departement();
                    System.out.print("ID du département à modifier: ");
                    departement.setId_deprat(scanner.nextInt());
                    scanner.nextLine(); // Consume newline
                    System.out.print("Nom: ");
                    departement.setNom(scanner.nextLine());

                    metier.modifierDepartement(departement);
                    System.out.println("Département modifié avec succès.");
                }
                case 9 -> {
                    System.out.print("ID du département à supprimer: ");
                    int idDepartement = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    metier.supprimerDepartement(idDepartement);
                    System.out.println("Département supprimé avec succès.");
                }
                case 10 -> {
                    System.out.print("ID du département: ");
                    int idDepartement = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    List<Professeur> professeurs = metier.getProfesseursDepartement(idDepartement);
                    professeurs.forEach(System.out::println);
                }
                case 0 -> {
                    System.out.println("Application terminée.");
                    scanner.close();
                    System.exit(0);
                }
                default -> System.out.println("Choix invalide. Veuillez réessayer.");
            }
        }
    }
}
