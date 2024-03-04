/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class Subject {
    private String subid, subname;
    private int credit, term;
    private String Prerequisite, department;

    public Subject() {
    }

    public Subject(String subid, String subname, int credit, String Prerequisite, int term, String department) {
        this.subid = subid;
        this.subname = subname;
        this.credit = credit;
        this.Prerequisite = Prerequisite;
        this.term = term;
        this.department = department;
    }

    public String getSubid() {
        return subid;
    }

    public void setSubid(String subid) {
        this.subid = subid;
    }

    public String getSubname() {
        return subname;
    }

    public void setSubname(String subname) {
        this.subname = subname;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public String getPrerequisite() {
        return Prerequisite;
    }

    public void setPrerequisite(String Prerequisite) {
        this.Prerequisite = Prerequisite;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    
    
}
