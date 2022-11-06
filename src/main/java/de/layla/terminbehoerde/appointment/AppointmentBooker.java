package de.layla.terminbehoerde.appointment;

import de.layla.terminbehoerde.appointment.AppointmentModel;
import de.layla.terminbehoerde.appointment.Month;
import de.layla.terminbehoerde.user.UserModel;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class AppointmentBooker {

    private final ChromeOptions options = new ChromeOptions();
    private final WebDriver driver;
    private final AppointmentModel appointmentModel;
    private final UserModel userModel;
    private boolean appointmentBookable = false;
    private String serviceUrl;

    public AppointmentBooker(AppointmentModel appointmentModel, UserModel userModel) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        this.appointmentModel = appointmentModel;
        this.userModel = userModel;
        this.serviceUrl = appointmentModel.getService().getUrl();
        book();
    }

    public void book() {
        fillOutForm();
    }

    private void fillOutForm() {
        selectChosenTime(appointmentModel.getTime());
        driver.findElement(By.id("agbgelesen")).click();
        driver.findElement(By.name("familyName")).sendKeys(userModel.getName());
        driver.findElement(By.name("email")).sendKeys(userModel.getMailAddress());
        try {
            driver.findElement(By.name("telephone")).sendKeys(userModel.getPhoneNumber());
        } catch (NoSuchElementException ignored) {
        }
        Select surveyAccepted = new Select(driver.findElement(By.name("surveyAccepted")));
        surveyAccepted.selectByVisibleText("Nicht zustimmen");

        driver.findElement(By.id("register_submit")).click();
        driver.quit();
    }

    // selects actual appointment
    private void selectChosenTime(String time) {
        selectChosenDay(appointmentModel.getDay());
        WebElement timeElement = driver.findElement(By.xpath("//th[text()[contains(., '" + time + "')]]"));
        driver.get(timeElement.findElement(By.xpath("//th[@class='buchbar']/following-sibling::td")).findElement(By.tagName("a")).getAttribute("href"));
    }

    // redirects driver to booking page of chosen day
    private void selectChosenDay(Integer day) {
        getCalendarPage();
        while (!appointmentBookable) {
            try {
                driver.get(selectChosenMonth(appointmentModel.getMonth()).findElement(By.xpath("//a[text()[contains(., '" + day + "')]]")).getAttribute("href"));
                appointmentBookable = true;
            } catch (NullPointerException | NoSuchElementException e) {
                driver.navigate().refresh();
            }
        }
    }

    // returns table element of chosen month
    private WebElement selectChosenMonth(Month month) {
        WebElement tmp = driver.findElement(By.xpath("//*[text()[contains(., '" + month.name() + "')]]"));
        return (WebElement) ((JavascriptExecutor) driver).executeScript(
                "return arguments[0].parentNode.parentNode.parentNode", tmp
        );
    }

    private void getCalendarPage() {
        driver.get(serviceUrl);
    }

    public ChromeOptions getOptions() {
        return options;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public AppointmentModel getAppointmentModel() {
        return appointmentModel;
    }

    public UserModel getUserModel() {
        return userModel;
    }

    public boolean isAppointmentBookable() {
        return appointmentBookable;
    }

    public void setAppointmentBookable(boolean appointmentBookable) {
        this.appointmentBookable = appointmentBookable;
    }

    public String getServiceUrl() {
        return serviceUrl;
    }

    public void setServiceUrl(String serviceUrl) {
        this.serviceUrl = serviceUrl;
    }
}
