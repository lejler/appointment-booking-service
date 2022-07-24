module de.layla.terminbehoerde {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.controlsfx.controls;
    requires validatorfx;
    requires org.kordamp.bootstrapfx.core;
    requires org.seleniumhq.selenium.firefox_driver;
    requires org.seleniumhq.selenium.api;
    requires io.github.bonigarcia.webdrivermanager;
    requires org.seleniumhq.selenium.chrome_driver;

    opens de.layla.terminbehoerde to javafx.fxml;
    exports de.layla.terminbehoerde;
    exports de.layla.terminbehoerde.appointment;
    opens de.layla.terminbehoerde.appointment to javafx.fxml;
    exports de.layla.terminbehoerde.mainwindow;
    opens de.layla.terminbehoerde.mainwindow to javafx.fxml;
    exports de.layla.terminbehoerde.user;
    opens de.layla.terminbehoerde.user to javafx.fxml;
}