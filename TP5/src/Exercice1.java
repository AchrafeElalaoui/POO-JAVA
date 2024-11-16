import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Exercice1 {
    public static void main(String[] args) {
        List<String> mots = Arrays.asList("achraf","mohamed","layla","younss","ilhme");
        // Q1)
        List<String> motsA =mots.stream()
                .filter(s-> s.contains("a"))
                .toList();
        System.out.println(motsA);
        // Q2)
        List<String> motsI = (List<String>) mots.stream()
                .filter(s-> s.length()>3)
                .map(s -> {
                    String s1="";
                    for (int i=s.length()-1;i>=0;i--) {
                        s1 += s.charAt(i);
                    }
                    return s1;})
                .toList();
        System.out.println(motsI);
        // Q3)
        List<Character> c=mots.stream()
                .filter(s ->s.contains("e"))
                .flatMap(s -> s.chars().mapToObj(l->(char)l))
                .toList();
        System.out.println(c);
        // Q4)
        List<String> upperM=mots.stream()
                .map(String::toUpperCase)
                .toList();
        System.out.println(upperM);
        // Q5)
        List<Integer> longeur=mots.stream()
                .map(String::length)
                .toList();
        System.out.println(longeur);
        // Q6)
        List<List<Character>> lc=mots.stream()
                .map(s -> s.chars().mapToObj(l->(char)l).toList())
                .toList();
        System.out.println(lc);
        // Q7)
        List<String> tList = IntStream.range(0, mots.size())
                .mapToObj(index -> mots.get(index) + " - " + index)
                .toList();
        System.out.println(tList);
    }

}
