/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.sql.*;
/**
 *
 * @author Admin
 */
public class TimeSlot {
    private int Tid;
    private Time timeStart, timeEnd;

    public TimeSlot() {
    }

    public TimeSlot(int Tid, Time timeStart, Time timeEnd) {
        this.Tid = Tid;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
    }

    public int getTid() {
        return Tid;
    }

    public void setTid(int Tid) {
        this.Tid = Tid;
    }

    public Time getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(Time timeStart) {
        this.timeStart = timeStart;
    }

    public Time getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Time timeEnd) {
        this.timeEnd = timeEnd;
    }


  
}
