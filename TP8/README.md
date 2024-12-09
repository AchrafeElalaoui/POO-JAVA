## EXERCISE 1
This exercise focuses on creating a simple application to highlight a common behavior in multi-threaded programming. The steps are as follows:

1. Create a class named Talkative with a constructor that accepts an integer parameter, which will be stored as an attribute of the class.
2. Modify the Talkative class to implement the Runnable interface.
3. Override the run method in the Talkative class to print the value of the attribute 100 times.
4. In a static main method, create 10 instances of the Thread class. Each instance should take as a parameter a new Talkative object, constructed with a unique integer as its parameter.
5. Call the start method on each Thread instance to begin execution.

This all in the following code :
```java
public class Talkative implements Runnable {
    private static int number;
    public Talkative(int number) {
        Talkative.number = number;
    }
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(number);
        }
    }
    public static void main(String[] args) {
        Thread t1 = new Thread(new Talkative(1));
        Thread t2 = new Thread(new Talkative(2));
        Thread t3 = new Thread(new Talkative(3));
        Thread t4 = new Thread(new Talkative(4));
        Thread t5 = new Thread(new Talkative(5));
        Thread t6 = new Thread(new Talkative(6));
        Thread t7 = new Thread(new Talkative(7));
        Thread t8 = new Thread(new Talkative(8));
        Thread t9 = new Thread(new Talkative(9));
        Thread t10 = new Thread(new Talkative(10));
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        t9.start();
        t10.start();
    }
}
```
##### The result
```text
10
10
10
10
10
10
10
10
10
10
10
... (100 time)
```
This application demonstrates how multiple threads execute concurrently, potentially interleaving outputs from different threads, which is characteristic of multi-threaded environments.

# EXERCISE 2
This exercise demonstrates how to use a thread pool in Java to calculate the sum of an array's elements in parallel. The steps are as follows:

1. Create a class named Sommeur that implements the Runnable interface.
2. Add a constructor to the Sommeur class that accepts an array of integers and two indices (start and end) to define the range of indices over which the sum will be calculated.
3. Implement a method getSum() in the Sommeur class to return the sum calculated for the specified range.
4. In the main class (Main), initialize an array of integers.
5. Divide the array into several subranges and use a thread pool to compute the sum for each subrange concurrently.
6. display the total sum of the array.

This all in the following code :

```java
public class Sommeur implements Runnable{
    private int[] tab;
    private int debut;
    private int fin;
    private int sum;

    public Sommeur(int[] tab,int debut,int fin){
        this.tab=tab;
        this.debut = debut;
        this.fin = fin;
    }
    public int getSomme(){
        return sum;
    }

    @Override
    public void run() {
        for(int i=debut;i<=fin;i++){
            sum+=tab[i];
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        int[] tab=new int[30];
        int d=0;
        for (int i = 0; i < tab.length; i++) {
            tab[i]=i;
        }
        Sommeur s1 =new Sommeur(tab,0,10);
        Sommeur s2 =new Sommeur(tab,11,20);
        Sommeur s3 =new Sommeur(tab,21,29);
        Thread t1=new Thread(s1);
        Thread t2=new Thread(s2);
        Thread t3=new Thread(s3);
        t1.start();
        t2.start();
        t3.start();
        try{
            t1.join();
            t2.join();
            t3.join();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        int s=s1.getSomme()+s2.getSomme()+s3.getSomme();
        System.out.println("la somme totale :"+s);
    }
}
```
##### The result
```text
55
155
225
la somme totale :435
```
This program showcases the use of multi-threading to perform parallel computation, highlighting the efficiency and performance benefits of using a thread pool in Java.
