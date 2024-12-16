package exercice2;

import java.io.*;
import java.net.*;

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


