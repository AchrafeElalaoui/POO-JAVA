package exercice1;

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(143)) {
            System.out.println("Serveur démarré sur le port 143.");

            // Générer un nombre magique aléatoire entre 0 et 100
            int magicNumber = (int) (Math.random() * 100);
            System.out.println("Nombre magique généré : " + magicNumber);

            while (true) {
                System.out.println("En attente d'un joueur...");
                Socket socket = serverSocket.accept();
                System.out.println("Joueur connecté.");

                try (
                        InputStreamReader isr = new InputStreamReader(socket.getInputStream());
                        BufferedReader br = new BufferedReader(isr);
                        PrintWriter out = new PrintWriter(socket.getOutputStream(), true)
                ) {
                    out.println("Bienvenue au jeu ! Essayez de deviner le nombre entre 0 et 100.");

                    boolean win = false;

                    while (!win) {
                        // Lire la tentative du joueur
                        String input = br.readLine();
                        if (input == null) {
                            break;
                        }

                        try {
                            int guess = Integer.parseInt(input);

                            if (guess < magicNumber) {
                                out.println("C'est plus !");
                            } else if (guess > magicNumber) {
                                out.println("C'est moins !");
                            } else {
                                out.println("Félicitations ! Vous avez trouvé le nombre magique : " + magicNumber);
                                win = true;
                            }
                        } catch (NumberFormatException e) {
                            out.println("Veuillez entrer un nombre valide !");
                        }
                    }

                    System.out.println("Le joueur a terminé la partie.");
                } catch (IOException e) {
                    System.err.println("Erreur de communication avec le joueur : " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Erreur serveur : " + e.getMessage());
        }
    }
}
