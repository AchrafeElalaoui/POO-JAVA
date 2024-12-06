package Exercice3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MetierClientImpl implements IMetier<Client> {
    private List<Client> clients = new ArrayList<>();
    private final String fileName;

    public MetierClientImpl(String fileName) {
        this.fileName = fileName;
        this.clients = getAll(); // Charger les données du fichier
    }

    @Override
    public Client add(Client o) {
        clients.add(o);
        saveAll(); // Sauvegarder après l'ajout
        return o;
    }

    @Override
    public List<Client> getAll() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (List<Client>) ois.readObject();
        } catch (FileNotFoundException e) {
            return new ArrayList<>(); // Retourne une liste vide si le fichier n'existe pas
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public Client findByNom(String nom) {
        for (Client client : clients) {
            if (client.getNom().equals(nom)) {
                return client;
            }
        }
        return null;
    }

    @Override
    public void delete(String nom) {
        clients.removeIf(client -> client.getNom().equals(nom));
        saveAll(); // Sauvegarder après suppression
    }

    @Override
    public void saveAll() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(clients);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

