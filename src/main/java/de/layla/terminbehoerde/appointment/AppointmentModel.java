package de.layla.terminbehoerde.appointment;

public class AppointmentModel {

    private String timeEarliest;
    private String timeLatest;
    private String region;
    private String date;

    public AppointmentModel(String timeEarliest, String timeLatest, String region, String date) {
        this.timeEarliest = timeEarliest;
        this.timeLatest = timeLatest;
        this.region = region;
        this.date = date;
    }

    public AppointmentModel(String region, String date) {
        this.region = region;
        this.date = date;
        this.timeEarliest = "00:00";
        this.timeLatest = "24:00";
    }

    @Override
    public String toString() {
        return "AppointmentModel{" +
                "timeEarliest='" + timeEarliest + '\'' +
                ", timeLatest='" + timeLatest + '\'' +
                ", region='" + region + '\'' +
                ", date=" + date +
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
