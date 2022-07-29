package de.layla.terminbehoerde.appointment;

public class AppointmentModel {

    private String timeEarliest;
    private String timeLatest;
    private String region;
    private Integer day;
    private String month;

    public AppointmentModel(String timeEarliest, String timeLatest, String region, Integer day, String month) {
        this.timeEarliest = timeEarliest;
        this.timeLatest = timeLatest;
        this.region = region;
        this.day = day;
        this.month = month;
    }

    public AppointmentModel(String region, Integer day, String month) {
        this.region = region;
        this.day = day;
        this.month = month;
        this.timeEarliest = "00:00";
        this.timeLatest = "24:00";
    }

    @Override
    public String toString() {
        return "AppointmentModel{" +
                "timeEarliest='" + timeEarliest + '\'' +
                ", timeLatest='" + timeLatest + '\'' +
                ", region='" + region + '\'' +
                ", day=" + day +
                ", month='" + month + '\'' +
                '}';
    }

    public String getTimeEarliest() {
        return timeEarliest;
    }

    public void setTimeEarliest(String timeEarliest) {
        this.timeEarliest = timeEarliest;
    }

    public String getTimeLatest() {
        return timeLatest;
    }

    public void setTimeLatest(String timeLatest) {
        this.timeLatest = timeLatest;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }


    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }
}
