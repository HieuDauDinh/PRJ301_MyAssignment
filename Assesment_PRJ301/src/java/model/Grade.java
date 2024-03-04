/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class Grade {
    private int gid;
    private Exam eid;
    private Student stuid;
    private double score;

    public Grade() {
    }

    public Grade(int gid, Exam eid, Student stuid, double score) {
        this.gid = gid;
        this.eid = eid;
        this.stuid = stuid;
        this.score = score;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public Exam getEid() {
        return eid;
    }

    public void setEid(Exam eid) {
        this.eid = eid;
    }

    public Student getStuid() {
        return stuid;
    }

    public void setStuid(Student stuid) {
        this.stuid = stuid;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
    
    
}
