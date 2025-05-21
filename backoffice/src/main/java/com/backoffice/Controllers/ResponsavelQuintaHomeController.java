package com.backoffice.Controllers;
import javafx.scene.Node;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ResponsavelQuintaHomeController {

    private void abrirJanela(String fxmlPath, String titulo) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            loader.setControllerFactory(com.backoffice.MainApp.getSpringContext()::getBean); // <--- esta linha é essencial
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle(titulo);
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            System.out.println("Erro ao carregar " + fxmlPath);
            e.printStackTrace();
        }
    }


    @FXML
    private void abrirReservas() {
        abrirJanela("/fxml/ReservasMenu.fxml", "Gestão de Reservas");
    }

    @FXML
    private void abrirPagamentos() {
        abrirJanela("/fxml/PagamentosMenu.fxml", "Gestão de Pagamentos");
    }

    @FXML
    private void abrirFaturas() {
        abrirJanela("/fxml/FaturasMenu.fxml", "Gestão de Faturas");
    }

    @FXML
    private void abrirContratos() {
        abrirJanela("/fxml/ContratosMenu.fxml", "Gestão de Contratos");
    }


    @FXML
    private void terminarSessao(javafx.event.ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MainView.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Login Inicial");
            stage.show();

            // Fecha a janela atual
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentStage.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }





}



