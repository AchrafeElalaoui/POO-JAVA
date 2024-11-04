package EX3;

public class NoteInvalideException extends Exception{
    public NoteInvalideException(int i){
        super("Exception de type NoteInvalideException. Note invalide :"+i);
    }
}
