/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nico.controller;

import com.nico.dao.CourseDaoLocal;
import com.nico.model.Course;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nicoc
 */
@WebServlet(name = "CourseServlet", urlPatterns = {"/CourseServlet"})
public class CourseServlet extends HttpServlet {
@EJB
private CourseDaoLocal courseDao;



    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        String codeStr = request.getParameter("code");
        int code = 0;
        if(codeStr!= null && !codeStr.equals(""))
            code = Integer.parseInt(codeStr);
        String name = request.getParameter("name");
        String n_creditsStr = request.getParameter("n_credits");
        int n_credits=0;
        if(n_creditsStr!= null && !n_creditsStr.equals(""))
            n_credits = Integer.parseInt(n_creditsStr);
        String semesterStr = request.getParameter("semester");
        int semester=0;
        if(semesterStr!= null && !semesterStr.equals(""))
             semester = Integer.parseInt(semesterStr);
        String n_AStudentsStr = request.getParameter("n_AStudents");
        int n_AStudents =0;
        if(n_AStudentsStr!= null && !n_AStudentsStr.equals(""))
             n_AStudents = Integer.parseInt(n_AStudentsStr);
        
        Course course = new Course(code,name,n_credits,semester,n_AStudents);
        if("AddC".equalsIgnoreCase(action)){
            courseDao.addCourse(course);
        }else if("EditC".equalsIgnoreCase(action)){
            courseDao.editCourse(course);
        }else if("DeleteC".equalsIgnoreCase(action)){
            courseDao.deleteCourse(code);
        }else if("SearchC".equalsIgnoreCase(action)){
            course = courseDao.getCourse(code);
        }
        
        request.setAttribute("course", course);
        request.setAttribute("allCourse",courseDao.getAllCourses());
        request.getRequestDispatcher("studentinfo.jsp").forward(request, response);
        
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
        processRequest(request, response);
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
