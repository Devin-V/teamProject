package com.devin.teamproject;

import java.util.Date;

public class Schedule {
    public int startHour;
    public int endHour;
    public Date date;
    public String name;
    public int courtNum;

    Schedule(){};

    Schedule(Date date, int courtNum, String name, int startHour, int endHour){
        setDate(date);
        setCourtNum(courtNum);
        setName(name);
        setStartHour(startHour);
        setEndHour(endHour);
    }

    public int getStartHour() {
        return startHour;
    }

    public int getEndHour() { return endHour; }

    public Date getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public int getCourtNum() {
        return courtNum;
    }

    public void setCourtNum(int courtNum) {
        this.courtNum = courtNum;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setStartHour(int startHour) { this.startHour = startHour; }

    public void setEndHour(int endHour) { this.endHour = endHour; }

    public void setName(String name) {
        this.name = name;
    }
}