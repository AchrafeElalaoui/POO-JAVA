# TP5
In this practical work we will manage "Streams",to do that we're going to solve tree exercises.
to see the practical work click
## Exercises 1
In this exercise we suppose that we have a list of words and we will answer these questions :  
1. Filter words that contain the letter "a".
2. Filter words that have a length greater than 3 and transform each word into its reverse.
3. Filter strings that contain the letter "e" and flatten each string into a list of its characters.
4. Transform each string to its uppercase version.
5. Convert each string to its length.
6. Transform each string into a list of its characters, then flatten all lists into a single list of characters.
7. From a list of words, transform each name into a string of the form "Name - Index", where the index represents the position of the name in the list.
The solution of these questions is shown in the following code :
```java
public static void main(String[] args) {
    List<String> mots = Arrays.asList("achraf","mohamed","layla","younss","ilhme");
    // Q1)
    List<String> motsA =mots.stream()
            .filter(s-> s.contains("a"))
            .toList();
    System.out.println("question 1");
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
    System.out.println("question 2");
    System.out.println(motsI);
    // Q3)
    List<Character> c=mots.stream()
            .filter(s ->s.contains("e"))
            .flatMap(s -> s.chars().mapToObj(l->(char)l))
            .toList();
    System.out.println("question 3");
    System.out.println(c);
    // Q4)
    List<String> upperM=mots.stream()
            .map(String::toUpperCase)
            .toList();
    System.out.println("question 4");
    System.out.println(upperM);
    // Q5)
    List<Integer> longeur=mots.stream()
            .map(String::length)
            .toList();
    System.out.println("question 5");
    System.out.println(longeur);
    // Q6)
    List<List<Character>> lc=mots.stream()
            .map(s -> s.chars().mapToObj(l->(char)l).toList())
            .toList();
    System.out.println("question 6");
    System.out.println(lc);
    // Q7)
    List<String> tList = IntStream.range(0, mots.size())
            .mapToObj(index -> mots.get(index) + " - " + index)
            .toList();
    System.out.println("question 7");
    System.out.println(tList);
}
```
the result :
````text
question 1
[achraf, mohamed, layla]
question 2
[farhca, demahom, alyal, ssnuoy, emhli]
question 3
[m, o, h, a, m, e, d, i, l, h, m, e]
question 4
[ACHRAF, MOHAMED, LAYLA, YOUNSS, ILHME]
question 5
[6, 7, 5, 6, 5]
question 6
[[a, c, h, r, a, f], [m, o, h, a, m, e, d], [l, a, y, l, a], [y, o, u, n, s, s], [i, l, h, m, e]]
question 7
[achraf - 0, mohamed - 1, layla - 2, younss - 3, ilhme - 4]
````
## Exercises 2
In this exercise we will create an ArrayList of employees. Each employee has a `nom` (`String`), a `department` (`String`), and a `salair` (`double`),and we will answer these questions :
1. Use `mapToDoule` and `sum` to calculate the total sum of all employees' salaries.
2. Use `sorted` to sort the list of employees in alphabetical order by name.
3. Use `min` to find the employee with the lowest salary.
4. Use `filter` to get the list of employees with a salary higher than a given value.
5. Use `reduce` to find the employee with the highest salary in the company.
6. Use `reduce` to concatenate the names of all employees.
   The solution of these questions is shown in the following code :
```java
public class Employee {
    private String nom;
    private String departement;
    private double salaire;
    public Employee(String nom,String departement, double salaire) {
        this.departement = departement;
        this.nom = nom;
        this.salaire = salaire;
    }
    public double getSalaire() {
        return salaire;
    }
    public String getNom() {
        return nom;
    }
    @Override
    public String toString() {
        return "Employee{" +
                "nom='" + nom + '\'' +
                ", departement='" + departement + '\'' +
                ", salaire=" + salaire +
                '}';
    }
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<Employee>();
        employees.add(new Employee("Alice", "IT", 50000));
        employees.add(new Employee("Bob", "Finance", 60000));
        employees.add(new Employee("Charlie", "HR", 45000));
        employees.add(new Employee("David", "IT", 55000));
        // Q1)
        double sal = employees.stream()
                .mapToDouble(Employee::getSalaire)
                .sum();
        System.out.println("question 1");
        System.out.println("La somme totale des salaires est : " + sal);
        // Q2)
        List<Employee> sortEmployees = employees.stream()
                .sorted(Comparator.comparing(Employee::getNom))
                .toList();
        System.out.println("question 2");
        System.out.println("Trié par nom  (ordre alphabétique) : ");
        sortEmployees.forEach(System.out::println);
        // Q3)
        Optional<Employee> minSal = employees.stream()
                .min(Comparator.comparing(Employee::getSalaire));
        System.out.println("question 3");
        System.out.println("L'employé avec le salaire le plus bas est : " + minSal.get());
        // Q4)
        double limitSal = 50000;
        List<Employee> fillteredEmployees = employees.stream()
                .filter(e -> e.getSalaire() > limitSal)
                .toList();
        System.out.println("question 4");
        System.out.println("Employés avec un salaire supérieur à " + limitSal + " :");
        fillteredEmployees.forEach(System.out::println);
        // Q5)
        Optional<Employee> employeMaxSalaire = employees.stream()
                .reduce((e1, e2) -> e1.getSalaire() > e2.getSalaire() ? e1 : e2);
        System.out.println("question 5");
        System.out.println("L'employé avec le salaire le plus élevé est : " + employeMaxSalaire.get());
        // Q6)
        String nomsConcatenes = employees.stream()
                .map(Employee::getNom)
                .reduce("", (noms, nom) -> noms + nom + " ");
        System.out.println("question 6");
        System.out.println("Noms concaténés : " + nomsConcatenes.trim());


    }
}
```
the result :
````text
question 1
La somme totale des salaires est : 210000.0
question 2
Trié par nom  (ordre alphabétique) : 
Employee{nom='Alice', departement='IT', salaire=50000.0}
Employee{nom='Bob', departement='Finance', salaire=60000.0}
Employee{nom='Charlie', departement='HR', salaire=45000.0}
Employee{nom='David', departement='IT', salaire=55000.0}
question 3
L'employé avec le salaire le plus bas est : Employee{nom='Charlie', departement='HR', salaire=45000.0}
question 4
Employés avec un salaire supérieur à 50000.0 :
Employee{nom='Bob', departement='Finance', salaire=60000.0}
Employee{nom='David', departement='IT', salaire=55000.0}
question 5
L'employé avec le salaire le plus élevé est : Employee{nom='Bob', departement='Finance', salaire=60000.0}
question 6
Noms concaténés : Alice Bob Charlie David
````