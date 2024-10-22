package tp1.alaoui;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner in1=new Scanner(System.in);

        EX1 ex1=new EX1();
        float[] nots= {14,13,9,(float)18.25,17,14};
        float[] notsTriee= ex1.trierNots(nots);

        System.out.println("les note triee");
        for (int i = 0; i < notsTriee.length; i++) {
            System.out.println(notsTriee[i]);
        }

        System.out.println("moyenne des notes");
        float moyenne=ex1.moyNots(nots);
        System.out.println(moyenne);

        System.out.println("le max des notes est "+ex1.maxNots(notsTriee));
        System.out.println("le min des notes est "+ex1.minNots(notsTriee));



        System.out.println("saisir une note");
        float not = in1.nextFloat();
        System.out.println("le nombre d'etudients ayant la note "+not+" est "+ex1.nbrEtudient(nots, not));

        EX2 ex2 =new EX2();

        Scanner in2=new Scanner(System.in);

        System.out.println("saisir une verbe de premier groupe");
        String verbe = in2.nextLine();
        ex2.conjuger( verbe);

        EX3 ex3 =new EX3();
        Scanner in31=new Scanner(System.in);
        Scanner in32=new Scanner(System.in);
        String r;
        int nbrFon;
        do {
            System.out.println("----------------------MENU------------------------");
            System.out.println("entrer 1 pour SAISIR");
            System.out.println("entrer 2 pour AFFICHER");
            System.out.println("entrer 3 pour INVERSER");
            System.out.println("entrer 4 pour AFFICHER LE NOMBREDE MOTS");
            System.out.println("saisir le nombre du fonction");


            do {
                System.out.println("saisir une nombre entre 1 et 4");
                nbrFon=in31.nextInt();
            }while(nbrFon<1 || nbrFon>4);


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
            r=in32.nextLine();
        }while(r.equals("r"));

        EX4 ex4= new EX4();
        Scanner in4=new Scanner(System.in);
        System.out.println("saisir une chain de caractire");
        String ch =in4.nextLine();
        ex4.calNbrOcc(ch);
    }
}
