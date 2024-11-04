package EX1;

public class Vehicule {
    public Vehicule() {
    }
    public void testVitesse(int i)throws TropViteException{
        if (i>90){
            throw new TropViteException(i);
        }

    }

    public static void main(String[] args) throws TropViteException {
        Vehicule v = new Vehicule();
        try {
            v.testVitesse(23);
            v.testVitesse(123);
        }catch (TropViteException e){
            System.out.println(e.getMessage());
        }
        System.out.println("affiche");



    }
}
