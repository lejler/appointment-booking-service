package de.layla.terminbehoerde;

import de.layla.terminbehoerde.mainwindow.MainWindow;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class StartApplication extends Application {
    @Override
    public void start(Stage unused) throws IOException {
        MainWindow mainWindow = new MainWindow();
        mainWindow.start();
    }

    public static void main(String[] args) {
        launch();
    }
}