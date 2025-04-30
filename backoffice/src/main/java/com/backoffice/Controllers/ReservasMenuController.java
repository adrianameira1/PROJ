package com.backoffice.Controllers;

import com.backoffice.Service.ReservaService;
import com.backoffice.model.ReservaRow;
import com.example.core.models.Reserva;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

import java.util.List;

@Component
public class ReservasMenuController {

    @Autowired
    private ReservaService reservaService;

    @FXML private TextField filtroEmail;
    @FXML private ComboBox<String> comboTipoConta;
    @FXML private TableView<ReservaRow> tabelaReservas;
    @FXML private TableColumn<ReservaRow, String> colNome;
    @FXML private TableColumn<ReservaRow, String> colEmail;
    @FXML private TableColumn<ReservaRow, String> colData;
    @FXML private TableColumn<ReservaRow, String> colEstado;
    @FXML private TableColumn<ReservaRow, Void> colAcoes;

    private ObservableList<ReservaRow> lista = FXCollections.observableArrayList();

    @PostConstruct
    public void init() {
        configurarTabela();
        carregarReservas();
    }

    private void configurarTabela() {
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colData.setCellValueFactory(new PropertyValueFactory<>("data"));
        colEstado.setCellValueFactory(new PropertyValueFactory<>("status"));

        colAcoes.setCellFactory(col -> new TableCell<>() {
            private final Button btn = new Button("Marcar como Confirmada");

            {
                btn.setOnAction(e -> {
                    ReservaRow reserva = getTableView().getItems().get(getIndex());
                    atualizarStatus(reserva);
                });
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(btn);
                }
            }
        });
    }

    private void carregarReservas() {
        lista.clear();
        List<Reserva> reservas = reservaService.listarTodas();
        for (Reserva r : reservas) {
            String email = (r.getIdCliente() != null) ? r.getIdCliente().getEmail() : "N/A";
            lista.add(new ReservaRow(r.getNome(), email, r.getData(), r.getStatus()));
        }
        tabelaReservas.setItems(lista);
    }

    @FXML
    private void filtrarReservas() {
        // Filtro por email (simples, só como base)
        String filtro = filtroEmail.getText().toLowerCase();
        ObservableList<ReservaRow> filtradas = lista.filtered(r -> r.getEmail().toLowerCase().contains(filtro));
        tabelaReservas.setItems(filtradas);
    }

    @FXML
    private void criarNovaReserva() {
        // Aqui podes abrir outro FXML para preencher nova reserva
        System.out.println("Abrir formulário de nova reserva (ainda por implementar)");
    }

    private void atualizarStatus(ReservaRow row) {
        List<Reserva> reservas = reservaService.listarTodas();
        for (Reserva r : reservas) {
            if (r.getNome().equals(row.getNome()) && r.getData().equals(row.getData())) {
                r.setStatus("Confirmada");
                reservaService.guardar(r);
                carregarReservas();
                break;
            }
        }
    }
}
