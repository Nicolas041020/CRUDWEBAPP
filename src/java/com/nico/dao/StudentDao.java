/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nico.dao;

import com.nico.model.Course;
import com.nico.model.Student;
import java.util.Arrays;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author nicoc
 */
@Stateless
public class StudentDao implements StudentDaoLocal {
    @PersistenceContext(name = "CRUDWebApplicationPU")
    private EntityManager em;
    
    @Override
    public void addStudent(Student student) {
        em.persist(student);
    }
    

    @Override
    public void editStudent(Student student) {
        em.merge(student);
    }

    @Override
    public void deleteStudent(int studentId) {
        em.remove(getStudent(studentId));
    }

    @Override
    public Student getStudent(int studentId) {
        return em.find(Student.class,studentId);
    }

    @Override
    public List<Student> getAllStudents() {
        return em.createNamedQuery("Student.getAll").getResultList();
    }

    @Override
    public void removeStudent(int studentId, int code) {
        try{
            Student student = em.find(Student.class, studentId);
            Course course = em.find(Course.class,code);
            if (student!=null && course != null) {
                student.getCourses().remove(course);
                course.getStudents().remove(student);
                em.merge(student);
                em.merge(course);
                em.flush();
                
            }
        }catch(Exception e){
        e.printStackTrace();
                }
    }

    @Override
    public List<Object[]> Dataset() {
       List<Object[]> arr = em.createNativeQuery(
            "SELECT s.studentId, s.firstname AS student_name, c.code, c.name AS course_name " +
            "FROM ST_COURSES sc " +
            "JOIN Student s ON s.studentId = sc.St_ID " +
            "JOIN Course c ON c.code = sc.code"
        ).getResultList();
       
     
       return arr;
    }
    
    
    
    
}
