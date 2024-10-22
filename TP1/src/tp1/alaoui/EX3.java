package tp1.alaoui;

import java.util.Scanner;

public class EX3 {
    Scanner in=new Scanner(System.in);

    String mot;
    public void saisir() {
        String str =in.nextLine();
        mot=str;
    }
    public void afficher() {
        System.out.println("le mot est :"+mot);
    }
    public void inverser() {
        String reverse = "";

        for (int i = mot.length() - 1; i >= 0; i--) {
            reverse += mot.charAt(i);
        }
        System.out.println("le mot est :"+reverse);
    }
    public void nbrMots() {
        String[] str =mot.split(" ");
        int i=0;
        for (String string : str) {
            i++;
        }
        System.out.println("le nombre de mots est :"+i);
    }
}
