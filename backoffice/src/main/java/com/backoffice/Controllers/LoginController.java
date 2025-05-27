package com.backoffice.Controllers;

import java.util.List;
import com.backoffice.model.Utilizador;
import com.backoffice.Service.ApiService;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;

@Component
public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private void handleLogin() {
        String inputUsername = usernameField.getText().trim();

        try {
            List<Utilizador> utilizadores = ApiService.getUtilizadores();

            for (Utilizador u : utilizadores) {
                if (u.getUsername().equalsIgnoreCase(inputUsername)) {

                    if (u.getUsername().equalsIgnoreCase("adriana@quinta.com")) {
                        showAlert("Login como Responsável da Quinta efetuado!");
                        openFXML("ResponsavelQuintaHome.fxml");
                    } else if (u.getUsername().equalsIgnoreCase("carolina@quinta.com")) {
                        showAlert("Login como Gestor efetuado!");
                        openFXML("GestorHome.fxml");
                    } else if (u.getUsername().equalsIgnoreCase("machado@quinta.com")) {
                        showAlert("Login como Chefe de Sala efetuado!");
                        openFXML("ChefeSalaHome.fxml");
                    } else {
                        showAlert("Utilizador válido, mas função desconhecida.");
                    }

                    return;
                }
            }

            showAlert("Utilizador não existe.");

        } catch (Exception e) {
            e.printStackTrace();
            showAlert("Erro ao ligar ao servidor.");
        }
    }

    private void openFXML(String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/" + fxmlFile));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Quinta Eventos - " + fxmlFile);
            stage.show();

            // fechar janela atual (login)
            Stage currentStage = (Stage) usernameField.getScene().getWindow();
            currentStage.close();

        } catch (Exception e) {
            e.printStackTrace();
            showAlert("Erro ao abrir a página: " + fxmlFile);
        }
    }

    private String tipoUtilizador;

    public void setUserType(String tipo) {
        this.tipoUtilizador = tipo;
        System.out.println("✅ Tipo de utilizador recebido: " + tipo);
    }

    private void showAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}
