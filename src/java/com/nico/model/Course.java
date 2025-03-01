/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nico.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@NamedQueries(@NamedQuery(name="Course.getAll",query="SELECT e FROM Course e"))
public class Course {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column
    private int code;
    @Column
    private String name;
    @Column
    private int n_credits;
    @Column
    private int semester;
    @Column
    private int n_AStudents;
    
    @ManyToMany(mappedBy="Courses")
    private List<Student> Students;

    public Course(int code, String name, int n_credits, int semester, int n_AStudents) {
        this.code = code;
        this.name = name;
        this.n_credits = n_credits;
        this.semester = semester;
        this.n_AStudents = n_AStudents;
        
    }
    
    public Course(){}

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getN_credits() {
        return n_credits;
    }

    public void setN_credits(int n_credits) {
        this.n_credits = n_credits;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public int getN_AStudents() {
        return n_AStudents;
    }

    public void setN_AStudents(int n_AStudents) {
        this.n_AStudents = n_AStudents;
    }

    

    public List<Student> getStudents() {
        return Students;
    }

    public void setStudents(List<Student> Students) {
        this.Students = Students;
    }
    
    
    
    
    
}
