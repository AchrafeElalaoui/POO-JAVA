package EX3;

public class Evaluateur {
    public Evaluateur() {
    }
    public void verifierNote(int i) throws NoteInvalideException{
        if(i<0 || i>20){
            throw new NoteInvalideException(i);
        }
    }

    public static void main(String[] args) {
        Evaluateur e = new Evaluateur();
        try {
            e.verifierNote(15);
            e.verifierNote(25);

        } catch (NoteInvalideException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }
}
