package Exercice2;

public class Application2 {
    public static void main(String[] args) {
        Manager manager=new Manager(7000,"0654738712","mohamed@gmail.com","mohamed","elwazani","tectac");
        Ingenieur ingenieur =new Ingenieur(8000,"0765646312","hassan@gmail.com","hassan","sodani","informatique");
        manager.calculerSalire();
        ingenieur.calculerSalire();
        System.out.println(manager.toString());
        System.out.println(ingenieur.toString());
    }
}
