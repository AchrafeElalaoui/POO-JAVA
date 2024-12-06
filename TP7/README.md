# TP7
In this practical work we will manage "exceptions",to do that we gonna solve tree exercises.
to see the practical work click [here](https://github.com/AchrafeElalaoui/POO-JAVA/blob/main/TP3/tp3.pdf) . 
## Exercises 1
In this exercise we will create a java programme that allows us to do the simulation the command `ls` .
we will do it with the following code :
```java
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
            listerContenu(fichier, indentation + "    ");}
      }}}
```
We use `listFiles()` to list the files of Directories and `isDirectory()` to see if the file is Directory or not .

#### the result :
````text
Entrez le chemin complet du répertoire : C:\Users\hp\Desktop\SDIA\POO-JAVA\database
C:\Users\hp\Desktop\SDIA\POO-JAVA\database\ConnectionDB.java <FICH> rw-
C:\Users\hp\Desktop\SDIA\POO-JAVA\database\controller <DIR> rw-
    C:\Users\hp\Desktop\SDIA\POO-JAVA\database\controller\DepartementController.java <FICH> rw-
    C:\Users\hp\Desktop\SDIA\POO-JAVA\database\controller\MainController.java <FICH> rw-
    C:\Users\hp\Desktop\SDIA\POO-JAVA\database\controller\ProfesseurController.java <FICH> rw-
C:\Users\hp\Desktop\SDIA\POO-JAVA\database\metier <DIR> rw-
    C:\Users\hp\Desktop\SDIA\POO-JAVA\database\metier\Imetier.java <FICH> rw-
    C:\Users\hp\Desktop\SDIA\POO-JAVA\database\metier\ImpImetier.java <FICH> rw-
C:\Users\hp\Desktop\SDIA\POO-JAVA\database\models <DIR> rw-
    C:\Users\hp\Desktop\SDIA\POO-JAVA\database\models\Departement.java <FICH> rw-
    C:\Users\hp\Desktop\SDIA\POO-JAVA\database\models\Professeur.java <FICH> rw-
````
## Exercises 2

We will create a Java program to manage the list of contact numbers for a company's clients. We assume that the numbers are stored in a directory, with each number saved in a separate file. The file name represents the contact's name and contains the contact's number and do next functions :
1. Search for a phone number by name .
to do it we use the following code :
````java
public String rechercherContact(String nom) {
   return contacts.get(nom);
}
````
2. Add a new contact.
to do it we use the following code :
````java
public boolean ajouterContact(String nom, String numero) throws IOException {
   if (contacts.containsKey(nom)) {
      return false; // Contact déjà existant
   }

   contacts.put(nom, numero);
   enregistrerContact(nom, numero);
   return true;
}
````
3. Delete a contact.
to do it we use the following code :
````java
public boolean supprimerContact(String nom) {
   if (contacts.containsKey(nom)) {
      contacts.remove(nom);
      File fichier = new File(dossier, nom);
      return fichier.delete(); // Supprimer le fichier associé
   }
   return false;
}
````
4. Update a contact's phone number.
to do it we use the following code :
````java
public boolean modifierNumero(String nom, String nouveauNumero) throws IOException {
   if (contacts.containsKey(nom)) {
      contacts.put(nom, nouveauNumero);
      enregistrerContact(nom, nouveauNumero);
      return true;
   }
   return false;
}
````
5. display all contacts (bonus):
to do it we use the following code :*
````java
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
````

### `main()`
````java
public class Calculateur {
    public Calculateur() {
    }
    public void testRacineCarree(int i) throws RacineCarreeException{
        if (i<0){
            throw new RacineCarreeException(i);
        }
    }

    public static void main(String[] args) {
        Calculateur c = new Calculateur();
        try {
            c.testRacineCarree(-5);
            c.testRacineCarree(25);
        } catch (RacineCarreeException e) {
            System.out.println(e.getMessage());
        }
    }
}
````
#### the result :
````text
--- Menu Annuaire Téléphonique ---
1. Rechercher un numéro de téléphone
2. Ajouter un nouveau contact
3. Supprimer un contact
4. Modifier le numéro de téléphone d'un contact
5. Afficher tous les contacts.
6. Quitter
Entrez votre choix : 1
Entrez le nom du contact : moh
Contact non trouvé.

Entrez votre choix : 2
Entrez le nom du contact : moh
Entrez le numéro de téléphone : 064537263
Contact ajouté avec succès.

Entrez votre choix : 3
Entrez le nom du contact à supprimer : moh
Contact supprimé avec succès.

Entrez votre choix : 4
Entrez le nom du contact : ahmede
Entrez le nouveau numéro : 064736525
Numéro modifié avec succès.

Entrez votre choix : 5
Liste des contacts :
ahmede : 064736525

Entrez votre choix : 6
Au revoir !
````

## Exercises 3
we will create a java programme to save and read lists of product and client objects in *.dat files using the concept of Generics.
We will focus on the two classes ``MetierProduitImpl`` and ``MetierClientImpl`` 
1. `MetierProduitImpl` Class
The class `MetierProduitImpl` will implements  `IMetier` interface,like the following code shows:
````java
public class MetierProduitImpl implements IMetier<Produit> {
    private List<Produit> produits = new ArrayList<>();
    private final String fileName;

    public MetierProduitImpl(String fileName) {
        this.fileName = fileName;
        this.produits = getAll(); // Charger les données du fichier
    }

    @Override
    public Produit add(Produit o) {
        produits.add(o);
        saveAll(); // Sauvegarder après l'ajout
        return o;
    }

    @Override
    public List<Produit> getAll() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (List<Produit>) ois.readObject();
        } catch (FileNotFoundException e) {
            return new ArrayList<>(); // Retourne une liste vide si le fichier n'existe pas
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public Produit findByNom(String nom) {
        for (Produit produit : produits) {
            if (produit.getNom().equals(nom)) {
                return produit;
            }
        }
        return null;
    }

    @Override
    public void delete(String nom) {
        produits.removeIf(produit -> produit.getNom().equals(nom));
        saveAll(); // Sauvegarder après suppression
    }

    @Override
    public void saveAll() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(produits);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
````
2. `MetierClientImpl` Class
The class `MetierClientImpl` will also implements `IMetier` interface (that's the main idea of the Generics concept ),like the following code shows:
````java
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
````
#### the result :
1. Product result
````text
Menu Gestion des Produits :
1. Afficher la liste des produits
2. Rechercher un produit par son nom
3. Ajouter un nouveau produit
4. Supprimer un produit par nom
5. Sauvegarder les produits
6. Quitter
Votre choix : 1

Liste des Produits :
Produit{nom='aa', marque='zz', prix=112.0, description='sxs', nombreEnStock=12}

Votre choix : 3

Nom du produit : lil
Marque : TIK
Prix : 120
Description : tiklil
Nombre en stock : 123

Produit ajouté avec succès.

Votre choix : 2

Nom du produit à rechercher : lil

Produit trouvé : Produit{nom='lil', marque='TIK', prix=120.0, description='tiklil', nombreEnStock=123}

Votre choix : 4

Nom du produit à supprimer : aa

Produits supprimés avec succès.

Votre choix : 5

Produits sauvegardés avec succès.

Votre choix : 6

Au revoir !

````
2. client result
````text
Menu Gestion des Clients :
1. Afficher la liste des clients
2. Rechercher un client par son nom
3. Ajouter un nouveau client
4. Supprimer un client par nom
5. Sauvegarder les clients
6. Quitter
Votre choix : 3

Nom : Ahmed
Prénom : Karim
Adresse : casa
Téléphone : 0765647334
Email : ahmed@gmail.com

Client ajouté avec succès.

Votre choix : 1

Liste des Clients :
Client{nom='Ahmed', prenom='Karim', adresse='casa', tel='0765647334', email='ahmed@gmail.com'}

Votre choix : 2

Nom du client à rechercher : Ahmed

Client trouvé : Client{nom='Ahmed', prenom='Karim', adresse='casa', tel='0765647334', email='ahmed@gmail.com'}

Votre choix : 5

Clients sauvegardés avec succès.

Votre choix : 4

Nom du client à supprimer : Ahmed

Clients supprimés avec succès.

Votre choix : 6

Au revoir !
````
