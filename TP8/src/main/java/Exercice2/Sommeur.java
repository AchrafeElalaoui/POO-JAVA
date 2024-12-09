package Exercice2;

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
