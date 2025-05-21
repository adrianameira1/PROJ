package com.backoffice;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.ApplicationContext;

public class MainApp extends Application {

    private static ApplicationContext springContext;

    @Override
    public void init() {
        springContext = new AnnotationConfigApplicationContext("com.backoffice", "com.example.core");
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MainView.fxml"));
        loader.setControllerFactory(springContext::getBean);

        Parent root = loader.load();
        primaryStage.setTitle("BackOffice – Quinta Eventos");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }

    public static ApplicationContext getSpringContext() {
        return springContext;
    }

    public static void main(String[] args) {
        launch();
    }
}
