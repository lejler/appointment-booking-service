package de.layla.terminbehoerde.selenium;

import de.layla.terminbehoerde.appointment.AppointmentModel;
import de.layla.terminbehoerde.appointment.Month;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.Optional;

/*
29.12.22 https://service.berlin.de/terminvereinbarung/termin/time/1672268400/
27.12.22 https://service.berlin.de/terminvereinbarung/termin/time/1672095600/
02.01.23 https://service.berlin.de/terminvereinbarung/termin/time/1672614000/
*/

public class AppointmentBooker {

    private final ChromeOptions options = new ChromeOptions();
    private final WebDriver driver;
    private final AppointmentModel appointmentModel;
    private boolean appointmentBookable = false;
    private final String bookingPage = "https://service.berlin.de/terminvereinbarung/termin/tag.php?termin=1&anliegen[]=120703&dienstleisterlist=122210,122217,327316,122219,327312,122227,327314,122231,327346,122238,122243,327348,122252,329742,122260,329745,122262,329748,122254,331011,329751,122271,327278,122273,327274,122277,327276,330436,122280,327294,122282,327290,122284,327292,122291,327270,122285,327266,122286,327264,122296,327268,150230,329760,122301,327282,122297,327286,122294,327284,122312,329763,122314,329775,122304,327330,122311,327334,122309,327332,317869,122281,327352,122283,122279,329772,122276,327324,122274,327326,122267,329766,122246,327318,122251,327320,327653,122257,330265,327322,122208,327298,122226,327300&herkunft=http%3A%2F%2Fservice.berlin.de%2Fdienstleistung%2F120703%2F";

    public AppointmentBooker(AppointmentModel appointmentModel) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        this.appointmentModel = appointmentModel;
    }

    public void test() {
        getCalendarPage();
        selectChosenTime("15");
        fillOutForm("Layla", "Shokri", "layla.shokri@gmx.de", "015252651487");
    }

    private void fillOutForm(String firstName, String lastName, String email, String phoneNumber) {
        driver.findElement(By.name("familyName")).sendKeys(firstName + " " + lastName);
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("agbgelesen")).click();
        try {
            driver.findElement(By.name("telephone")).sendKeys(phoneNumber);
        } catch (NoSuchElementException ignored) {
        }
        Select surveyAccepted = new Select(driver.findElement(By.name("surveyAccepted")));
        surveyAccepted.selectByVisibleText("Nicht zustimmen");

        driver.findElement(By.id("register_submit")).click();
    }

    //selects actual appointment
    private void selectChosenTime(String time) {
        selectChosenDay(appointmentModel.getDay());
        WebElement timeElement = driver.findElement(By.xpath("//th[text()[contains(., '" + time + "')]]"));
        driver.get(timeElement.findElement(By.xpath("//th[@class='buchbar']/following-sibling::td")).findElement(By.tagName("a")).getAttribute("href"));
    }

    // redirects driver to booking page of chosen day
    private void selectChosenDay(Integer day) {
        while (!appointmentBookable) {
            try {
                driver.get(selectChosenMonth(appointmentModel.getMonth()).findElement(By.xpath("//a[text()[contains(., '" + day + "')]]")).getAttribute("href"));
                appointmentBookable = true;
            } catch (NullPointerException e) {
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
        driver.get(bookingPage);
    }

    public static void main(String[] args) {
        AppointmentBooker booker = new AppointmentBooker(new AppointmentModel("Friedrichshain-Kreuzberg", 29, Month.Dezember));
        booker.test();
    }

    public ChromeOptions getOptions() {
        return options;
    }

    public WebDriver getDriver() {
        return driver;
    }

}
