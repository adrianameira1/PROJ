package com.backoffice.Controllers;
import java.util.List;
import com.backoffice.model.Utilizador;
import com.backoffice.Service.ApiService;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import com.backoffice.Service.ApiService;


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
                    String tipo = u.getIdTipouser().getDesignacao();

                    if (tipo.equalsIgnoreCase("Administrador")) {
                        tipo = "Responsável da Quinta";
                        showAlert("Login como " + tipo + " efetuado!");
                        // abrir HomeAdmin.fxml
                    } else if (tipo.equalsIgnoreCase("Gestor")) {
                        showAlert("Login como Gestor efetuado!");
                        // abrir HomeGestor.fxml
                    } else if (tipo.equalsIgnoreCase("Chefe de Sala")) {
                        showAlert("Login como Chefe de Sala efetuado!");
                        // abrir HomeChefeSala.fxml
                    }
                    return;
                }
            }

            // se chegou aqui: username não encontrado
            showAlert("Utilizador não existe.");

        } catch (Exception e) {
            e.printStackTrace();
            showAlert("Erro ao ligar ao servidor.");
        }
    }


    private void showAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }

}
