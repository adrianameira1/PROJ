package com.backoffice.Controllers;

import com.backoffice.Service.ReservaService;
import com.example.core.models.Reserva;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Controlador do ecrã de reservas.
 * O FXMLLoader cria-o via controllerFactory do Spring,
 * por isso o fx:controller no FXML pode ficar como está.
 */
@Component
public class ReservasMenuController {

    @Autowired
    private ReservaService reservaService;

    /* ---------- nós FXML ---------- */
    @FXML private TextField filtroEmail;
    @FXML private ComboBox<String> comboTipoConta;

    @FXML private TableView<ReservaRow> tabelaReservas;
    @FXML private TableColumn<ReservaRow,Integer> colunaId;
    @FXML private TableColumn<ReservaRow,String>  colunaNome;
    @FXML private TableColumn<ReservaRow,String>  colunaStatus;
    @FXML private TableColumn<ReservaRow,String>  colunaData;
    @FXML private TableColumn<ReservaRow,Integer> colunaNumeroConvidados;

    private final ObservableList<ReservaRow> dadosTabela = FXCollections.observableArrayList();

    /* --------------- inicialização --------------- */
    @FXML
    public void initialize() {
        configurarColunas();
        carregarReservas();
    }

    private void configurarColunas() {
        colunaId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colunaStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        colunaData.setCellValueFactory(new PropertyValueFactory<>("data"));
        colunaNumeroConvidados.setCellValueFactory(new PropertyValueFactory<>("numeroConvidados"));
    }

    private void carregarReservas() {
        dadosTabela.clear();
        List<Reserva> reservas = reservaService.listarTodas();
        reservas.stream()
                .map(ReservaRow::fromEntity)
                .forEach(dadosTabela::add);
        tabelaReservas.setItems(dadosTabela);
    }

    /* --------------- handlers --------------- */

    @FXML
    private void filtrarReservas() {
        String texto = filtroEmail.getText().toLowerCase();
        tabelaReservas.setItems(dadosTabela.filtered(r ->
                r.getEmail().toLowerCase().contains(texto)));
    }

    @FXML
    private void criarNovaReserva() {
        // TODO: abrir diálogo de criação
        Alert a = new Alert(Alert.AlertType.INFORMATION,
                "Funcionalidade ainda não implementada.",
                ButtonType.OK);
        a.showAndWait();
    }
}

/* ========== DTO só para a TableView ========== */
class ReservaRow {

    private Integer id;
    private String  nome;
    private String  email;
    private String  status;
    private String  data;
    private Integer numeroConvidados;

    /* --- fábrica a partir da entidade JPA --- */
    static ReservaRow fromEntity(Reserva r) {
        ReservaRow row = new ReservaRow();
        row.id = r.getId();
        row.nome = r.getNome();
        row.email = (r.getIdCliente() != null) ? r.getIdCliente().getEmail() : "";
        row.status = r.getStatus();
        row.data = r.getData().toString();
        row.numeroConvidados = r.getNumeroconvidados();
        return row;
    }

    /* getters necessárias ao PropertyValueFactory */
    public Integer getId() { return id; }
    public String getNome() { return nome; }
    public String getEmail() { return email; }
    public String getStatus() { return status; }
    public String getData() { return data; }
    public Integer getNumeroConvidados() { return numeroConvidados; }
}
