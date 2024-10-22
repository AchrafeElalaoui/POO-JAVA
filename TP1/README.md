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
        System.out.println("moyenne du notes : " +ex1.moyNotes(nots));
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
#### 3. Show maximum and minimum note.
To show maximum and minimum note we use :
```java
        System.out.println("le max des notes est "+ex1.maxNots(notsTriee));
        System.out.printf("\n");
        System.out.println("le min des notes est "+ex1.minNots(notsTriee));
        // the functions maxNotes() and minNotes()
        public float maxNotes(float[] tab) {
            float max=tab[0];
            for (int i = 0; i < tab.length; i++) {
                if(max<tab[i]) {
                    max=tab[i];
                }
            }
            return max;
        }
        public float minNotes(float[] tab) {
             float min=tab[0];
             for (int i = 0; i < tab.length; i++) {
                if(min>tab[i]) {
                    min=tab[i];
                }
            }
        return min;
        }
```
#### 4. Display the number of students with a user-entered note.
To display this number we use the following code :
```java
        System.out.println("saisir une note");
        float not = in.nextFloat();
        System.out.println("le nombre d'etudients ayant la note "+not+" est "+ex1.nbrEtudient(nots, not));
        // the functions nbrEtudient()
        public int nbrEtudient(float[] tab,float not) {
            int count=0;
            for (int i = 0; i < tab.length; i++) {
                if(tab[i]==not) {
                    count++;
                }
            }
            return count;
        }
```
#### code source :
```java
        package tp1.alaoui;
        
        import java.util.Scanner;
        
        public class EX1 {
            public static void main(String[] args) {
                Scanner in=new Scanner(System.in);
                EX1 ex1=new EX1();
        
                System.out.println("saisir lr nombre d'etudient ");
                int n= in.nextInt();
        
                float[] nots= new float[n];
                for (int i = 0; i < nots.length; i++) {
                    System.out.println("saisir la note de l'etudient "+(i+1));
                    nots[i]=in.nextFloat();
                }
                float[] notsTriee= ex1.trierNots(nots);
        
                System.out.println("les note triee");
                for (int i = 0; i < notsTriee.length; i++) {
                    System.out.println(notsTriee[i]);
                }
        
                System.out.printf("\n");
        
                System.out.println("moyenne du notes");
                float moyenne=ex1.moyNotes(nots);
                System.out.println(moyenne);
        
                System.out.printf("\n");
        
                System.out.println("le max des notes est "+ex1.maxNotes(notsTriee));
                System.out.printf("\n");
                System.out.println("le min des notes est "+ex1.minNotes(notsTriee));
        
                System.out.printf("\n");
        
                System.out.println("saisir une note");
                float not = in.nextFloat();
                System.out.println("le nombre d'etudients ayant la note "+not+" est "+ex1.nbrEtudient(nots, not));
            }
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
            public float moyNotes(float[] tab) {
                float somme=0,moyenne;
                for (int i = 0; i < tab.length; i++) {
                    somme+=tab[i];
                }
                moyenne=somme/tab.length;
                return moyenne;
            }
            public float maxNotes(float[] tab) {
                float max=tab[0];
                for (int i = 0; i < tab.length; i++) {
                    if(max<tab[i]) {
                        max=tab[i];
                    }
                }
                return max;
            }
            public float minNotes(float[] tab) {
                float min=tab[0];
                for (int i = 0; i < tab.length; i++) {
                    if(min>tab[i]) {
                        min=tab[i];
                    }
                }
                return min;
            }
            public int nbrEtudient(float[] tab,float not) {
                int count=0;
                for (int i = 0; i < tab.length; i++) {
                    if(tab[i]==not) {
                        count++;
                    }
                }
                return count;
            }
        
        }
```
#### example result :
```java
saisir le nombre d'etudient : 5
saisir la note de l'etudient 1: 12.5
saisir la note de l'etudient 2: 14.0
saisir la note de l'etudient 3: 10.0
saisir la note de l'etudient 4: 16.5
saisir la note de l'etudient 5: 14.5
les note triee :
10.0
12.5
14.0
14.5
16.5
moyenne du notes :13.5
le max des notes est 16.5
le min des notes est 10.0
saisir une note: 14.0
le nombre d'etudients ayant la note 14.0 est 1
```

