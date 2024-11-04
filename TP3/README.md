# TP3
In this practical work we will manage "exceptions",to do that we gonna solve tree exercises.
to see the practical work click [here](https://github.com/AchrafeElalaoui/POO-JAVA/blob/main/TP3/tp3.pdf) . 
## Exercises 1
1. `TropViteException` Class
In this exercise we will create a java programme that allows us to see if a vehicular pass the allow speed.
we will do it with the class `TropViteException`, like the following code shows :
```java
public class TropViteException extends Exception{
    public TropViteException(int i){
        super("C'est une exception de type TropViteException. Vitesse en cause :"+i);
    }
}
```
the class `TropViteException` will extend the class Exception wish present a personalized exception wish triggered when a vehicular pass the allow speed.
2. `Vehicule` Class
   this class will have no variables , only one function `testVitesse()` wish take an integer as argument and generate our exception if that integer pass 90.
   Also the `main()` exist in this class,wish allows as to test our programme with `try`and `catch` as the following code shows:
````java
public class Vehicule {
    public Vehicule() {
    }
    public void testVitesse(int i)throws TropViteException{
        if (i>90){
            throw new TropViteException(i);
        }

    }

    public static void main(String[] args) throws TropViteException {
        Vehicule v = new Vehicule();
        try {
            v.testVitesse(23);
            v.testVitesse(123);
        }catch (TropViteException e){
            System.out.println(e.getMessage());
        }
    }
}
````
#### the result :
````text
C'est une exception de type TropViteException. Vitesse en cause :123
````
## Exercises 2
we will create a java programme wish manage the signe of numbers ,if the number is negative the exception will be triggered.
1. `RacineCarreeException` Class
The class `RacineCarreeException` will extend `Exception` class,like the following code shows:
````java
public class RacineCarreeException extends Exception {
    public RacineCarreeException(int i) {
        super("C'est une exception de type RacineCarreeException. Nombre négatif :"+ i);
    }
}
````
2. `Calculateur` Class
this class will have no variables , only one function `testRacineCarree()` wish take an integer as argument and generate our exception if that integer is negative.
Also the `main()` exist in this class,wish allows as to test our programme with `try`and `catch` as the following code shows:
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
C'est une exception de type RacineCarreeException. Nombre négatif :-5
````
## Exercises 3
we will create a java programme wish manage the notes of students ,if the notes n>20 or n<0 the exception will be triggered.
1. `NoteInvalideException` Class
The class `NoteInvalideException` will extend `Exception` class,like the following code shows:
````java
public class RacineCarreeException extends Exception {
    public RacineCarreeException(int i) {
        super("C'est une exception de type RacineCarreeException. Nombre négatif :"+ i);
    }
}
````
2. `Evaluateur` Class
this class will have no variables , only one function `verifierNote()` wish take an integer as argument and generate our exception if that integer i is lower than 0 or greater than 20 .
Also the `main()` exist in this class,wish allows as to test our programme with `try`and `catch` as the following code shows:
````java
public class Evaluateur {
    public Evaluateur() {
    }
    public void verifierNote(int i) throws NoteInvalideException{
        if(i<0 || i>20){
            throw new NoteInvalideException(i);
        }
    }

    public static void main(String[] args) {
        Evaluateur e = new Evaluateur();
        try {
            e.verifierNote(15);
            e.verifierNote(25);

        } catch (NoteInvalideException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }
}
````
#### the result :
````text
Exception de type NoteInvalideException. Note invalide :25
EX3.NoteInvalideException: Exception de type NoteInvalideException. Note invalide :25
	at EX3.Evaluateur.verifierNote(Evaluateur.java:8)
	at EX3.Evaluateur.main(Evaluateur.java:16)
````
