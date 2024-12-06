package Exercice1;
import java.io.File;
import java.util.Scanner;

public class LsFiles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Demander le chemin du répertoire
        System.out.print("Entrez le chemin complet du répertoire : ");
        String chemin = scanner.nextLine();

        File repertoire = new File(chemin);

        // Vérifier si le chemin est un répertoire valide
        if (repertoire.exists() && repertoire.isDirectory()) {
            listerContenu(repertoire, "");
        } else {
            System.out.println("Le chemin spécifié n'est pas un répertoire valide.");
        }

        scanner.close();
    }


    public static void listerContenu(File repertoire, String indentation) {

        File[] contenus = repertoire.listFiles();

        if (contenus != null) {
            for (File fichier : contenus) {
                // Déterminer si c'est un fichier ou un répertoire
                String type = fichier.isDirectory() ? "<DIR>" : "<FICH>";

                // Modes d'accès
                String droits = (fichier.canRead() ? "r" : "-") +
                        (fichier.canWrite() ? "w" : "-") +
                        (fichier.isHidden() ? "h" : "-");

                // Afficher les informations
                System.out.println(indentation + fichier.getAbsolutePath() + " " + type + " " + droits);

                // Si c'est un répertoire, explorer récursivement
                if (fichier.isDirectory()) {
                    listerContenu(fichier, indentation + "    ");
                }
            }
        }
    }
}


