# TP1
this practical work (tp) is a group of exercises in "Arrays and strings" ,for see the practical work click [her](https://github.com/AchrafeElalaoui/POO-JAVA/blob/main/TP1/practical%20work%201.pdf) .
in this file i will explain how i solve these exercises .
Beginning with the first exercise 
## EXERCISE 1
In this exercise we will build a programme ,in which, we will receive student notes entered on the keyboard and put them in a table ,the programme allows the following operations to be carried out:
#### 1. Sort and display the list of notes.
To read the student notes entered on the keyboard we use `import java.util.Scanner;` because we need the class `Scanner`, The `Scanner` class in Java is part of the `java.util` package and is used to take input from various input sources, It's a simple and convenient way to parse primitive types (like `int`, `double`, `boolean`, etc.) and strings from the input.
We create an instance of `Scanner` named 'in',and use it to read the number and the notes of students using tne functions : `nextInt()` to read integers and `nextFloat()` to read float numbers as the following code shows :
```java
        Scanner in=new Scanner(System.in);
        EX1 ex1=new EX1();

        System.out.println("saisir lr nombre d'etudient ");
        int n= in.nextInt();

        float[] nots= new float[n];
        for (int i = 0; i < nots.length; i++) {
            System.out.println("saisir la note de l'etudient "+(i+1));
            nots[i]=in.nextFloat();
        }
```
And to sort the table of notes we use the following code :
```java
        float[] notsTriee= ex1.trierNots(nots);
        //the function trierNots()
        public float[] trierNots(float[] tab) {
            float temp;
            for (int i = 0; i < tab.length; i++) {
                for (int j = i; j < tab.length; j++) {
                    if(tab[j]<tab[i]) {
                        temp=tab[j];
                        tab[j]=tab[i];
                        tab[i]=temp;
                    }
                }
            }
            return tab;
        }
```
To display the sort list of notes we use :
```java
        System.out.println("les note triee");
        for (int i = 0; i < notsTriee.length; i++) {
            System.out.println(notsTriee[i]);
        }
```
#### 2. Show the average note.
To show the average note we use :
```java
        System.out.println("moyenne du notes");
        float moyenne=ex1.moyNots(nots);
        System.out.println(moyenne);
        // the function moyNots()
        public float moyNots(float[] tab) {
            float somme=0,moyenne;
            for (int i = 0; i < tab.length; i++) {
                somme+=tab[i];
            }
            moyenne=somme/tab.length;
            return moyenne;
        }
```