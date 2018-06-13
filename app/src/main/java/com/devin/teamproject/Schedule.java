package com.devin.teamproject;

import java.util.Date;

public class Schedule {
    private Date date;
    private int hour;
    private String name;
    private int courtNum;

    public int getHour(){
        return hour;
    }

    public void setHour(int hour){
        this.hour = hour;
    }

    public Date getDate(){
        return date;
    }

    public void setDate(Date date){
        this.date = date;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getCourtNum(){
        return courtNum;
    }

    public void setCourtNum(int courtNum){
        this.courtNum = courtNum;
    }

}
