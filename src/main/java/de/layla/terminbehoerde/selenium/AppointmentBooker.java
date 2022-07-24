package de.layla.terminbehoerde.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AppointmentBooker {

    FirefoxOptions options = new FirefoxOptions();
    private final WebDriver driver = new FirefoxDriver(options);

    public AppointmentBooker() {
        System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\geckodriver\\geckodriver.exe");
        WebDriverManager.firefoxdriver().setup();
    }

    public void test() {

        driver.get("https://service.berlin.de/dienstleistung/120703/");
        System.out.println("Current URL: " + driver.getCurrentUrl());
        System.out.println("Page source:" + driver.getPageSource());
        driver.findElement(By.className("btn")).click();
    }

    public static void main(String[] args) {
        AppointmentBooker booker = new AppointmentBooker();
        booker.test();
    }

}
