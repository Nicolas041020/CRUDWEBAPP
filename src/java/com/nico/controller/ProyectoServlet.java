/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nico.controller;

import com.nico.dao.ProyectoDaoLocal;
import com.nico.model.Proyectos;
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
@WebServlet(name = "ProyectoServlet", urlPatterns = {"/ProyectoServlet"})
public class ProyectoServlet extends HttpServlet {

  @EJB
  private ProyectoDaoLocal proyectoDao;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String action = request.getParameter("action");
             String proyectoIdStr = request.getParameter("proyectoId");
            int proyectoId =0;
            if (proyectoIdStr!= null && !proyectoIdStr.equals("")) {
            proyectoId = Integer.parseInt(proyectoIdStr);
        }
            String nombre = request.getParameter("nombre");
            String descripcion = request.getParameter("descripcion");
            String localidad = request.getParameter("localidad");
            String presupuesto = request.getParameter("presupuesto");
            String n_habitantesStr = request.getParameter("n_habitantes");
            int n_habitantes =0;
        if (n_habitantesStr!= null && !n_habitantesStr.equals("")) {
            n_habitantes = Integer.parseInt(n_habitantesStr);
        }
       
        Proyectos proy = new Proyectos(proyectoId,nombre,descripcion,localidad,presupuesto,n_habitantes);
        if("Add".equalsIgnoreCase(action)){
            proyectoDao.addProyectos(proy);
        }else if("Edit".equalsIgnoreCase(action)){
            proyectoDao.editProyectos(proy);
        }else if("Delete".equalsIgnoreCase(action)){
            proyectoDao.deleteProyectos(proyectoId);
        }else if("Search".equalsIgnoreCase(action)){
            proy = proyectoDao.getProyectos(proyectoId);
        }
        request.setAttribute("proyectos", proy);
        request.setAttribute("allProy",proyectoDao.getAllProyectos());
        request.getRequestDispatcher("proyectinfo.jsp").forward(request, response);
    
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
