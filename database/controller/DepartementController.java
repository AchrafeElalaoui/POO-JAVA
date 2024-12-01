package ma.enset.tp6.database.controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import ma.enset.tp6.database.metier.Imetier;
import ma.enset.tp6.database.metier.ImpImetier;
import ma.enset.tp6.database.models.Departement;
import ma.enset.tp6.database.models.Professeur;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
public class DepartementController implements Initializable {
    private final Imetier metier = new ImpImetier();
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    @FXML private TableView<Departement> departTableView; // Replace "?" with the type of your table items (e.g., Departement).
    @FXML private TableColumn<Departement, Integer> DepartTableColumnId; // Replace "?" with the data type (e.g., Integer, String).
    @FXML private TableColumn<Departement, String> departTableColumnNom;
    @FXML private TableColumn<Departement, Void> departTableColumnActions;

    // Variables for Search TextField
    @FXML private TextField departFieldSearch;

    // Variables for Label and TextFields
    @FXML private Label departLabelId;
    @FXML private Label departLabelNom;
    @FXML private TextField departFieldId;
    @FXML private TextField departFieldNom;

    // Variables for Buttons
    @FXML private Button departButtonClear;
    @FXML private Button departButtonAdd;
    public void initialize(URL url, ResourceBundle rb) {
        DepartTableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        departTableColumnNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        actionsColumn();
        loadDepartements();
    }
    private void loadDepartements() {
        departTableView.setItems(FXCollections.observableArrayList(metier.getDepartements()));
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
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Professeur, String> nomCol = new TableColumn<>("Nom");
        nomCol.setCellValueFactory(new PropertyValueFactory<>("nom"));

        TableColumn<Professeur, String> prenomCol = new TableColumn<>("Prénom");
        prenomCol.setCellValueFactory(new PropertyValueFactory<>("prenom"));

        TableColumn<Professeur, String> cinCol = new TableColumn<>("CIN");
        cinCol.setCellValueFactory(new PropertyValueFactory<>("cin"));

        TableColumn<Professeur, String> emailCol = new TableColumn<>("Email");
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));

        TableColumn<Professeur, String> dateCol = new TableColumn<>("Date Recrutement");
        dateCol.setCellValueFactory(cellData ->
                new SimpleStringProperty(dateFormat.format(cellData.getValue().getDate_recrutement())));

        professeursTable.getColumns().addAll(
                idCol, nomCol, prenomCol, cinCol, emailCol, dateCol
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
}
