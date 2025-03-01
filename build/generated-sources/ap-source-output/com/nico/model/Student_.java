package com.nico.model;

import com.nico.model.Course;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2025-02-24T18:51:25")
@StaticMetamodel(Student.class)
public class Student_ { 

    public static volatile SingularAttribute<Student, Integer> studentId;
    public static volatile SingularAttribute<Student, String> firstname;
    public static volatile SingularAttribute<Student, Integer> yearLevel;
    public static volatile ListAttribute<Student, Course> Courses;
    public static volatile SingularAttribute<Student, String> lastname;

}