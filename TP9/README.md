
## EXERCISE 1
In this exercise we will to develop a Java game using sockets that allows players to guess a secret "magic number." Here's how the game will work:

1. Magic Number Definition:

- The server program will define the magic number (the secret number).
- This number is randomly generated between 0 and 100 using the static Math.random method.

2. Player Interaction:

- Players will attempt to guess the magic number.
- After each attempt, the server will inform the player whether their guess is too low or too high compared to the magic number.
##### Server ``Class``
```java
public class Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(123)) {
            System.out.println("Serveur démarré sur le port 123.");

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

```
##### Client (player) ``Class``
```java
public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 123);
             BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("Connecté au serveur du jeu.");

            // Lire les messages du serveur
            String message;
            while ((message = br.readLine()) != null) {
                System.out.println("Serveur : " + message);

                // Si le joueur a gagné, quitter la boucle
                if (message.startsWith("Félicitations")) {
                    break;
                }

                // Entrer une tentative
                System.out.print("Votre tentative : ");
                String guess = scanner.nextLine();
                out.println(guess);
            }
        } catch (IOException e) {
            System.err.println("Erreur client : " + e.getMessage());
        }
    }
}
```
##### The result
[Result](ex1.png)

# EXERCISE 2
In this exercise, we implement a simple file server with multi-client support in Java.

1. Server Program: The server:

Uses ServerSocket to listen on port 12345.
For each client, a separate thread is created.
The server checks if the requested file exists:
If it exists, its content is sent line by line.
If it doesn't exist, an error message is returned to the client.

2. Client Program: The client:

Connects to the server and sends the name of the file it wants to receive.
Displays the server's response (file content or error message).

##### Server ``FileServer Class``
```java
public class FileServer {
    private static final int PORT = 12345; // Define the port number

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("File server is running on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept(); // Accept incoming client connections
                System.out.println("Client connected: " + clientSocket.getInetAddress());
                new Thread(new ClientHandler(clientSocket)).start(); // Create a new thread for each client
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

class ClientHandler implements Runnable {
    private Socket clientSocket;

    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

            String fileName = in.readLine(); // Read the requested file name from the client
            System.out.println("Requested file: " + fileName);
            File file = new File(fileName);

            if (file.exists() && !file.isDirectory()) { // Check if the file exists
                out.println("File found, sending content...");
                sendFileContent(file, out); // Send the file content to the client
            } else {
                out.println("File not found."); // Inform the client if the file does not exist
            }
        } catch (IOException e) {
            System.err.println("Error handling client: " + e.getMessage());
        } finally {
            try {
                clientSocket.close(); // Close the client socket
            } catch (IOException e) {
                System.err.println("Error closing socket: " + e.getMessage());
            }
        }
    }

    private void sendFileContent(File file, PrintWriter out) throws IOException {
        try (BufferedReader fileReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = fileReader.readLine()) != null) {
                out.println(line); // Send each line of the file to the client
            }
        }
        out.println("End of file."); // Indicate the end of the file content
    }
}
```
##### Client ``FileClient Class``
```java
package exercice2;

import java.io.*;
import java.net.*;

public class FileClient {
    private static final String SERVER_ADDRESS = "localhost"; // Server address
    private static final int SERVER_PORT = 12345; // Server port

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.print("Enter the filename to request: ");
            String fileName = consoleReader.readLine(); // Read the file name from user input
            out.println(fileName); // Send the file name to the server

            String response;
            while ((response = in.readLine()) != null) {
                System.out.println(response); // Print the server's response
                if (response.equals("End of file.")) {
                    break; // Stop reading when the end of the file is reached
                }
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

```
##### The result
[Result](ex2.png)