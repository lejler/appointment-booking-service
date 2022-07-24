package de.layla.terminbehoerde.mainwindow;

import de.layla.terminbehoerde.StartApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainWindow {

    public void start() {
        FXMLLoader fxmlLoader = new FXMLLoader(StartApplication.class.getResource("MainWindowView.fxml"));
        Stage stage = new Stage();
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 400, 350);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.setTitle("Termin buchen");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

}
