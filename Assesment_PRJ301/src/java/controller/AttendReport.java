/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import controller.authetication.BaseRequiredAuthenticationController;
import dal.ErollmentDBContext;
import dal.GroupDBContext;
import dal.SessionDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import model.Account;
import model.Attendance;
import model.Semester;
import model.Session;

/**
 *
 * @author Admin
 */
@WebServlet(name = "AttendReport", urlPatterns = {"/report"})
public class AttendReport extends BaseRequiredAuthenticationController {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response, Account account)
            throws ServletException, IOException {
        String gid = request.getParameter("id");
        String sid = request.getParameter("sid");
        String semid = request.getParameter("semesid");
        GroupDBContext db = new GroupDBContext();
        ErollmentDBContext erll = new ErollmentDBContext();
        List<Session> list = db.getSessionByGid(gid);
        if(semid == null ||semid.isEmpty()){
            semid = "SP24";
        }else{
             semid  = request.getParameter("semesid");
         }
        SessionDBContext dbs = new SessionDBContext();
        List<Session> listStu = dbs.getSessionBySidAndGid(sid, gid);
        String lid = request.getParameter("lid");
        List<Session> listS = dbs.distinctGidByLid(lid);
        List<Semester> semester = erll.getAllSemester();
        List<Session> listGroupStu = dbs.getGidBySidToMarkAttend(sid, semid);
        ArrayList<Attendance> atten = new ArrayList<>();
        for (Session ses : listStu) {
            Attendance a = dbs.getAttendencesByLessionAndStuid(ses.getSeid(), sid);
            atten.add(a);
        }
        request.setAttribute("group", listS);
        request.setAttribute("list", list);
        request.setAttribute("listAttStu", listStu);
        request.setAttribute("listGroupStu", listGroupStu);
        request.setAttribute("atten", atten);
        request.setAttribute("semester", semester);
        request.getRequestDispatcher("attendedReport.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response, Account account)
            throws ServletException, IOException {
        processRequest(request, response, account);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response, Account account)
            throws ServletException, IOException {
        processRequest(request, response, account);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
