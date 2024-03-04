/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;


/**
 *
 * @author Admin
 */
public class Erollment {
    private String eid;
    private String gid;
    private List<Student> stuid;

    public Erollment() {
    }

    public Erollment(String eid, String gid, List<Student> stuid) {
        this.eid = eid;
        this.gid = gid;
        this.stuid = stuid;
    }

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    public List<Student> getStuid() {
        return stuid;
    }

    public void setStuid(List<Student> stuid) {
        this.stuid = stuid;
    }
    
    
}
