package com.backoffice.Controllers;
import com.backoffice.Controllers.LoginController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import org.springframework.stereotype.Component;

import java.io.IOException;
@Component
public class MainViewController {

    @FXML
    private Button adminButton;

    @FXML
    private Button gestorButton;

    @FXML
    private Button chefeButton;

    @FXML
    private void openLoginAdmin() throws IOException {
        openLogin("admin");
    }

    @FXML
    private void openLoginGestor() throws IOException {
        openLogin("gestor");
    }

    @FXML
    private void openLoginChefe() throws IOException {
        openLogin("chefe");
    }

    private void openLogin(String userType) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/LoginView.fxml"));
        Parent root = fxmlLoader.load();

        LoginController controller = fxmlLoader.getController();
        controller.setUserType(userType);

        Stage loginStage = new Stage();
        loginStage.setTitle("Login - Quinta Eventos");
        loginStage.setScene(new Scene(root, 800, 600));
        loginStage.show();


        Stage currentStage = (Stage) adminButton.getScene().getWindow();
        currentStage.close();
    }
}
