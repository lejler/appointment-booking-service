package de.layla.terminbehoerde.mainwindow;

import de.layla.terminbehoerde.user.UserModel;
import de.layla.terminbehoerde.appointment.AppointmentModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable {

    @FXML
    private TextField date;
    @FXML
    private Button bookAppointment;
    @FXML
    private TextField name;
    @FXML
    private TextField mailAddress;
    @FXML
    private TextField phoneNumber;
    @FXML
    private TextField region;
    @FXML
    private TextField timeEarliest;
    @FXML
    private TextField timeLatest;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    private UserModel fetchUserData() {
        return new UserModel(this.name.getText(), this.mailAddress.getText(), this.phoneNumber.getText());
    }

    private AppointmentModel fetchAppointmentData() {
        if (timeEarliest.getText().equals("") && timeLatest.getText().equals("")) {
            return new AppointmentModel(this.region.getText(), this.date.getText());
        }
        return new AppointmentModel(this.timeEarliest.getText(), this.timeLatest.getText(), this.region.getText(), this.date.getText());
    }

    @FXML
    public void book(ActionEvent actionEvent) {
        System.out.println(fetchUserData());
        System.out.println(fetchAppointmentData());
    }
}