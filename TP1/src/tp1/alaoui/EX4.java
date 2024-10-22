package tp1.alaoui;

import java.util.Scanner;

public class EX4 {
    public static void main(String[] args) {
        EX4 ex4= new EX4();
        Scanner in4=new Scanner(System.in);
        System.out.println("saisir une chain de caractire");
        String ch =in4.nextLine();
        ex4.calNbrOcc(ch);
    }

    public void calNbrOcc(String str) {
        int[] nb_occurrences= new int[26];
        String lowerStr=str.toLowerCase();
        char[] charTab= {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < charTab.length; j++) {
                if(lowerStr.charAt(i)==charTab[j]) {
                    nb_occurrences[j]++;
                }
            }
        }
        for (int i = 0; i < nb_occurrences.length; i++) {
            if(nb_occurrences[i]>0) {
                System.out.println(nb_occurrences[i]+" fois la lettre '"+charTab[i]+"'");
            }
        }


    }
}
