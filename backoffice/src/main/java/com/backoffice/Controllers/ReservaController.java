package com.backoffice.Controllers;

import com.backoffice.services.ReservaService;
import com.example.core.models.Reserva;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import jakarta.annotation.PostConstruct;

import java.util.List;

@Controller
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @FXML
    private TableView<Reserva> tabelaReservas;

    @FXML
    private TableColumn<Reserva, Integer> colunaId;

    @FXML
    private TableColumn<Reserva, String> colunaNome;

    @FXML
    private TableColumn<Reserva, String> colunaStatus;

    @FXML
    private TableColumn<Reserva, Integer> colunaNumeroConvidados;

    @PostConstruct
    public void init() {
        configurarTabela();
        carregarReservas();
    }

    private void configurarTabela() {
        colunaId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colunaStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        colunaNumeroConvidados.setCellValueFactory(new PropertyValueFactory<>("numeroconvidados"));
    }

    private void carregarReservas() {
        List<Reserva> reservas = reservaService.listarTodas();
        tabelaReservas.getItems().setAll(reservas);
    }
}
