/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nico.controller;

import com.nico.dao.CourseDaoLocal;
import com.nico.dao.StudentDaoLocal;
import com.nico.model.Course;
import com.nico.model.Student;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nicoc
 */
@WebServlet(name = "STCourseServlet", urlPatterns = {"/STCourseServlet"})
public class STCourseServlet extends HttpServlet {

@EJB
private StudentDaoLocal studentDao;
@EJB
private CourseDaoLocal courseDao;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String studentIdStr = request.getParameter("studentId");
        int studentId =0;
        if (studentIdStr!= null && !studentIdStr.equals("")) {
            studentId = Integer.parseInt(studentIdStr);
        }
        String codeStr = request.getParameter("code");
        int code = 0;
        if(codeStr!= null && !codeStr.equals(""))
            code = Integer.parseInt(codeStr);
        Student student = studentDao.getStudent(studentId);
        Course course = courseDao.getCourse(code);
        
        if (student == null) {
             throw new ServletException("Estudiante con ID " + studentId + " no encontrado.");
            }
        if (course == null) {
            throw new ServletException("Curso con código " + code + " no encontrado.");
            }

        if("Add".equalsIgnoreCase(action)){
            student.getCourses().add(course);
            course.getStudents().add(student);
            studentDao.editStudent(student);
            courseDao.editCourse(course);
            
        }else if("Delete".equalsIgnoreCase(action)){
            studentDao.removeStudent(studentId, code);
           
        }else if("Search".equalsIgnoreCase(action)){
            
        }
        

        request.setAttribute("studentsC", studentDao.Dataset());
        request.getRequestDispatcher("courseinfo.jsp").forward(request, response);
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
