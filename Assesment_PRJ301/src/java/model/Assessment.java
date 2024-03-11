/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class Assessment {
    private String aid;
    private Subject suid;
    private double weight;
    private String name;

    public Assessment() {
    }

    public Assessment(String aid, Subject suid, double weight, String name) {
        this.aid = aid;
        this.suid = suid;
        this.weight = weight;
        this.name = name;
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public Subject getSuid() {
        return suid;
    }

    public void setSuid(Subject suid) {
        this.suid = suid;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
