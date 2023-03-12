package de.layla.abs.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverHelper {

    private static WebDriver INSTANCE;
    private static final ChromeOptions options = new ChromeOptions();


    public static WebDriver getInstance() {
        if (INSTANCE == null) {
            WebDriverManager.chromedriver().setup();
            INSTANCE = new ChromeDriver(options);
        }
        return INSTANCE;
    }

}
