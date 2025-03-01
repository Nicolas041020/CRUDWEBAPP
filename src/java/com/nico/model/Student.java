/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nico.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author nicoc
 */
@Entity
@Table
@NamedQueries(@NamedQuery(name="Student.getAll",query="SELECT e FROM Student e"))
public class Student implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column
    private int studentId;
    @Column
    private String firstname;
    @Column
    private String lastname;
    @Column
    private int yearLevel;
    @ManyToMany()
    @JoinTable(
            name ="ST_COURSES",
            joinColumns = @JoinColumn(name="St_ID",referencedColumnName="studentId"),
            inverseJoinColumns=@JoinColumn(name="code",referencedColumnName="code"))
    private List<Course> Courses;
    
    
   
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getYearLevel() {
        return yearLevel;
    }

    public void setYearLevel(int yearLevel) {
        this.yearLevel = yearLevel;
    }

    public List<Course> getCourses() {
        return Courses;
    }

    public void setCourses(List<Course> Courses) {
        this.Courses = Courses;
    }

    public Student(int studentId, String firstname, String lastname, int yearLevel) {
        this.studentId = studentId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.yearLevel = yearLevel;
        
    }

    
    
    public Student(){}
    
}
