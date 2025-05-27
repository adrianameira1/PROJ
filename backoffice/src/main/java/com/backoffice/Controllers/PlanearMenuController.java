package com.backoffice.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.Node;
import org.springframework.stereotype.Component;

@Component
public class PlanearMenuController {

    @FXML private TextField txtIdEvento;
    @FXML private TextArea txtDecoracao, txtCronograma;
    @FXML private CheckBox checkAtracaoInfantil, checkInsuflaveis, checkMascotes, checkCircenses, checkPinturas, checkBaloes;
    @FXML private CheckBox checkAtracaoMusical, checkDJ, checkBandas, checkSolo, checkDancas;
    @FXML private RadioButton radioBuffet, radioMenuServido, radioCoquetel;
    @FXML private CheckBox checkSom, checkLuz, checkPalco;
    @FXML private ComboBox<String> comboStatus;

    @FXML
    private void guardarPlano() {
        System.out.println("🎀 Guardar Plano:");
        System.out.println("ID Evento: " + txtIdEvento.getText());
        System.out.println("Decoração: " + txtDecoracao.getText());
        System.out.println("Cronograma: " + txtCronograma.getText());
        System.out.println("Status: " + comboStatus.getValue());
        // Aqui virá a lógica para guardar via JPA, se quiseres
    }

    @FXML
    private void voltar() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/GestorHome.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Home - Responsável Evento");
            stage.show();

            Stage current = (Stage) txtIdEvento.getScene().getWindow();
            current.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
