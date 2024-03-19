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
    private String comment;
    private String semester;

    public Grade(int gid, Exam eid, Student stuid, double score, String comment, String semester) {
        this.gid = gid;
        this.eid = eid;
        this.stuid = stuid;
        this.score = score;
        this.comment = comment;
        this.semester = semester;
    }
    
    

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }

    public Grade() {
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

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }
    
    
}
