package tp1.alaoui;

import java.util.Scanner;

public class EX3 {
    public static void main(String[] args) {
        EX3 ex3 =new EX3();
        Scanner in=new Scanner(System.in);
        //Scanner in32=new Scanner(System.in);
        String r;
        int nbrFon;
        do {
            System.out.println("----------------------MENU------------------------");
            System.out.println("entrer 1 pour SAISIR");
            System.out.println("entrer 2 pour AFFICHER");
            System.out.println("entrer 3 pour INVERSER");
            System.out.println("entrer 4 pour AFFICHER LE NOMBREDE MOTS");
            System.out.println("--------------------------------------------------");


            do {
                System.out.println("saisir une nombre entre 1 et 4");
                nbrFon=in.nextInt();
                in.nextLine();
            }while((nbrFon<1 || nbrFon>4));


            switch(nbrFon) {
                case 1:ex3.saisir();
                    break;
                case 2:ex3.afficher();
                    break;
                case 3:ex3.inverser();
                    break;
                case 4:ex3.nbrMots();
                    break;
            }

            System.out.println("saisir 'r' pour une autre fonction");
            r=in.nextLine();
        }while(r.equals("r"));

    }
    Scanner in=new Scanner(System.in);

    String mot="";
    public void saisir() {
        mot =in.nextLine();

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
