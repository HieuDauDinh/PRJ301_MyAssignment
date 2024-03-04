/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.AccountDBContext;
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
import model.Session;

/**
 *
 * @author Admin
 */
@WebServlet(name="Function", urlPatterns={"/function"})
public class Function extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Function</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Function at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
       
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String user_raw = request.getParameter("username");
        String pass_raw = request.getParameter("password");
        AccountDBContext db = new AccountDBContext();
        Account acc = db.getByUsernamePassword(user_raw, pass_raw);
        HttpSession session = request.getSession();
        SessionDBContext se = new SessionDBContext();
        List<Session> listSession = se.getSessionByLid(user_raw);
        List<Session> listSessionStu = se.getSessionBySid(user_raw);
         
        session.setAttribute("ses", listSession);
        session.setAttribute("sesStu", listSessionStu);
        if(acc!=null){
            if(acc.getRole() == 1){            
                session.setAttribute("acc", acc);
                response.sendRedirect("functionLectuter.jsp");
            }else{
                session.setAttribute("acc", acc);
                response.sendRedirect("functionStudent.jsp");
            }
        }else{
            request.setAttribute("err", "username or password invalid!!! Please try again.");
            request.getRequestDispatcher("loginc.jsp").forward(request, response);
        }
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
