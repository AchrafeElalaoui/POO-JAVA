package tp1.alaoui;


import java.util.Scanner;

public class EX1 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        EX1 ex1=new EX1();

        System.out.print("saisir le nombre d'etudient : ");
        int n= in.nextInt();

        float[] nots= new float[n];
        for (int i = 0; i < nots.length; i++) {
            System.out.print("saisir la note de l'etudient "+(i+1)+": ");
            nots[i]=in.nextFloat();
        }
        float[] notsTriee= ex1.trierNots(nots);
        System.out.println("les note triee :");
        for (int i = 0; i < notsTriee.length; i++) {
            System.out.println(notsTriee[i]);
        }



        System.out.println("moyenne du notes :" + ex1.moyNotes(nots));




        System.out.println("le max des notes est "+ex1.maxNotes(notsTriee));
        System.out.println("le min des notes est "+ex1.minNotes(notsTriee));



        System.out.print("saisir une note");
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
