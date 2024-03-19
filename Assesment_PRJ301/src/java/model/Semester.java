/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class Semester {
    private String semID;
    private String semName;

    public Semester() {
    }

    public Semester(String semID, String semName) {
        this.semID = semID;
        this.semName = semName;
    }

    public String getSemID() {
        return semID;
    }

    public void setSemID(String semID) {
        this.semID = semID;
    }

    public String getSemName() {
        return semName;
    }

    public void setSemName(String semName) {
        this.semName = semName;
    }
    
    
}
