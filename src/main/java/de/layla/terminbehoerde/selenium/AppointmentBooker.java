package de.layla.terminbehoerde.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class AppointmentBooker {

    private FirefoxOptions options = new FirefoxOptions();
    private WebDriver driver = null;

    public AppointmentBooker() {
        WebDriverManager.chromedriver().setup();
        driver = new FirefoxDriver(options);
    }

    public void test() {
        try {
            driver.get("https://service.berlin.de/terminvereinbarung/termin/tag.php?termin=1&anliegen[]=120703&dienstleisterlist=122217,327316,122219,327312,122227,327314,122231,327346,122238,122243,327348,122252,329742,122260,329745,122262,329748,122254,331011,329751,122271,327278,122273,327274,122277,327276,330436,122280,327294,122282,327290,122284,327292,122291,327270,122285,327266,122286,327264,122296,327268,150230,329760,122301,327282,122297,327286,122294,327284,122312,329763,122314,329775,122304,327330,122311,327334,122309,327332,122281,327352,122283,122279,329772,122276,327324,122274,327326,122267,329766,122246,327318,122251,327320,327653,122257,330265,327322,122208,327298,122226,327300&herkunft=http%3A%2F%2Fservice.berlin.de%2Fdienstleistung%2F120703%2F");
            System.out.println(driver.getTitle());
        } finally {
            driver.quit();
        }
    }

    public static void main(String[] args) {
        AppointmentBooker booker = new AppointmentBooker();
        booker.test();
    }

}
