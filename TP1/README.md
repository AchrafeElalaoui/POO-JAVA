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
````
