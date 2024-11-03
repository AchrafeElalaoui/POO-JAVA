## EXERCISE 1
This is a simple Java application to manage books and members (adherents) of a library. The application defines classes for people, adherents, authors, and books, and includes a main method to test their functionalities.

## Project Structure

The application consists of the following classes:

1. **Personne Class**
    - Represents a person with private attributes: `nom`, `prenom`, `email`, `tel`, and `age`.
    - Includes a constructor to initialize these attributes.
    - Contains a method `afficher()` to print out these attributes.

2. **Adherent Class**
    - Inherits from the `Personne` class.
    - Adds an attribute `numAdherent`.
    - Overrides the `afficher()` method to show all adherent details.

3. **Auteur Class**
    - Inherits from the `Personne` class.
    - Adds an attribute `numAuteur`.
    - Overrides the `afficher()` method to show all author details.

4. **Book Class**
    - Represents a book with an attribute `ISBN` (an integer) and an `author`.
    - Includes a `afficher()` method to show the book's ISBN, titre, and author details.

## Main Application

The main application includes a `main()` method for testing the different classes:

1. Declares and initializes an adherent.
2. Declares and initializes a book written by an author.
3. Displays the details of the adherent and the book.
##### Code of main()
```java
public class Application1 {
    public static void main(String[] args) {
        Adherent adherent=new Adherent("radwan","khoya",20,"red@gmail.com","0653424352",1);
        Auteur auteur=new Auteur("oussama","dohiri",20,"dohe@gmail.com","0653464352",32);
        Livre livre=new Livre(123,auteur,"les maisirable");
        adherent.affiche();
        livre.affiche();
    }
}
```
##### Example of result
```text
Nom: radwan
Prenom: khoya
Age: 20
Email: red@gmail.com
Telephone: 0653424352
num Adherent : 1

ISBN: 123
titre: les maisirable

l'auteur :
Nom: oussama
Prenom: dohiri
Age: 20
Email: dohe@gmail.com
Telephone: 0653464352
Num Auteur: 32
```
# EXERCISE 2
This Java application is designed to manage the salaries of engineers and managers in a software development company. It defines an abstract `Employe` class and specific classes for `Ingénieur` and `Manager`, each with custom salary calculations.

## Project Structure

The application consists of the following classes:

1. **Employe Class (Abstract)**
   - Represents a company employee with attributes: `nom`, `prenom`, `email`, `telephone`, and `salaire`.
   - Includes constructors with and without parameters.
   - Defines an abstract method `calculerSalaire()` that calculates and returns the employee's salary.

2. **Ingénieur Class**
   - Inherits from `Employe`.
   - Adds an attribute `specialité` representing the engineer's specialization.
   - Overrides the `calculerSalaire()` method to apply a 15% increase to the engineer's base salary.

3. **Manager Class**
   - Inherits from `Employe`.
   - Adds an attribute `service` representing the manager's department.
   - Overrides the `calculerSalaire()` method to apply a 20% increase to the manager's base salary.

## Main Application

The main application includes a `main()` method for testing the classes:

1. Declares and initializes an `Ingénieur`.
2. Declares and initializes a `Manager`.
3. Displays the details of the `Ingénieur` and `Manager`, including `nom`, `prenom`, `salaire`, `service`, and `specialité`.
##### Code of main()
```java
public class Application2 {
   public static void main(String[] args) {
      Manager manager=new Manager(7000,"0654738712","mohamed@gmail.com","mohamed","elwazani","tectac");
      Ingenieur ingenieur =new Ingenieur(8000,"0765646312","hassan@gmail.com","hassan","sodani","informatique");
      manager.calculerSalire();
      ingenieur.calculerSalire();
      System.out.println(manager.toString());
      System.out.println(ingenieur.toString());
   }
}
```
##### Example of result
```text
Manger : 
nom : elwazani
prenom : mohamed
email : mohamed@gmail.com
salaire : 7000.0
telephone : 0654738712
service : tectac
ingenieur : 
nom : sodani
prenom : hassan
email : hassan@gmail.com
salaire : 8000.0
telephone : 0765646312
specialite : informatique
```
# EXERCISE 3

This Java application is designed to manage customer orders, computer categories, and individual computer items for a company that sells computers. It allows for the management of computer categories, computer items, and orders.

## Project Structure

The application consists of the following classes:

1. **Ordinateur Class**
   - Represents a computer with attributes: `nom`, `marque`, `prix`, `description`, and `nombreEnStock`.
   - Each computer belongs to a `Catégorie`.
   - Includes a method that returns the total price for a given quantity of computers.

2. **Catégorie Class**
   - Represents a category of computers with attributes: `nom`, `description`, and a list of `ordinateurs`.
   - Contains a method `ajouterOrdinateur()` to add a new computer to the list (with a check to avoid duplicates).
   - Contains a method `supprimerOrdinateur()` to remove a computer from the list.
   - Contains a method `rechercherParPrix()` to return a list of computers filtered by a given price.

3. **Commande Class**
   - Represents an order with attributes: `référence`, `client`, `dateCommande`, and `étatCommande`.

4. **LigneCommande Class**
   - Represents an order line with attributes: `quantité`, the associated `commande`, and the `ordinateur` being ordered.

5. **Client Class**
   - Represents a client with attributes: `nom`, `prénom`, `adresse`, `email`, `ville`, `téléphone`, and a list of `commandes` made by the client.
   - Contains a method `ajouterCommande()` to add a new order to the client’s order list (with a check to avoid duplicates).
   - Contains a method `supprimerCommande()` to remove an order from the client’s list.

Each class includes constructors (with and without parameters), getters, setters, and an overridden `toString` method for displaying object information.

## Main Application

The main application includes a `main()` method to test the functionality of the classes:

1. Declares and initializes a list of three computers.
2. Declares and initializes a category.
3. Declares and initializes a client.
4. Declares and initializes an order for the client.
5. Declares and initializes a list of three order lines for the order and the previously created computers.
6. Displays all information for the order.
##### Code of main()
not yet
##### Example of result
not yet
# EXERCISE 4
This Java application is designed to manage a collection of products using lists and interfaces. The application includes methods for adding, retrieving, searching, and deleting products.

## Project Structure

The application consists of the following components:

1. **Produit Class**
   - Represents a product with attributes: `id`, `nom`, `marque`, `prix`, `description`, and `nombreEnStock`.

2. **IMetierProduit Interface**
   - An interface that declares methods for managing `Produit` objects.
   - Includes the following methods:
      - `public Produit add(Produit p)`: Adds a product to the list.
      - `public List<Produit> getAll()`: Returns all products in the form of a list.
      - `public List<Produit> findByNom(String motCle)`: Returns a list of products whose `nom` contains the specified keyword.
      - `public Produit findById(long id)`: Returns a product by its ID.
      - `public void delete(long id)`: Deletes a product by its ID.

3. **MetierProduitImpl Class**
   - Implements the `IMetierProduit` interface.
   - Contains a list of `Produit` objects.
   - Implements the methods defined in the `IMetierProduit` interface for product management.

4. **Application Class**
- Contains the `main()` method, which provides the user with a menu in a `while` loop to interact with the product collection.
- The menu offers the following options:
1. Display the list of products.
2. Search for products by keyword.
3. Add a new product to the list.
4. Retrieve and display a product by its ID.
5. Delete a product by its ID.
##### Code of main()
not yet 
##### Example of result
not yet 