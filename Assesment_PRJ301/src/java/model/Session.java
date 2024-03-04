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
public class Session {
    private int seid;
    private Group gid;
    private Lecturer lid;
    private Room rid;
    private TimeSlot tid;
    private boolean isTaken;
    private Slot slotid;
    private Subject subid;
    private Date date;

    public Session() {
    }

    public Session(int seid, Group gid, Lecturer lid, Room rid, TimeSlot tid, boolean isTaken, Slot slotid, Subject subid, Date date) {
        this.seid = seid;
        this.gid = gid;
        this.lid = lid;
        this.rid = rid;
        this.tid = tid;
        this.isTaken = isTaken;
        this.slotid = slotid;
        this.subid = subid;
        this.date = date;
    }

    public int getSeid() {
        return seid;
    }

    public void setSeid(int seid) {
        this.seid = seid;
    }

    public Group getGid() {
        return gid;
    }

    public void setGid(Group gid) {
        this.gid = gid;
    }

    public Lecturer getLid() {
        return lid;
    }

    public void setLid(Lecturer lid) {
        this.lid = lid;
    }

    public Room getRid() {
        return rid;
    }

    public void setRid(Room rid) {
        this.rid = rid;
    }

    public TimeSlot getTid() {
        return tid;
    }

    public void setTid(TimeSlot tid) {
        this.tid = tid;
    }

    public boolean isIsTaken() {
        return isTaken;
    }

    public void setIsTaken(boolean isTaken) {
        this.isTaken = isTaken;
    }

    public Slot getSlotid() {
        return slotid;
    }

    public void setSlotid(Slot slotid) {
        this.slotid = slotid;
    }

    public Subject getSubid() {
        return subid;
    }

    public void setSubid(Subject subid) {
        this.subid = subid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
}
