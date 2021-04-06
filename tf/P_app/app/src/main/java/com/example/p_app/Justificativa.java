package com.example.p_app;

public class Justificativa {
    String week;
    String days;
    String status;
    int icon;

    public Justificativa(String week, String days, String status, int icon) {
        this.week = week;
        this.days = days;
        this.status = status;
        this.icon = icon;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}
