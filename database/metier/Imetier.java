package ma.enset.tp6.database.metier;

import ma.enset.tp6.database.models.*;

import java.util.List;

public interface Imetier {
    List<Professeur> getProfesseurs();
    List<Professeur> chercherParMotCle(String motCle);
    void ajouterProfesseur(Professeur professeur);
    void supprimerProfesseur(int id);
    void modifierProfesseur(Professeur professeur);

    void ajouterDepartement(Departement departement);
    List<Departement> getDepartements();
    void supprimerDepartement(int id);
    void modifierDepartement(Departement departement);
    List<Professeur> getProfesseursDepartement(int id);
}
