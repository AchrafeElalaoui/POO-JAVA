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
the result :
````text
Produit{id=2, nom=danon, prix=1.0}
Produit{id=3, nom=cheese, prix=2.0}
Produit{id=4, nom=ola, prix=2.5}
// case the name existe :
Entre a name: 
danon
Produit{id=2, nom=danon, prix=1.0}
// case the name not existe :
Entre a name: 
tid
Produit n'existe pas !
````
## Exercises 2
In this Exercise we will manage "Maps" ,we will create  a map `qde` of type HashMapthat stores student grades. The key is of type String representing the student's name, and the value is of type double representing the grade, and solve these questions :
1. Insert student grades
2. Increase a student's grade.
3. Remove a student's grade.
4. Display the size of the map.
5. Display the average, maximum, and minimum grade.
6. Check if there is a grade equal to 20.

And after each operation, display the list using the `forEach` loop with a lambda expression.
The solution of these questions is shown in the following code :
```java
    public static void main(String[] args) {
    HashMap<String, Double> qde = new HashMap<>();
    //1)
    qde.put("Ahmed elhkamsi", 13.0);
    qde.put("Malak jawhari", 15.0);
    qde.put("layla tindof", 10.0);
    qde.forEach((v,w)-> System.out.println(v+" : "+w));
    //2)
    System.out.println("la note avant la modification est :"+qde.get("layla tindof"));
    if(qde.get("layla tindof")<=18){
        qde.put("layla tindof",qde.get("layla tindof")+2);

    }
    else if(qde.get("layla tindof")==19){
        qde.put("layla tindof",qde.get("layla tindof")+2);
    }
    System.out.println("la note apres la modification est :"+qde.get("layla tindof"));
    System.out.println("le map apres la modification est :");
    qde.forEach((v,w)-> System.out.println(v+" : "+w));
    //3)
    qde.remove("layla tindof");
    System.out.println("le map apres la suppression est :");
    qde.forEach((v,w)-> System.out.println(v+" : "+w));
    //4)
    System.out.println("la taille du map.est : "+qde.size());
    //5)
    double s=0,min=20, max=0;
    for(String k : qde.keySet()){
        s+=qde.get(k);
        if(min>qde.get(k)){
            min=qde.get(k);
        }
        if(max<qde.get(k)){
            max=qde.get(k);
        }

    }
    System.out.println("le moyeen des notes est : "+s/qde.size());
    System.out.println("le max des notes est : "+max);
    System.out.println("le min des notes est : "+min);
    //6)
    int i=0;
    for(String k : qde.keySet()){
        if(qde.get(k)==20){
            System.out.println("la note 20 exist");
            break;
        }
        else i++;
    }
    if(i==qde.size())
        System.out.println("la note 20 n'exist pas");
}
```
the result :
````text
Malak jawhari : 15.0
layla tindof : 10.0
Ahmed elhkamsi : 13.0
la note avant la modification est :10.0
la note apres la modification est :12.0
le map apres la modification est :
Malak jawhari : 15.0
layla tindof : 12.0
Ahmed elhkamsi : 13.0
le map apres la suppression est :
Malak jawhari : 15.0
Ahmed elhkamsi : 13.0
la taille du map.est : 2
le moyeen des notes est : 14.0
le max des notes est : 15.0
le min des notes est : 13.0
la note 20 n'exist pas
````
