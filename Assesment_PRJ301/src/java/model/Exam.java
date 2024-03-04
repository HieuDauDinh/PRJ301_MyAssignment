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
public class Exam {
    private int eid;
    private Assessment aid;
    private Date start;
    private Date end;

    public Exam() {
    }

    public Exam(int eid, Assessment aid, Date start, Date end, double score) {
        this.eid = eid;
        this.aid = aid;
        this.start = start;
        this.end = end;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public Assessment getAid() {
        return aid;
    }

    public void setAid(Assessment aid) {
        this.aid = aid;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

}
