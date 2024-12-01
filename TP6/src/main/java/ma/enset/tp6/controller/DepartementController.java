package ma.enset.tp6.controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import ma.enset.tp6.database.ConnectionDB;
import ma.enset.tp6.metier.Imetier;
import ma.enset.tp6.metier.ImpImetier;
import ma.enset.tp6.models.Departement;
import ma.enset.tp6.models.Professeur;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

import static java.time.zone.ZoneRulesProvider.refresh;


public class DepartementController implements Initializable {
    private final Imetier metier = new ImpImetier();
    private final Connection connection= ConnectionDB.getConnection();
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    @FXML
    private Button searchBtn;
    @FXML
    private TableView<Departement> departTableView; // Replace "?" with the type of your table items (e.g., Departement).
    @FXML
    private TableColumn<Departement, Integer> DepartTableColumnId; // Replace "?" with the data type (e.g., Integer, String).
    @FXML
    private TableColumn<Departement, String> departTableColumnNom;
    @FXML
    private TableColumn<Departement, Void> departTableColumnActions;

    // Variables for Search TextField
    @FXML
    private TextField departFieldSearch;

    // Variables for Label and TextFields
    @FXML
    private Label departLabelId;
    @FXML
    private Label departLabelNom;
    @FXML
    private TextField departFieldId;
    @FXML
    private TextField departFieldNom;

    // Variables for Buttons
    @FXML
    private Button departButtonClear;
    @FXML
    private Button departButtonAdd;

    public void initialize(URL url, ResourceBundle rb) {
        DepartTableColumnId.setCellValueFactory(new PropertyValueFactory<>("id_deprat"));
        departTableColumnNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        actionsColumn();
        loadDepartements();
    }

    private void loadDepartements() {
        departTableView.setItems(FXCollections.observableArrayList(metier.getDepartements()));
        departTableView.refresh();
    }

    private void actionsColumn() {
        departTableColumnActions.setCellFactory(param -> new TableCell<>() {
            private final Button editB = new Button("Modifier");
            private final Button deleteB = new Button("Supprimer");
            private final Button viewProfsB = new Button("Voir Professeurs");

            {
                editB.setOnAction(event -> hEdit(getTableView().getItems().get(getIndex())));
                deleteB.setOnAction(event -> hDelete(getTableView().getItems().get(getIndex())));
                viewProfsB.setOnAction(event -> hViewProfesseurs(getTableView().getItems().get(getIndex())));
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    HBox buttons = new HBox(5, editB, deleteB, viewProfsB);
                    setGraphic(buttons);
                }
            }
        });
    }

    @FXML
    private void hAjouter() {
        String departmentName = departFieldNom.getText().trim();
        if (departmentName.isEmpty()) {
            showAlert("Error", "Department name cannot be empty!");
            return;
        }
        if(depatExiste(departmentName)) {
            showAlert("Error", "Department already exists!");
        }else {
            Departement newDepartment = new Departement();
            newDepartment.setNom(departmentName);
            metier.ajouterDepartement(newDepartment);
            loadDepartements();
            hClear();
        }


    }
    private void hEdit(Departement departement) {
        TextInputDialog dialog = new TextInputDialog(departement.getNom());
        dialog.setTitle("Modifier Département");
        dialog.setHeaderText("Modifier le département");
        dialog.setContentText("Nouveau nom:");

        dialog.showAndWait().ifPresent(nom -> {
            departement.setNom(nom);
            metier.modifierDepartement(departement);
            loadDepartements();
        });

    }
    private void hDelete(Departement departement) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Supprimer le département");
        alert.setContentText("Êtes-vous sûr de vouloir supprimer ce département ?");

        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                metier.supprimerDepartement(departement.getId_deprat());
                loadDepartements();
            }
        });
    }
    private void hViewProfesseurs(Departement departement) {
        Dialog<Void> dialog = new Dialog<>();
        dialog.setTitle("Professeurs du Département");
        dialog.setHeaderText("Liste des professeurs du département: " + departement.getNom());

        TableView<Professeur> professeursTable = new TableView<>();

        TableColumn<Professeur, Integer> idCol = new TableColumn<>("ID");
        idCol.setCellValueFactory(new PropertyValueFactory<>("id_prof"));

        TableColumn<Professeur, String> nomCol = new TableColumn<>("Nom");
        nomCol.setCellValueFactory(new PropertyValueFactory<>("nom"));

        TableColumn<Professeur, String> prenomCol = new TableColumn<>("Prénom");
        prenomCol.setCellValueFactory(new PropertyValueFactory<>("prenom"));

        TableColumn<Professeur, String> cinCol = new TableColumn<>("CIN");
        cinCol.setCellValueFactory(new PropertyValueFactory<>("cin"));
        TableColumn<Professeur, String> adresseCol = new TableColumn<>("Adresse");
        adresseCol.setCellValueFactory(new PropertyValueFactory<>("adresse"));

        TableColumn<Professeur, String> emailCol = new TableColumn<>("Email");
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));

        TableColumn<Professeur, String> telephoneCol = new TableColumn<>("Telephone");
        telephoneCol.setCellValueFactory(new PropertyValueFactory<>("telephone"));

        TableColumn<Professeur, String> dateCol = new TableColumn<>("Date Recrutement");
        dateCol.setCellValueFactory(cellData ->
                new SimpleStringProperty(dateFormat.format(cellData.getValue().getDate_recrutement())));

        professeursTable.getColumns().addAll(
                idCol, nomCol, prenomCol, cinCol,adresseCol, emailCol,telephoneCol, dateCol
        );

        professeursTable.setItems(
                FXCollections.observableArrayList(
                        metier.getProfesseursDepartement(departement.getId_deprat())
                )
        );

        professeursTable.setMinWidth(600);
        professeursTable.setMinHeight(400);

        VBox content = new VBox(10);
        content.getChildren().add(professeursTable);
        dialog.getDialogPane().setContent(content);

        ButtonType closeButton = new ButtonType("Fermer", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().add(closeButton);
        dialog.showAndWait();
    }
    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
    public boolean depatExiste(String n) {
        int count = 0;
        try {
            PreparedStatement s = connection.prepareStatement(
                    "select count(id_deprat) from departement where nom=?"
            );
            s.setString(1, n);
            ResultSet rs = s.executeQuery();

            if (rs.next()) { // Moves the cursor to the first row of the result set
                count = rs.getInt(1); // Retrieve the count value from the result
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        if (count == 0) {
            return false;
        } else {
            return true;
        }
    }
    @FXML
    public void hSearch() {
        String mot = departFieldSearch.getText();
        if (mot != null && !mot.isEmpty()) {
            departTableView.setItems(FXCollections.observableArrayList(metier.chercherDepartParMotCle(mot)));
        } else {
            loadDepartements();
        }
        departTableView.refresh();
        departFieldSearch.clear();
    }
    @FXML
    public void hClear() {
        departFieldNom.clear();
        refresh();
    }
}
