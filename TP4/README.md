# TP3
In this practical work we will manage "exceptions",to do that we're going to solve tree exercises.
to see the practical work click
## Exercises 1
In this Exercise we will manage "Lists" ,we will create a class named `Produit`, and we will use a `List` of it, and solve these questions :
1. Add products.
2. Remove a product by index.
3. Display the list of products.
4. Modify a product by index.
5. Search for a product by the name typed by the user
The solution of these questions is shown in the following code :
```java
public static void main(String[] args) {
        List<Produit> produits = new ArrayList();
        //Add products.
        produits.add(new Produit(1, "Pizza", 200.0));
        produits.add(new Produit(2, "danon", 1.0));
        produits.add(new Produit(3, "cheese", 2.0));
        produits.add(new Produit(4, "ola", 2.5));
        //Remove a product by index.
        produits.remove(0);
        //Display the list of products.
        produits.forEach(produit -> System.out.println(produit.toString()));
        //Modify a product by index.
        produits.set(1, new Produit(1,"tesla",1234000.0));
        //Search for a product by the name typed by the user.
        Scanner input =new Scanner(System.in);
        System.out.println("Entre a name: ");
        String nom = input.nextLine();
        int i=0;
        for(Produit p :produits){
            if (p.getNom().equals(nom)){
                System.out.println(p.toString());
                break;
            }else i++;
        }

        if(i==produits.size()){
            System.out.println("Produit n'existe pas !");
        }
}
```