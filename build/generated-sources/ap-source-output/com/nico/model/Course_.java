package com.nico.model;

import com.nico.model.Student;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2025-02-24T18:51:25")
@StaticMetamodel(Course.class)
public class Course_ { 

    public static volatile SingularAttribute<Course, Integer> code;
    public static volatile ListAttribute<Course, Student> Students;
    public static volatile SingularAttribute<Course, String> name;
    public static volatile SingularAttribute<Course, Integer> semester;
    public static volatile SingularAttribute<Course, Integer> n_AStudents;
    public static volatile SingularAttribute<Course, Integer> n_credits;

}