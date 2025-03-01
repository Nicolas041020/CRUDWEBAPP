/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nico.dao;

import com.nico.model.Course;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author nicoc
 */
@Local
public interface CourseDaoLocal {

    void addCourse(Course course);

    void editCourse(Course course);

    void deleteCourse(int code);

    Course getCourse(int code);

    List<Course> getAllCourses();

    
}
