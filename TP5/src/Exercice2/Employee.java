package Exercice2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

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
        System.out.println("La somme totale des salaires est : " + sal);
        // Q2)
        List<Employee> sortEmployees = employees.stream()
                .sorted(Comparator.comparing(Employee::getNom))
                .toList();
        System.out.println("Trié par nom  (ordre alphabétique) : ");
        sortEmployees.forEach(System.out::println);
        // Q3)
        Optional<Employee> minSal = employees.stream()
                .min(Comparator.comparing(Employee::getSalaire));
        System.out.println("L'employé avec le salaire le plus bas est : " + minSal.get());
        // Q4)
        double limitSal = 50000;
        List<Employee> fillteredEmployees = employees.stream()
                .filter(e -> e.getSalaire() > limitSal)
                .toList();
        System.out.println("Employés avec un salaire supérieur à " + limitSal + " :");
        fillteredEmployees.forEach(System.out::println);
        // Q5)
        Optional<Employee> employeMaxSalaire = employees.stream()
                .reduce((e1, e2) -> e1.getSalaire() > e2.getSalaire() ? e1 : e2);
        System.out.println("L'employé avec le salaire le plus élevé est : " + employeMaxSalaire.get());
        // Q6)
        String nomsConcatenes = employees.stream()
                        .map(Employee::getNom)
                        .reduce("", (noms, nom) -> noms + nom + " ");
        System.out.println("Noms concaténés : " + nomsConcatenes.trim());


    }
}
