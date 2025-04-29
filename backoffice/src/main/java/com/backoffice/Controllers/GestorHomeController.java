package com.backoffice.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class GestorHomeController {
    @FXML
    private Label welcomeLabel;

    @FXML
    private void initialize() {
        welcomeLabel.setText("Bem-vindo, Gestor!");
    }
}
