package Exercise3;

import java.util.HashSet;

public class TestSet {
    public static void main(String[] args) {
        HashSet<String> groupA = new HashSet<>();
        HashSet<String> groupB = new HashSet<>();
        //1)
        groupA.add("Achraf el");
        groupA.add("salim el");
        groupB.add("Achraf el");
        groupB.add("amin el");
        groupB.add("hossam el");
        //2)
        System.out.println("l’intersection des deux HashSets :");
        for (String etA : groupA) {
            for (String etB : groupB) {
                if (etA.equals(etB)) {
                    System.out.println(etA);
                }
            }
        }
        //3)
        System.out.println("l’union des deux HashSets :");
        for (String etA : groupA) {
            System.out.println(etA);
        }
        for (String etB : groupB) {
            System.out.println(etB);
        }
    }
}
