/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.baitapbuoi3;

import com.mycompany.baitapbuoi3.Model.Student;
import com.mycompany.baitapbuoi3.Service.StudentList;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpCookie;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author LENOVO
 */
public class HomePage extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
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
            out.println("<title>Servlet HomePage</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HomePage at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                StudentList studentList = new StudentList();
                   
                ArrayList<Student> students = studentList.getStudents();
                
                response.setContentType("text/html;charset=UTF-8");
            
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            out.println("Username: " + session.getAttribute("user") );
            
            out.println("<form action = './Logout' method = 'GET'>" +
                        "<button type = 'submit'>Log Out</button></form>");
            
            out.println("<form action = './Search' method = 'GET'>"
                    + " <br> <input type = 'text' name = 'search' />"
                    + "<button type = 'submit'>Search</button></form>");
            
            
            out.println("<table border = '1'>"
                    + "<tr> "
                    + "<th>ID</th>"
                    + "<th>Name</th>"
                    + "<th>Password</th>"
                    + "<th>Email</th>"
                    + "<th>Phone</th>"
                    + "<th>Address</th>"
                    + "<th>Gender</th>"
                    + "<th>Created_at</th>"
                    + "</tr>");


            for (Student stu: students) {
                 out.println("<tr>"
                        + "<td>" + stu.getId() + "</td>"
                        + "<td>" + stu.getName() + "</td>"
                        + "<td>" + stu.getPassword() + "</td>"
                        + "<td>" + stu.getEmail() + "</td>"
                        + "<td>" + stu.getPhone() + "</td>"
                        + "<td>" + stu.getAddress() + "</td>"
                        + "<td>" + stu.getGender() + "</td>"
                        + "<td>" + stu.getCreated_at() + "</td>"        
                        + "</tr>");
           }
        out.println("</table>" );

        }
            
        
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
               processRequest(request, response);
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
