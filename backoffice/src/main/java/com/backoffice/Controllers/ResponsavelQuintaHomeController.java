package com.backoffice.Controllers;

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
}
