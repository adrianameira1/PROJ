package com.backoffice.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import org.springframework.stereotype.Component;

@Component
public class GestorHomeController {

    private void abrirJanela(String fxmlPath, String titulo) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
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
    private void abrirPlaneamentoEvento() {
        abrirJanela("/fxml/PlanearMenu.fxml", "Gestão de Eventos");
    }

    @FXML
    private void abrirOrcamentos() {
        abrirJanela("/fxml/OrçamentosMenu.fxml", "Orçamentos de Eventos");
    }

    @FXML
    private void abrirFornecedores() {
        abrirJanela("/fxml/FornecedoresMenu.fxml", "Gestão de Fornecedores");
    }

    @FXML
    private void abrirContatoClientes() {
        abrirJanela("/fxml/ClientesMenu.fxml", "Contactar Clientes");
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
