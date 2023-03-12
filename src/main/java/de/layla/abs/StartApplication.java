package de.layla.abs;

import de.layla.abs.appointment.Month;
import de.layla.abs.mainwindow.MainWindow;
import javafx.application.Application;
import javafx.stage.Stage;

import javax.swing.plaf.synth.SynthLabelUI;
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