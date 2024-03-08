/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import DT.DateProcess;
import DT.DayDT;
import DT.SessionDT;
import dal.SessionDBContext;
import dal.SlotDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import model.Account;
import model.Session;
import model.Slot;

@WebServlet(name="WeeklyTimeTableController", urlPatterns={"/weeklyTable"})
public class WeeklyTimeTableController extends HttpServlet {
   
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        SlotDBContext slot = new SlotDBContext();
        HttpSession session = request.getSession();
        SessionDBContext se = new SessionDBContext();
        DayDT dt = new DayDT();
        String yearS = request.getParameter("year");
        String username = request.getParameter("lid");
        Account acc = (Account)session.getAttribute("acc");
        session.setAttribute("username", username);
        List<Session> listSession = (List<Session>)session.getAttribute("ses");
        List<Session> listSessionStu = (List<Session>)session.getAttribute("sesStu");
        for (Session ss : listSessionStu) {
            boolean isTk = se.getPresentOnSeidAndSid(ss.getSeid(), acc.getUsername()).isIsPresent();
            ss.setIsTaken(isTk);
        }
        //Xác định năm hiện tại
        int year = Year.now().getValue();
        if(yearS != null){
            year = Integer.parseInt(yearS);
        }
        List<DayDT> list = DateProcess.DateOfYear(year);
        String weekS = request.getParameter("DateRange");
        //Xác định tuần hiện tại
        int week = DateProcess.Weeks(list, LocalDate.now());
        if(weekS != null){
            week = Integer.parseInt(weekS);
        }
        //Lấy danh sách các ngày từ SessionDT tại các vị trí index
        int index = DateProcess.IndexByWeeks(list, week);
        List<SessionDT> dts = list.get(index).getList();
        String getDateNow = dt.getCurrentDate();
              
      //  List<Session> listSession = se.getAllSession();
        List<Slot> s = slot.getAllSlot();
        List<Session> listSessionByLid = se.getSessionByLid(username);
        request.setAttribute("slot", s);
        request.setAttribute("selectedWeek", week);
        request.setAttribute("selectedYear", year);
        request.setAttribute("listDayDT", list);
        request.setAttribute("dayweek", dts);
        request.setAttribute("listSession", listSession);
        request.setAttribute("listSessionStu", listSessionStu);
        request.setAttribute("listSessionByLid", listSessionByLid);
        request.setAttribute("dateNow", getDateNow);
        request.getRequestDispatcher("WeeklyTimeTable.jsp").forward(request, response);
    } 

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
