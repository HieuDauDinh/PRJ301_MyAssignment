/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import controller.authetication.BaseRequiredAuthenticationController;
import dal.ErollmentDBContext;
import dal.GroupDBContext;
import dal.StudentDBContext;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import model.Account;
import model.Group;
import model.Session;
import model.Student;

/**
 *
 * @author Admin
 */
@WebServlet(name="ListStudentInGroup", urlPatterns={"/list"})
public class ListStudentInGroup extends BaseRequiredAuthenticationController {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response, Account account)
    throws ServletException, IOException {
        String gid = request.getParameter("gid");
        HttpSession ses = request.getSession();
        
        GroupDBContext dbs = new GroupDBContext();
        Group gr = dbs.getGroupByGid(gid);
        ErollmentDBContext db = new ErollmentDBContext();
        List<Student> student = db.getStudentByGid(gid);
        List<Student> stu = new ArrayList();
        StudentDBContext d = new StudentDBContext();
        for (Student student1 : student) {
            stu.add(d.getStudentByIDd(student1.getStuid()));
        }
        request.setAttribute("student", stu);
        request.setAttribute("group", gr);
        request.getRequestDispatcher("list.jsp").forward(request, response);
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
