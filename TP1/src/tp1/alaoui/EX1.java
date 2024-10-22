package tp1.alaoui;

import java.util.Scanner;

public class EX1 {
    public static void main(String[] args) {
        Scanner in1=new Scanner(System.in);

        EX1 ex1=new EX1();
        float[] nots= {14,13,9,(float)18.25,17,14};
        float[] notsTriee= ex1.trierNots(nots);

        System.out.println("les note triee");
        for (int i = 0; i < notsTriee.length; i++) {
            System.out.println(notsTriee[i]);
        }

        System.out.printf("\n\n");

        System.out.println("moyenne des notes");
        float moyenne=ex1.moyNots(nots);
        System.out.println(moyenne);

        System.out.printf("\n\n");

        System.out.println("le max des notes est "+ex1.maxNots(notsTriee));
        System.out.printf("\n\n");
        System.out.println("le min des notes est "+ex1.minNots(notsTriee));

        System.out.printf("\n\n");

        System.out.println("saisir une note");
        float not = in1.nextFloat();
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
    public float moyNots(float[] tab) {
        float somme=0,moyenne;
        for (int i = 0; i < tab.length; i++) {
            somme+=tab[i];
        }
        moyenne=somme/tab.length;
        return moyenne;
    }
    public float maxNots(float[] tab) {
        float max=tab[0];
        for (int i = 0; i < tab.length; i++) {
            if(max<tab[i]) {
                max=tab[i];
            }
        }
        return max;
    }
    public float minNots(float[] tab) {
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
