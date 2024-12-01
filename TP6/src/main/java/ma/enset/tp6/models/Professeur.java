package ma.enset.tp6.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data @NoArgsConstructor @AllArgsConstructor
public class Professeur {

    private int id_prof;
    private String nom;
    private String prenom;
    private String adresse;
    private String cin;
    private String email;
    private String telephone;
    private Date date_recrutement;
    private int id_deprat;


}
