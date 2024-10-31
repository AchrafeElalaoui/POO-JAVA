package Exercice1;

public class Application1 {
    public static void main(String[] args) {
        Adherent adherent=new Adherent("radwan","khoya",20,"red@gmail.com","0653424352",1);
        Auteur auteur=new Auteur("oussama","dohiri",20,"dohe@gmail.com","0653464352",32);
        Livre livre=new Livre(123,auteur,"les maisirable");
        adherent.affiche();
        livre.affiche();
    }
}
