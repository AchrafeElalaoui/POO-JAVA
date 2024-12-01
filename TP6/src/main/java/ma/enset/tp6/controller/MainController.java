package ma.enset.tp6.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TabPane;

public class MainController {
    @FXML
    private TabPane mTabPane;

    @FXML
    private void showProfesseurs() {
        mTabPane.getSelectionModel().select(0);
    }

    @FXML
    private void showDepartements() {
        mTabPane.getSelectionModel().select(1);
    }
}
