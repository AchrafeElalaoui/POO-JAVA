package ma.enset.tp6.database.metier;

import ma.enset.tp6.database.ConnectionDB;
import ma.enset.tp6.database.models.Departement;
import ma.enset.tp6.database.models.Professeur;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ImpImetier implements Imetier {
    private final Connection connection= ConnectionDB.getConnection();

    @Override
    public List<Professeur> getProfesseurs() {
        List<Professeur> professeurs = new ArrayList<>();
        try {
            PreparedStatement s= connection.prepareStatement("select * from professeur");
            ResultSet rs = s.executeQuery();
            while (rs.next()) {
                Professeur p=new Professeur();
                p.setId_prof(rs.getInt("id_prof"));
                p.setNom(rs.getString("nom"));
                p.setPrenom(rs.getString("prenom"));
                p.setEmail(rs.getString("email"));
                p.setTelephone(rs.getString("telephone"));
                p.setCin(rs.getString("cin"));
                p.setAdresse(rs.getString("adresse"));
                p.setDate_recrutement(rs.getDate("date_recrutement"));
                p.setId_deprat(rs.getInt("id_deprat"));
                professeurs.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return professeurs;
    }

    @Override
    public List<Professeur> chercherParMotCle(String motCle) {
        List<Professeur> professeurs = new ArrayList<>();
        try {
            PreparedStatement s=connection.prepareStatement(
                    "select * from prefesseur where nom = ? or prenom=? or cin=? or email=? or telephon=? or adresse=?"
            );
           String mot="'"+motCle+"'" ;
           s.setString(1, mot);
           s.setString(2, mot);
           s.setString(3, mot);
           s.setString(4, mot);
           s.setString(5, mot);
           s.setString(6, mot);
           ResultSet rs = s.executeQuery();
           while (rs.next()) {
               Professeur p=new Professeur();
               p.setId_prof(rs.getInt("id_prof"));
               p.setNom(rs.getString("nom"));
               p.setPrenom(rs.getString("prenom"));
               p.setEmail(rs.getString("email"));
               p.setTelephone(rs.getString("telephone"));
               p.setCin(rs.getString("cin"));
               p.setAdresse(rs.getString("adresse"));
               p.setDate_recrutement(rs.getDate("date_recrutement"));
               p.setId_deprat(rs.getInt("id_deprat"));
               professeurs.add(p);
           }
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return professeurs;
    }

    @Override
    public void ajouterProfesseur(Professeur professeur) {
        try{
            PreparedStatement s= connection.prepareStatement(
                    "insert into professeur (nom,prenom,cin,adresse,telephone,email,date_recrutement,id_deprat)"
                    +"values(?,?,?,?,?,?,?,?)"
            );
            s.setString(1, professeur.getNom());
            s.setString(2, professeur.getPrenom());
            s.setString(3, professeur.getCin());
            s.setString(4, professeur.getAdresse());
            s.setString(5, professeur.getTelephone());
            s.setString(6, professeur.getEmail());
            s.setDate(7, (Date) professeur.getDate_recrutement());
            s.setInt(8,professeur.getId_deprat());
            s.executeUpdate();
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void supprimerProfesseur(int id) {
        try {
            PreparedStatement s= connection.prepareStatement(
                    "delete from professeur where id_prof=?"
            );
            s.setInt(1,id);
            s.executeUpdate();
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void modifierProfesseur(Professeur professeur) {
        try{
            PreparedStatement s= connection.prepareStatement(
                    "update professeur set nom = ? ,prenom=? , cin=? , email=? , telephon=? , adresse=? ,date_recrutement=? ,id_deprat=? where id_prof=?"
            );
            s.setString(1, professeur.getNom());
            s.setString(2, professeur.getPrenom());
            s.setString(3, professeur.getCin());
            s.setString(4, professeur.getAdresse());
            s.setString(5, professeur.getTelephone());
            s.setString(6, professeur.getEmail());
            s.setDate(7, (Date) professeur.getDate_recrutement());
            s.setInt(8,professeur.getId_deprat());
            s.setInt(9,professeur.getId_prof());
            s.executeUpdate();
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Departement> getDepartements() {
        List<Departement> departements = new ArrayList<>();
        try {
            PreparedStatement s= connection.prepareStatement(
                    "select * from departement"
            );
            ResultSet rs = s.executeQuery();
            while (rs.next()) {
                Departement d=new Departement();
                d.setNom(rs.getString("nom"));
                d.setId_deprat(rs.getInt("id_deprat"));
                departements.add(d);
            }
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return departements;
    }

    @Override
    public void ajouterDepartement(Departement departement) {
        try {
            PreparedStatement s= connection.prepareStatement(
                    "insert into departement (nom) values (?);"
            );
            s.setString(1, departement.getNom());
            s.executeUpdate();
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void supprimerDepartement(int id) {
        try{
            PreparedStatement s= connection.prepareStatement(
                    "delete from departement where id_deprat=?"
            );
            s.setInt(1,id);
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void modifierDepartement(Departement departement) {
        try {
            PreparedStatement s= connection.prepareStatement(
                    "update deparement set nom=? where id_deprat=?"
            );
            s.setString(1, departement.getNom());
            s.setInt(2, departement.getId_deprat());
            s.executeUpdate();
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Professeur> getProfesseursDepartement(int id) {
        List<Professeur> professeurs = new ArrayList<>();
        try {
            PreparedStatement s= connection.prepareStatement(
                    "select from professeur p join departement d on p.id_deprat=d.id_deprat where p.id_deprat=?"
            );
            s.setInt(1,id);
            ResultSet rs = s.executeQuery();
            while (rs.next()) {
                Professeur p=new Professeur();
                p.setId_prof(rs.getInt("id_prof"));
                p.setNom(rs.getString("nom"));
                p.setPrenom(rs.getString("prenom"));
                p.setEmail(rs.getString("email"));
                p.setTelephone(rs.getString("telephone"));
                p.setCin(rs.getString("cin"));
                p.setAdresse(rs.getString("adresse"));
                p.setDate_recrutement(rs.getDate("date_recrutement"));
                p.setId_deprat(rs.getInt("id_deprat"));
                professeurs.add(p);

            }
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return professeurs;
    }
}
