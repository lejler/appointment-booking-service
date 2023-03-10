package de.layla.terminbehoerde.mainwindow;

import de.layla.terminbehoerde.appointment.AppointmentBooker;
import de.layla.terminbehoerde.user.UserModel;
import de.layla.terminbehoerde.appointment.AppointmentModel;
import de.layla.terminbehoerde.utils.OptionsGetter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Locale;
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

        ArrayList<String> months = OptionsGetter.getMonthsWithoutYear();
        DatePicker datePicker = new DatePicker();
        datePicker.setDayCellFactory(picker -> new DateCell() {
            @Override
            public void updateItem(LocalDate localDate, boolean empty) {
                super.updateItem(localDate, empty);
                boolean isEnabled = false;
                System.out.println(localDate.getMonth().getDisplayName(TextStyle.FULL, Locale.GERMAN));
                for (String month : months) {
                    if (localDate.getMonth().getDisplayName(TextStyle.FULL, Locale.GERMAN).equalsIgnoreCase(month)) {
                        isEnabled = true;
                        break;
                    }
                }
                setDisable(!isEnabled);
                if (!isEnabled) {
                    setStyle("-fx-background-color: #ffc0cb;");
                } else {
                    setStyle("");
                }
            }
        });
        root.add(datePicker, 1, 9);
        // initialize months
        /*
        ObservableList<String> monthItems = FXCollections.observableArrayList(OptionsGetter.getMonths());
        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.setItems(monthItems);
        root.add(comboBox, 2, 9);
        */
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
