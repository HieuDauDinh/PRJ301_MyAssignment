/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DT;

import java.util.List;
import java.time.LocalDate;

/**
 *
 * @author DELL
 */
public class DayDT {
    private int week;
    private String content;
    private List<SessionDT> list;

    public DayDT() {
    }

    public DayDT(int week, String content, List<SessionDT> list) {
        this.week = week;
        this.content = content;
        this.list = list;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<SessionDT> getList() {
        return list;
    }

    public void setList(List<SessionDT> list) {
        this.list = list;
    }
    
    //Lấy khoảng cách ngày khi đã được chọn
    public boolean isSelected(LocalDate date){
        for (SessionDT s : list) {
            if(s.getDate().isEqual(date)){
                return true;
            }
        }
        return false;
    }
            
}
