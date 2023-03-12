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
    requires org.seleniumhq.selenium.support;

    opens de.layla.abs to javafx.fxml;
    exports de.layla.abs;
    exports de.layla.abs.appointment;
    opens de.layla.abs.appointment to javafx.fxml;
    exports de.layla.abs.mainwindow;
    opens de.layla.abs.mainwindow to javafx.fxml;
    exports de.layla.abs.user;
    opens de.layla.abs.user to javafx.fxml;
}