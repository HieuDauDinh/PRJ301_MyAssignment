/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import controller.authetication.BaseRequiredAuthenticationController;
import dal.ErollmentDBContext;
import dal.GradeDBContext;
import dal.SessionDBContext;
import dal.SubjectDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.Account;
import model.Assessment;
import model.Grade;
import model.Semester;
import model.Session;

/**
 *
 * @author Admin
 */
@WebServlet(name="ShowGrade", urlPatterns={"/showgrade"})
public class ShowGrade extends BaseRequiredAuthenticationController {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response, Account account)
    throws ServletException, IOException {
        String sub_raw = request.getParameter("subid");
        String sid_raw = request.getParameter("sid");
        ErollmentDBContext erll = new ErollmentDBContext();
   
        SubjectDBContext subj = new SubjectDBContext();
         String semid = request.getParameter("semesid");
         if(semid == null ||semid.isEmpty()){
            semid = "SP24";
        }else{
             semid  = request.getParameter("semesid");
         }
         
        List<Assessment> asses = subj.getAssesmentBySubid(sub_raw);
        request.setAttribute("asses", asses);
        SessionDBContext dbs = new SessionDBContext();
        GradeDBContext db = new GradeDBContext();
        List<Grade> listGrade = db.getGradeByStuidAndSubid(sid_raw, sub_raw);
        List<Session> listGrbySiStuid = dbs.getGidBySidToMarkAttend(sid_raw, semid);
        List<Semester> semester = erll.getAllSemester();
        request.setAttribute("listGrade", listGrade);
        request.setAttribute("listGroupStu", listGrbySiStuid);
        request.setAttribute("semester", semester);
        
        request.getRequestDispatcher("markReport.jsp").forward(request, response);
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
