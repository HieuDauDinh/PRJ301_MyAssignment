/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class Room {
    private String rid, rname, rbuilding;

    public Room() {
    }

    public Room(String rid, String rname, String rbuilding) {
        this.rid = rid;
        this.rname = rname;
        this.rbuilding = rbuilding;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public String getRbuilding() {
        return rbuilding;
    }

    public void setRbuilding(String rbuilding) {
        this.rbuilding = rbuilding;
    }
    
    
}
