package com.example.ahorcadojavafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1200, 1200);
        stage.setTitle("Juego del ahorcado BY: Lernik Gasparyan!");
       /*Tiene que estar el css en la carpeta de resources para que se puedan aplicar los estilos
       en el momento de ejecuartarse el archivo JAR */
        scene.getStylesheets().add("com/example/ahorcadojavafx/estiloJuego.css");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}