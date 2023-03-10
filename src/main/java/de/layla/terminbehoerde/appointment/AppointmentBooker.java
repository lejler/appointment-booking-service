package de.layla.terminbehoerde.appointment;

import de.layla.terminbehoerde.user.UserModel;
import de.layla.terminbehoerde.utils.DriverHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class AppointmentBooker {

    private final AppointmentModel appointmentModel;
    private final UserModel userModel;
    private boolean appointmentBookable = false;
    private String serviceUrl;

    public AppointmentBooker(AppointmentModel appointmentModel, UserModel userModel) {
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
        DriverHelper.getInstance().findElement(By.id("agbgelesen")).click();
        DriverHelper.getInstance().findElement(By.name("familyName")).sendKeys(userModel.getName());
        DriverHelper.getInstance().findElement(By.name("email")).sendKeys(userModel.getMailAddress());
        try {
            DriverHelper.getInstance().findElement(By.name("telephone")).sendKeys(userModel.getPhoneNumber());
        } catch (NoSuchElementException ignored) {
        }
        Select surveyAccepted = new Select(DriverHelper.getInstance().findElement(By.name("surveyAccepted")));
        surveyAccepted.selectByVisibleText("Nicht zustimmen");

        DriverHelper.getInstance().findElement(By.id("register_submit")).click();
        DriverHelper.getInstance().quit();
    }

    // selects actual appointment
    private void selectChosenTime(String time) {
        selectChosenDay(appointmentModel.getDay());
        WebElement timeElement = DriverHelper.getInstance().findElement(By.xpath("//th[text()[contains(., '" + time + "')]]"));
        DriverHelper.getInstance().get(timeElement.findElement(By.xpath("//th[@class='buchbar']/following-sibling::td")).findElement(By.tagName("a")).getAttribute("href"));
    }

    // redirects driver to booking page of chosen day
    private void selectChosenDay(Integer day) {
        getCalendarPage();
        while (!appointmentBookable) {
            try {
                DriverHelper.getInstance().get(selectChosenMonth(appointmentModel.getMonth()).findElement(By.xpath("//a[text()[contains(., '" + day + "')]]")).getAttribute("href"));
                appointmentBookable = true;
            } catch (NullPointerException | NoSuchElementException e) {
                DriverHelper.getInstance().navigate().refresh();
            }
        }
    }

    // returns table element of chosen month
    private WebElement selectChosenMonth(Month month) {
        WebElement tmp = DriverHelper.getInstance().findElement(By.xpath("//*[text()[contains(., '" + month.name() + "')]]"));
        return (WebElement) ((JavascriptExecutor) DriverHelper.getInstance()).executeScript(
                "return arguments[0].parentNode.parentNode.parentNode", tmp
        );
    }

    private void getCalendarPage() {
        DriverHelper.getInstance().get(serviceUrl);
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
