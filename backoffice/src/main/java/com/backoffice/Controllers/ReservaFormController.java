package com.backoffice.Controllers;

import com.backoffice.Service.ReservaService;
import com.backoffice.model.ReservaRow;
import com.example.core.models.Cliente;
import com.example.core.models.Reserva;
import jakarta.annotation.PostConstruct;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

public class ReservaFormController {

    private ReservaService reservaService;

    @FXML
    private TextField nomeField;

    @FXML
    private DatePicker dataPicker;

    @FXML
    private TextField convidadosField;

    @FXML
    private ComboBox<String> statusCombo;

    @FXML
    private TextField clienteIdField;

    private Reserva reservaEmEdicao;
    private ReservasMenuController reservasMenuController;

    @PostConstruct
    public void initialize() {
        if (statusCombo != null) {
            statusCombo.getItems().addAll("Pré-reserva", "Confirmada", "Cancelada");
        }
    }

    public void carregarReserva(Reserva reserva) {
        this.reservaEmEdicao = reserva;
        nomeField.setText(reserva.getNome());
        dataPicker.setValue(reserva.getData());
        convidadosField.setText(String.valueOf(reserva.getNumeroconvidados()));
        statusCombo.setValue(reserva.getStatus());

        if (reserva.getIdCliente() != null) {
            clienteIdField.setText(String.valueOf(reserva.getIdCliente().getId()));
        }
    }
    @FXML
    private void guardarReserva() {
        try {
            String nome = nomeField.getText();
            LocalDate data = dataPicker.getValue();
            Integer convidados = Integer.parseInt(convidadosField.getText());
            String status = statusCombo.getValue();
            Integer clienteId = Integer.parseInt(clienteIdField.getText());

            Cliente cliente = new Cliente();
            cliente.setId(clienteId);

            if (reservaEmEdicao == null) {
                Reserva nova = new Reserva();
                nova.setNome(nome);
                nova.setData(data);
                nova.setNumeroconvidados(convidados);
                nova.setStatus(status);
                nova.setIdCliente(cliente);
                reservaService.guardar(nova);
            } else {
                reservaEmEdicao.setNome(nome);
                reservaEmEdicao.setData(data);
                reservaEmEdicao.setNumeroconvidados(convidados);
                reservaEmEdicao.setStatus(status);
                reservaEmEdicao.setIdCliente(cliente);
                reservaService.guardar(reservaEmEdicao);
            }

            if (reservasMenuController != null) {
                reservasMenuController.recarregarTabela();
            }

            fecharJanela();
        } catch (Exception e) {
            mostrarAlerta("Erro ao guardar a reserva: " + e.getMessage());
        }
    }


    @FXML
    private void cancelar() {
        fecharJanela();
    }

    private void fecharJanela() {
        Stage stage = (Stage) nomeField.getScene().getWindow();
        stage.close();
    }

    private void mostrarAlerta(String mensagem) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }

    public void setReservasMenuController(ReservasMenuController controller) {
        this.reservasMenuController = controller;
    }
}
