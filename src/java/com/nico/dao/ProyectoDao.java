/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nico.dao;

import com.nico.model.Proyectos;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author nicoc
 */
@Stateless
public class ProyectoDao implements ProyectoDaoLocal {

    @PersistenceContext(name = "CRUDWebApplicationPU")
    private EntityManager em;
    
    @Override
    public void addProyectos(Proyectos proy) {
        em.persist(proy);
    }
    

    @Override
    public void editProyectos(Proyectos proy) {
        em.merge(proy);
    }

    @Override
    public void deleteProyectos(int proy) {
        em.remove(getProyectos(proy));
    }

    @Override
    public Proyectos getProyectos(int proy) {
        return em.find(Proyectos.class,proy);
    }
    
    @Override
    public List<Proyectos> getAllProyectos() {
        return em.createNamedQuery("Proyectos.getAll").getResultList();
    }
}
