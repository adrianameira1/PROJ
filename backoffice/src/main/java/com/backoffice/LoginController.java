package com.backoffice;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        // Simulação de login (podes melhorar mais tarde)
        if (username.equals("admin@quinta.com") && password.equals("admin123")) {
            showAlert("Login como Admin efetuado!");
            // Aqui podes abrir o Home Admin
        } else if (username.equals("gestor@quinta.com") && password.equals("gestor123")) {
            showAlert("Login como Gestor efetuado!");
            // Aqui podes abrir o Home Gestor
        } else if (username.equals("chefe@quinta.com") && password.equals("chefe123")) {
            showAlert("Login como Chefe de Sala efetuado!");
            // Aqui podes abrir o Home Chefe de Sala
        } else {
            showAlert("Credenciais inválidas! Tenta novamente.");
        }
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
