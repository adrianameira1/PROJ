package com.backoffice.Controllers;

import com.backoffice.MainApp;
import com.backoffice.Service.ReservaService;
import com.backoffice.model.ReservaRow;
import com.example.core.models.Reserva;
import jakarta.annotation.PostConstruct;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;


public class ReservasMenuController {


    private ReservaService reservaService;

    @FXML private TextField filtroEmail;
    @FXML private ComboBox<String> comboTipoConta;

    @FXML private TableView<ReservaRow> tabelaReservas;
    @FXML private TableColumn<ReservaRow, Integer> colunaId;
    @FXML private TableColumn<ReservaRow, String> colunaNome;
    @FXML private TableColumn<ReservaRow, String> colunaStatus;
    @FXML private TableColumn<ReservaRow, String> colunaData;
    @FXML private TableColumn<ReservaRow, Integer> colunaNumeroConvidados;

    private ObservableList<ReservaRow> lista = FXCollections.observableArrayList();

    @PostConstruct
    public void init() {
        configurarTabela();
        carregarReservas();
    }

    private void configurarTabela() {
        colunaId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colunaStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        colunaData.setCellValueFactory(new PropertyValueFactory<>("data"));
        colunaNumeroConvidados.setCellValueFactory(new PropertyValueFactory<>("numeroConvidados"));
    }

    private void carregarReservas() {
        lista.clear();
        List<Reserva> reservas = reservaService.listarTodas();
        for (Reserva r : reservas) {
            Integer id = r.getId();
            String nome = r.getNome();
            String status = r.getStatus();
            String data = r.getData().toString();
            Integer convidados = r.getNumeroconvidados();
            lista.add(new ReservaRow(id, nome, status, data, convidados));
        }
        tabelaReservas.setItems(lista);
    }

    @FXML
    private void filtrarReservas() {
        String filtro = filtroEmail.getText().toLowerCase();
        ObservableList<ReservaRow> filtradas = lista.filtered(r -> r.getNome().toLowerCase().contains(filtro));
        tabelaReservas.setItems(filtradas);
    }

    @FXML
    private void criarNovaReserva() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ReservaForm.fxml"));
            loader.setControllerFactory(MainApp.getSpringContext()::getBean);
            Parent root = loader.load();

            ReservaFormController controller = loader.getController();
            controller.setReservasMenuController(this);

            Stage stage = new Stage();
            stage.setTitle("Nova Reserva");
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
            mostrarAlerta("Erro ao abrir o formulário de nova reserva.");
        }
    }

    private void mostrarAlerta(String mensagem) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }

    public void recarregarTabela() {
        carregarReservas();
    }
}
