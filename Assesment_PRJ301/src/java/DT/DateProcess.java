/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DT;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;
import java.util.Locale;
/**
 *
 * @author DELL
 */
public class DateProcess {
    public static List<DayDT> DateOfYear(int year){
        List<DayDT> list = new ArrayList<>();
        int week = 1;
        Calendar c = Calendar.getInstance();
        c.clear();
        c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        c.set(Calendar.DAY_OF_WEEK_IN_MONTH, 1);
        c.set(Calendar.WEEK_OF_YEAR, week);
        c.set(Calendar.YEAR, year);
        LocalDate date = LocalDate.of(year, 1, c.get(Calendar.DAY_OF_WEEK));
        int FirstWeekOfyear = date.get(WeekFields.of(Locale.US).weekOfWeekBasedYear());
        int WeekOfYear = 0;
        do{
            LocalDate firstDayofWeek = date.with(WeekFields.of(Locale.ENGLISH).dayOfWeek(), c.get(Calendar.DAY_OF_WEEK));
            date = date.plusWeeks(1);
            LocalDate lastDayOfWeek = date.with(WeekFields.of(Locale.ENGLISH).dayOfWeek(),1L);
            //Format Date to Date
            StringBuilder rs = new StringBuilder();
            rs.append(firstDayofWeek.format(DateTimeFormatter.ofPattern("dd/MM")));
            rs.append(" to ");
            rs.append(lastDayOfWeek.format(DateTimeFormatter.ofPattern("dd/MM")));
            DayDT dayDT = new DayDT(WeekOfYear, rs.toString(), DateInRange(firstDayofWeek, lastDayOfWeek));
            list.add(dayDT);
            WeekOfYear++;
            System.out.println(rs.toString());
        }while((WeekOfYear = date.get(WeekFields.of(Locale.ENGLISH).weekOfWeekBasedYear())) != FirstWeekOfyear);
        return list;
    }

    
    //Hàm set ngày bắt đầu đến ngày kết thúc
    public static List<SessionDT> DateInRange(LocalDate start, LocalDate end){
        List<SessionDT> total = new ArrayList<>();
        while(!start.isAfter(end)){
            total.add(new SessionDT(start, null));
            start = start.plusDays(1);
        }
        return total;
    }
    
    
    //Hàm lấy tuần khi đã đc chọn
    public static int Weeks(List<DayDT> list, LocalDate date){
        for (DayDT dt : list) {
            if(dt.isSelected(date)){
                return dt.getWeek();
            }
        }
        return -1; // nếu 0 tìm thấy ngày trong danh sách khi đã được chọn
    }
    
    
    //Lấy vị trí ngày trong tuần 
    public static int IndexByWeeks(List<DayDT> list, int week){
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getWeek() == week){
                return i;
            }
        }
        return -1;// nếu 0 tìm thấy ngày trong danh sách khi đã được chọ
    }
    
}
