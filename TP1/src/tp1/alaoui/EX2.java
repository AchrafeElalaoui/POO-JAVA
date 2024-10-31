package tp1.alaoui;

import java.util.Scanner;

public class EX2 {
    public static void main(String[] args) {

        EX2 ex2 =new EX2();

        Scanner in2=new Scanner(System.in);
        System.out.print("saisir une verbe de premier groupe");
        String v = in2.nextLine();

        String verbe=v.toLowerCase();
        ex2.conjuger( verbe);
    }
    public void conjuger(String verbe) {
        String er=verbe.substring(verbe.length()-2);
        if(er.equals("er")) {
            String str=verbe.substring(0, verbe.length()-2);
            System.out.println("je "+str+"e");
            System.out.println("tu "+str+"es");
            System.out.println("il "+str+"e");
            System.out.println("nous "+str+"ons");
            System.out.println("vous "+str+"ez");
            System.out.println("ils "+str+"ent");
        }
        else
            System.out.println("le verbe "+verbe+" n'est pas du premier groupe");

    }

}
