package com.backoffice;
import com.backoffice.Controllers.MainViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MainView.fxml"));
        loader.setControllerFactory(param -> new MainViewController());
        stage.setScene(new Scene(loader.load(), 800, 600));
        stage.setTitle("BackOffice – Quinta Eventos");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
