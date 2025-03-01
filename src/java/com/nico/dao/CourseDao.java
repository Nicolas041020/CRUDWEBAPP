/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nico.dao;

import com.nico.model.Course;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author nicoc
 */
@Stateless
public class CourseDao implements CourseDaoLocal {
    @PersistenceContext(name = "CRUDWebApplicationPU")
    private EntityManager em;
    
    @Override
    public void addCourse(Course course) {
        em.persist(course);
    }
    
    @Override
    public void editCourse(Course course) {
        em.merge(course);
        System.out.println("eliminando");
    }

    @Override
    public void deleteCourse(int code) {
        em.remove(getCourse(code));
    }

    @Override
    public Course getCourse(int code) {
        return em.find(Course.class,code);
    }

    @Override
    public List<Course> getAllCourses() {
        return em.createNamedQuery("Course.getAll").getResultList();
    }

    

    
    
    
    
}
