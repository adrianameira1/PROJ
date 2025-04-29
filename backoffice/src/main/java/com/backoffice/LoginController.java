package com.backoffice;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    private String userType;

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @FXML
    private void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        try {
            if (userType.equals("admin") && username.equals("admin@quinta.com") && password.equals("admin123")) {
                openHome("/fxml/AdminHome.fxml", "Admin Home");
            } else if (userType.equals("gestor") && username.equals("gestor@quinta.com") && password.equals("gestor123")) {
                openHome("/fxml/GestorHome.fxml", "Gestor Home");
            } else if (userType.equals("chefe") && username.equals("chefe@quinta.com") && password.equals("chefe123")) {
                openHome("/fxml/ChefeSalaHome.fxml", "Chefe de Sala Home");
            } else {
                showAlert("Credenciais inválidas ou utilizador não autorizado para este perfil!");
            }
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Erro ao abrir a página de Home!");
        }
    }

    private void openHome(String fxmlPath, String title) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlPath));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle(title);
        stage.setScene(new Scene(root, 800, 600));
        stage.show();

        // Fecha a janela de login
        Stage currentStage = (Stage) usernameField.getScene().getWindow();
        currentStage.close();
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
