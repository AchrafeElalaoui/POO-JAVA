package ma.enset.tp6.controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import ma.enset.tp6.metier.Imetier;
import ma.enset.tp6.metier.ImpImetier;
import ma.enset.tp6.models.Departement;
import ma.enset.tp6.models.Professeur;

import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;

import static java.time.zone.ZoneRulesProvider.refresh;

public class ProfesseurController implements Initializable {
    private final Imetier metier = new ImpImetier();
    // TableView and TableColumn variables
    @FXML private TableView<Professeur> profTableView; // Replace "?" with your table data type (e.g., Professeur).
    @FXML private TableColumn<Professeur, Integer> profTableColumnId;
    @FXML private TableColumn<Professeur, String> profTableColumnNom;
    @FXML private TableColumn<Professeur, String> profTableColumnPrenom;
    @FXML private TableColumn<Professeur, String> profTableColumnAdresse;
    @FXML private TableColumn<Professeur, String> profTableColumnCin;
    @FXML private TableColumn<Professeur, String> profTableColumnTelephon;
    @FXML private TableColumn<Professeur, String> profTableColumnEmail;
    @FXML private TableColumn<Professeur, Date> profTableColumnDate;
    @FXML private TableColumn<Professeur, String> profTableColumnDepart;
    @FXML private TableColumn<Professeur, Void> profTableColumnActions;

    // Search TextField
    @FXML private TextField profFieldSearch;

    // Labels
    @FXML private Label profLabelId;
    @FXML private Label profLabelNom;
    @FXML private Label profLabelPrenom;
    @FXML private Label profLabelAdresse;
    @FXML private Label profLabelCin;
    @FXML private Label profLabelTelephon;
    @FXML private Label profLabelIdEmail;
    @FXML private Label profLabelDate;
    @FXML private Label profLabelDepart;

    // TextFields
    @FXML private TextField profFieldId;
    @FXML private TextField profFieldNom;
    @FXML private TextField profFieldPrenom;
    @FXML private TextField profFieldAdresse;
    @FXML private TextField profFieldCin;
    @FXML private TextField profFieldTelephon;
    @FXML private TextField profFieldEmail;
    @FXML private TextField profFieldDepart;

    @FXML private ComboBox<String> departmentComboBox;
    // DatePicker
    @FXML private DatePicker profFieldDate;
    // Buttons
    @FXML private Button profButtonClear;
    @FXML private Button profButtonAdd;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        profTableColumnId.setCellValueFactory(new PropertyValueFactory<>("id_prof"));
        profTableColumnNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        profTableColumnPrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        profTableColumnAdresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        profTableColumnCin.setCellValueFactory(new PropertyValueFactory<>("cin"));
        profTableColumnTelephon.setCellValueFactory(new PropertyValueFactory<>("telephone"));
        profTableColumnEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        profTableColumnDate.setCellValueFactory(new PropertyValueFactory<>("date_recrutement"));
        profTableColumnDepart.setCellValueFactory(cellData -> {
            var departementOptional = metier.getDepartements().stream()
                    .filter(departement -> departement.getId_deprat() == cellData.getValue().getId_deprat())
                    .findFirst();
            return new SimpleStringProperty(departementOptional.map(Departement::getNom).orElse("Non trouvé"));
        });
        actionsColumn();
        loadProfesseurs();
    }
    private void loadProfesseurs() {
        profTableView.setItems(FXCollections.observableArrayList(metier.getProfesseurs()));
        profTableView.refresh();
    }
    private void actionsColumn() {
        profTableColumnActions.setCellFactory(param -> new TableCell<>() {
            private final Button editB = new Button("Modifier");
            private final Button deleteB = new Button("Supprimer");
            private final Button assignB = new Button("Assigner");

            {
                editB.setOnAction(event -> {
                    Professeur professeur = getTableView().getItems().get(getIndex());
                    if (professeur != null) {
                        hEdit(professeur);
                    }
                });
                deleteB.setOnAction(event -> {
                    Professeur professeur = getTableView().getItems().get(getIndex());
                    if (professeur != null) {
                        hDelete(professeur);
                    }
                });
                assignB.setOnAction(event -> {
                    Professeur professeur = getTableView().getItems().get(getIndex());
                    if (professeur != null) {
                        hAssign(professeur);
                    }
                });
            }
            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || getTableView().getItems().get(getIndex()) == null) {
                    setGraphic(null);
                } else {
                    HBox buttons = new HBox(5, editB, deleteB, assignB);
                    setGraphic(buttons);
                }
            }
        });
    }
    @FXML
    private void hAjouter(){
        String nom = profFieldNom.getText().trim();
        String prenom = profFieldPrenom.getText().trim();
        String cin = profFieldCin.getText().trim();
        String adresse = profFieldAdresse.getText().trim();
        String telephone = profFieldTelephon.getText().trim();
        String email = profFieldEmail.getText().trim();
        LocalDate date = profFieldDate.getValue();
        departmentComboBox.setItems(FXCollections.observableArrayList(
                metier.getDepartements().stream()
                        .map(Departement::getNom)
                        .toList()
        ));
        loadProfesseurs();
        String depart=departmentComboBox.getValue();
        Professeur professeur = new Professeur();
        professeur.setNom(nom);
        professeur.setPrenom(prenom);
        professeur.setCin(cin);
        professeur.setAdresse(adresse);
        professeur.setTelephone(telephone);
        professeur.setEmail(email);
        professeur.setDate_recrutement(java.sql.Date.valueOf(date));
        if (depart != null) {
            Departement selectedDepartement = metier.getDepartements().stream()
                    .filter(departement -> departement.getNom().equals(depart))
                    .findFirst()
                    .orElse(null);

            if (selectedDepartement != null) {
                professeur.setId_deprat(selectedDepartement.getId_deprat());
            }
        }
        metier.ajouterProfesseur(professeur);
        loadProfesseurs();
        hClear();

    }

    private void hEdit(Professeur professeur) {
        Dialog<Professeur> dialog = new Dialog<>();
        dialog.setTitle("Modifier un professeur");
        dialog.setHeaderText("Modifier les informations du professeur");

        ButtonType saveButtonType = new ButtonType("Sauvegarder", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(saveButtonType, ButtonType.CANCEL);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        TextField nom = new TextField(professeur.getNom());
        TextField prenom = new TextField(professeur.getPrenom());
        TextField cin = new TextField(professeur.getCin());
        TextField adresse = new TextField(professeur.getAdresse());
        TextField telephone = new TextField(professeur.getTelephone());
        TextField email = new TextField(professeur.getEmail());


        grid.add(new Label("Nom:"), 0, 0);
        grid.add(nom, 1, 0);
        grid.add(new Label("Prénom:"), 0, 1);
        grid.add(prenom, 1, 1);
        grid.add(new Label("CIN:"), 0, 2);
        grid.add(cin, 1, 2);
        grid.add(new Label("Adresse:"), 0, 3);
        grid.add(adresse, 1, 3);
        grid.add(new Label("Téléphone:"), 0, 4);
        grid.add(telephone, 1, 4);
        grid.add(new Label("Email:"), 0, 5);
        grid.add(email, 1, 5);

        dialog.getDialogPane().setContent(grid);
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == saveButtonType) {
                professeur.setNom(nom.getText());
                professeur.setPrenom(prenom.getText());
                professeur.setCin(cin.getText());
                professeur.setAdresse(adresse.getText());
                professeur.setTelephone(telephone.getText());
                professeur.setEmail(email.getText());

                return professeur;
            }
            return null;
        });

        dialog.showAndWait().ifPresent(updatedProfesseur -> {
            metier.modifierProfesseur(updatedProfesseur);
            loadProfesseurs();
        });
    }
    private void hDelete(Professeur professeur) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Supprimer le professeur");
        alert.setContentText("Êtes-vous sûr de vouloir supprimer ce professeur ?");

        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                metier.supprimerProfesseur(professeur.getId_prof());
                loadProfesseurs();
            }
        });
    }
    private void hAssign(Professeur professeur) {
        Dialog<Integer> dialog = new Dialog<>();
        dialog.setTitle("Assigner un département");
        dialog.setHeaderText("Assigner un département à " + professeur.getNom() + " " + professeur.getPrenom());

        ButtonType assignButtonType = new ButtonType("Assigner", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(assignButtonType, ButtonType.CANCEL);

        ComboBox<String> departmentComboBox = new ComboBox<>();
        departmentComboBox.setItems(FXCollections.observableArrayList(
                metier.getDepartements().stream()
                        .map(Departement::getNom)
                        .toList()
        ));
        departmentComboBox.setPromptText("Sélectionnez un département");

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));
        grid.add(new Label("Département:"), 0, 0);
        grid.add(departmentComboBox, 1, 0);
        dialog.getDialogPane().setContent(grid);

        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == assignButtonType) {
                int selectedIndex = departmentComboBox.getSelectionModel().getSelectedIndex();
                if (selectedIndex >= 0) {
                    return metier.getDepartements().get(selectedIndex).getId_deprat();
                }
            }
            return null;
        });

        dialog.showAndWait().ifPresent(departmentId -> {
            professeur.setId_deprat(departmentId);
            metier.modifierProfesseur(professeur);

            profTableView.getItems().forEach(p -> {
                if (p.getId_prof() == professeur.getId_prof()) {
                    p.setId_deprat(departmentId);
                }
            });

            profTableView.refresh();

            Alert success = new Alert(Alert.AlertType.INFORMATION);
            success.setTitle("Succès");
            success.setHeaderText(null);
            success.setContentText("Le professeur a été assigné au département avec succès !");
            success.show();
        });
    }
    @FXML
    private void hSearch() {
        String mot = profFieldSearch.getText();
        if (mot != null && !mot.isEmpty()) {
            profTableView.setItems(FXCollections.observableArrayList(metier.chercherParMotCle(mot)));
        } else {
            loadProfesseurs();
        }
        profTableView.refresh();
        profFieldSearch.clear();
    }
    @FXML
    public void hClear() {
        profFieldEmail.clear();
        profFieldTelephon.clear();
        profFieldCin.clear();
        profFieldNom.clear();
        profFieldPrenom.clear();
        profFieldAdresse.clear();
        departmentComboBox.setPromptText("Sélectionnez un département");
        refresh();

    }



}
