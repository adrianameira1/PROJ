package com.backoffice;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.io.IOException;

public class MainViewController {

    @FXML
    private Button adminButton;

    @FXML
    private Button gestorButton;

    @FXML
    private Button chefeButton;

    @FXML
    private void openLogin() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/LoginView.fxml"));
        Parent root = fxmlLoader.load();
        Stage loginStage = new Stage();
        loginStage.setTitle("Login - Quinta Eventos");

        // Definimos o tamanho diretamente aqui
        loginStage.setScene(new Scene(root, 800, 600)); // largura 800px e altura 600px

        loginStage.show();

        // Fecha a janela atual (MainView)
        Stage currentStage = (Stage) adminButton.getScene().getWindow();
        currentStage.close();
    }

}
