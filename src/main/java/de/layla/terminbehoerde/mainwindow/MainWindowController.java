package de.layla.terminbehoerde.mainwindow;

import de.layla.terminbehoerde.appointment.AppointmentType;
import de.layla.terminbehoerde.appointment.Month;
import de.layla.terminbehoerde.appointment.AppointmentBooker;
import de.layla.terminbehoerde.user.UserModel;
import de.layla.terminbehoerde.appointment.AppointmentModel;
import de.layla.terminbehoerde.utils.OptionsGetter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable {

    @FXML
    private GridPane root;
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
    private TextField time;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        // TODO: customize datepicker (?)

        // initialize months
        ObservableList<String> monthItems = FXCollections.observableArrayList(OptionsGetter.getMonths());
        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.setItems(monthItems);
        root.add(comboBox, 2, 9);
    }

    private UserModel fetchUserData() {
        return new UserModel(this.name.getText(), this.mailAddress.getText(), this.phoneNumber.getText());
    }

    private AppointmentModel fetchAppointmentData() {
        // TODO: fetch appointment data
        return null;
    }

    @FXML
    private void book(ActionEvent actionEvent) {
        Runnable runnable = () -> {
            new AppointmentBooker(fetchAppointmentData(), fetchUserData());
        };
        Thread t = new Thread(runnable);
        t.start();
    }

    public Button getBookAppointment() {
        return bookAppointment;
    }

    public void setBookAppointment(Button bookAppointment) {
        this.bookAppointment = bookAppointment;
    }

    public TextField getName() {
        return name;
    }

    public void setName(TextField name) {
        this.name = name;
    }

    public TextField getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(TextField mailAddress) {
        this.mailAddress = mailAddress;
    }

    public TextField getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(TextField phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public TextField getRegion() {
        return region;
    }

    public void setRegion(TextField region) {
        this.region = region;
    }

    public TextField getTime() {
        return time;
    }

    public void setTime(TextField time) {
        this.time = time;
    }
}
