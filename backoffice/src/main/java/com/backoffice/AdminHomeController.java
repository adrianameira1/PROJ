package com.backoffice;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class AdminHomeController {
    @FXML
    private Label welcomeLabel;

    @FXML
    private void initialize() {
        welcomeLabel.setText("Bem-vindo, Admin!");
    }
}
