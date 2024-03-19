/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class Group {
    private String gid, gname;
    private Subject subid;
    private Lecturer lid;
    private String semester;

    public Group(String gid, String gname, Subject subid, Lecturer lid, String semester) {
        this.gid = gid;
        this.gname = gname;
        this.subid = subid;
        this.lid = lid;
        this.semester = semester;
    }

    public Group() {
    }
    
    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public Subject getSubid() {
        return subid;
    }

    public void setSubid(Subject subid) {
        this.subid = subid;
    }

    public Lecturer getLid() {
        return lid;
    }

    public void setLid(Lecturer lid) {
        this.lid = lid;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }
    
    
}
