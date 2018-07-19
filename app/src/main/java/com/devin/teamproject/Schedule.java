package com.devin.teamproject;

import java.util.Date;

public class Schedule {
    public int startHour;
    public int endHour;
    public String name;
    public int courtNum;

    Schedule(){};

    Schedule(int courtNum, String name, int startHour, int endHour){
        setCourtNum(courtNum);
        setName(name);
        setStartHour(startHour);
        setEndHour(endHour);
    }

    public int getStartHour() {
        return startHour;
    }

    public int getEndHour() { return endHour; }

    public String getName() {
        return name;
    }

    public int getCourtNum() {
        return courtNum;
    }

    public void setCourtNum(int courtNum) {
        this.courtNum = courtNum;
    }

    public void setStartHour(int startHour) { this.startHour = startHour; }

    public void setEndHour(int endHour) { this.endHour = endHour; }

    public void setName(String name) {
        this.name = name;
    }
}