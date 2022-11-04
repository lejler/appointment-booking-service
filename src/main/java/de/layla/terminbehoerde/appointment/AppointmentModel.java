package de.layla.terminbehoerde.appointment;

public class AppointmentModel {

    private String time;
    private String region;
    private Integer day;
    private Month month;
    private AppointmentType service;

    public AppointmentModel(String time, String region, Integer day, Month month, AppointmentType service) {
        this.time = time;
        this.region = region;
        this.day = day;
        this.month = month;
        this.service = service;
    }

    public AppointmentModel(String region, Integer day, Month month, AppointmentType service) {
        this.region = region;
        this.day = day;
        this.month = month;
        this.time = "00:00";
        this.service = service;
    }

    @Override
    public String toString() {
        return "AppointmentModel{" +
                "time='" + time + '\'' +
                ", region='" + region + '\'' +
                ", day=" + day +
                ", month='" + month + '\'' +
                '}';
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
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

    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    public AppointmentType getService() {
        return service;
    }

    public void setService(AppointmentType service) {
        this.service = service;
    }
}
