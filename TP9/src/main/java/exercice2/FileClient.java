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
