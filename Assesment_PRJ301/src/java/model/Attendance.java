/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.Date;
/**
 *
 * @author Admin
 */
public class Attendance {
    private int aid;
    private Session seid;
    private Student sid;
    private boolean isPresent;
    private String description;
    private Date date;

    public Attendance() {
    }

    public Attendance(int aid, Session seid, Student sid, boolean isPresent, String description, Date date) {
        this.aid = aid;
        this.seid = seid;
        this.sid = sid;
        this.isPresent = isPresent;
        this.description = description;
        this.date = date;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public Session getSeid() {
        return seid;
    }

    public void setSeid(Session seid) {
        this.seid = seid;
    }

    public Student getSid() {
        return sid;
    }

    public void setSid(Student sid) {
        this.sid = sid;
    }

    public boolean isIsPresent() {
        return isPresent;
    }

    public void setIsPresent(boolean isPresent) {
        this.isPresent = isPresent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    
}
