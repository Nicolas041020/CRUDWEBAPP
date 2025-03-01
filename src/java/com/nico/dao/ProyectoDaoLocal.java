/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nico.dao;

import com.nico.model.Proyectos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author nicoc
 */
@Local
public interface ProyectoDaoLocal {
    
    public void addProyectos(Proyectos proy);
    
    public void editProyectos(Proyectos proy);
    
    public void deleteProyectos(int proy);
    
    public Proyectos getProyectos(int proy);
    
    public List<Proyectos> getAllProyectos();
}
