package Exercice2;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.io.IOException;
import java.util.Scanner;

public class DossierContact {
    private Map<String, String> contacts; // Map pour associer les noms aux numéros
    private File dossier;

    // Constructeur qui charge les contacts depuis un répertoire
    public DossierContact(String cheminDossier) throws IOException {
        contacts = new HashMap<>();
        dossier = new File(cheminDossier);

        if (!dossier.exists()) {
            dossier.mkdirs(); // Créer le répertoire s'il n'existe pas
        }

        chargerContacts();
    }

    // Charger les contacts depuis les fichiers du répertoire
    private void chargerContacts() throws IOException {
        File[] fichiers = dossier.listFiles();

        if (fichiers != null) {
            for (File fichier : fichiers) {
                if (fichier.isFile()) {
                    try (BufferedReader reader = new BufferedReader(new FileReader(fichier))) {
                        String numero = reader.readLine();
                        contacts.put(fichier.getName(), numero);
                    }
                }
            }
        }
    }

    // Ajouter un nouveau contact
    public boolean ajouterContact(String nom, String numero) throws IOException {
        if (contacts.containsKey(nom)) {
            return false; // Contact déjà existant
        }

        contacts.put(nom, numero);
        enregistrerContact(nom, numero);
        return true;
    }

    // Supprimer un contact
    public boolean supprimerContact(String nom) {
        if (contacts.containsKey(nom)) {
            contacts.remove(nom);
            File fichier = new File(dossier, nom);
            return fichier.delete(); // Supprimer le fichier associé
        }
        return false;
    }

    // Rechercher un contact par nom
    public String rechercherContact(String nom) {
        return contacts.get(nom);
    }

    // Modifier le numéro d'un contact existant
    public boolean modifierNumero(String nom, String nouveauNumero) throws IOException {
        if (contacts.containsKey(nom)) {
            contacts.put(nom, nouveauNumero);
            enregistrerContact(nom, nouveauNumero);
            return true;
        }
        return false;
    }

    // Enregistrer un contact dans un fichier
    private void enregistrerContact(String nom, String numero) throws IOException {
        File fichier = new File(dossier, nom);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fichier))) {
            writer.write(numero);
        }
    }
    public void afficherTousLesContacts() {
        File[] fichiers = dossier.listFiles(); // Récupère tous les fichiers dans le dossier
        if (fichiers == null || fichiers.length == 0) {
            System.out.println("Aucun contact trouvé.");
            return;
        }

        System.out.println("Liste des contacts :");
        for (File fichier : fichiers) {
            if (fichier.isFile()) { // Vérifie que c'est bien un fichier
                String nom = fichier.getName(); // Nom du contact (nom du fichier)
                try (BufferedReader br = new BufferedReader(new FileReader(fichier))) {
                    String numero = br.readLine(); // Lit le contenu du fichier (le numéro)
                    System.out.println(nom + " : " + numero); // Affiche le contact
                } catch (IOException e) {
                    System.err.println("Erreur lors de la lecture de " + fichier.getName());
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DossierContact dossierContact;


        try {
            dossierContact = new DossierContact("contacts");
            System.out.println("Répertoire des contacts : " + dossierContact.dossier.getAbsolutePath());// Répertoire pour stocker les fichiers
        } catch (IOException e) {
            System.err.println("Erreur lors du chargement des contacts : " + e.getMessage());
            return;
        }

        while (true) {
            // Affichage du menu
            System.out.println("\n--- Menu Annuaire Téléphonique ---");
            System.out.println("1. Rechercher un numéro de téléphone");
            System.out.println("2. Ajouter un nouveau contact");
            System.out.println("3. Supprimer un contact");
            System.out.println("4. Modifier le numéro de téléphone d'un contact");
            System.out.println("5. Afficher tous les contacts.");
            System.out.println("6. Quitter");

            System.out.print("Entrez votre choix : ");
            int choix = scanner.nextInt();
            scanner.nextLine(); // Consommer le saut de ligne

            try {
                switch (choix) {
                    case 1: // Rechercher un numéro
                        System.out.print("Entrez le nom du contact : ");
                        String nomRecherche = scanner.nextLine();
                        String numeroRecherche = dossierContact.rechercherContact(nomRecherche);
                        if (numeroRecherche != null) {
                            System.out.println("Numéro de " + nomRecherche + ": " + numeroRecherche);
                        } else {
                            System.out.println("Contact non trouvé.");
                        }
                        break;

                    case 2: // Ajouter un contact
                        System.out.print("Entrez le nom du contact : ");
                        String nomAjout = scanner.nextLine();
                        System.out.print("Entrez le numéro de téléphone : ");
                        String numeroAjout = scanner.nextLine();
                        if (dossierContact.ajouterContact(nomAjout, numeroAjout)) {
                            System.out.println("Contact ajouté avec succès.");
                        } else {
                            System.out.println("Un contact avec ce nom existe déjà.");
                        }
                        break;

                    case 3: // Supprimer un contact
                        System.out.print("Entrez le nom du contact à supprimer : ");
                        String nomSuppression = scanner.nextLine();
                        if (dossierContact.supprimerContact(nomSuppression)) {
                            System.out.println("Contact supprimé avec succès.");
                        } else {
                            System.out.println("Contact non trouvé.");
                        }
                        break;

                    case 4: // Modifier le numéro
                        System.out.print("Entrez le nom du contact : ");
                        String nomModification = scanner.nextLine();
                        System.out.print("Entrez le nouveau numéro : ");
                        String nouveauNumero = scanner.nextLine();
                        if (dossierContact.modifierNumero(nomModification, nouveauNumero)) {
                            System.out.println("Numéro modifié avec succès.");
                        } else {
                            System.out.println("Contact non trouvé.");
                        }
                        break;
                    case 5:// Afficher tous les contacts
                        dossierContact.afficherTousLesContacts();
                        break;
                    case 6: // Quitter le programme
                        System.out.println("Au revoir !");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Choix invalide. Veuillez réessayer.");
                }
            } catch (IOException e) {
                System.err.println("Erreur : " + e.getMessage());
            }
        }
    }
}

