package de.layla.terminbehoerde.mainwindow;

import de.layla.terminbehoerde.appointment.Month;
import de.layla.terminbehoerde.user.UserModel;
import de.layla.terminbehoerde.appointment.AppointmentModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable {

    @FXML
    private ComboBox<String> month;
    @FXML
    private ComboBox<Integer> day;
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
        for (int i = 1; i <= 31; i++) {
            this.day.getItems().add(i);
        }
        for (int i = 0; i < Month.values().length; i++) {
            this.month.getItems().add(String.valueOf(Month.values()[i]));
        }
    }

    private UserModel fetchUserData() {
        return new UserModel(this.name.getText(), this.mailAddress.getText(), this.phoneNumber.getText());
    }

    private AppointmentModel fetchAppointmentData() {
        if (timeEarliest.getText().equals("") && timeLatest.getText().equals("")) {
            return new AppointmentModel(this.region.getText(), this.day.getSelectionModel().getSelectedItem(), this.month.getSelectionModel().getSelectedItem());
        }
        return new AppointmentModel(this.timeEarliest.getText(), this.timeLatest.getText(), this.region.getText(), this.day.getSelectionModel().getSelectedItem(), this.month.getSelectionModel().getSelectedItem());
    }

    @FXML
    public void book(ActionEvent actionEvent) {
        System.out.println(fetchUserData());
        System.out.println(fetchAppointmentData());
    }

    public ComboBox<String> getMonth() {
        return month;
    }

    public void setMonth(ComboBox<String> month) {
        this.month = month;
    }

    public ComboBox<Integer> getDay() {
        return day;
    }

    public void setDay(ComboBox<Integer> day) {
        this.day = day;
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

    public TextField getTimeEarliest() {
        return timeEarliest;
    }

    public void setTimeEarliest(TextField timeEarliest) {
        this.timeEarliest = timeEarliest;
    }

    public TextField getTimeLatest() {
        return timeLatest;
    }

    public void setTimeLatest(TextField timeLatest) {
        this.timeLatest = timeLatest;
    }
}