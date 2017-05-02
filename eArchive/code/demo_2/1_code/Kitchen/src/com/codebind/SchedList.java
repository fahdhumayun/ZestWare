package com.codebind;

/**
 * Created by Alex on 4/23/2017.
 */
public class SchedList {

    private java.sql.Date idDate;
    private String begin;
    private String end;

    public SchedList(java.sql.Date IdDate, String Begin, String End){
        this.idDate = IdDate;
        this.begin = Begin;
        this. end = End;
    }

    public java.sql.Date getIdDate(){return idDate;}

    public String getBegin(){return begin;}

    public String getEnd(){return end;}
}
