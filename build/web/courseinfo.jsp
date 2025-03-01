<%-- 
    Document   : courseinfo
    Created on : Feb 24, 2025, 5:39:48 PM
    Author     : nicoc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Courses Management</title>
    </head>
    <body>
        <h1>Student Inscription</h1>
         <form action="./STCourseServlet" method="POST">
            <table>
            <tr>
                <td>Student ID</td>
                <td><input type="text" name = "studentId" value="${student.studentId}"/></td>
            </tr>
            <tr>
                <td>Course ID</td>
                <td><input type="text" name = "code" value="${course.code}"/></td>
            </tr>
            
                <td colspan ="2">
                    <input type="submit" name="action" value ="Add"/>
                    <input type="submit" name="action" value ="Delete"/>
                    <input type="submit" name="action" value ="Search"/>
                </td>
            </tr>
            
        </table>
        </form>
            <br>
        <h2>COURSES AND STUDENTS</h2>
    <table border="1">
        <tr>
            <th>Student ID</th>
            <th>Student Name</th>
            <th>Course ID</th>
            <th>Course Name</th>
        </tr>
        <c:forEach var="row" items="${studentsC}">
            <tr>
                <td>${row[0]}</td>  
                <td>${row[1]}</td>  
                <td>${row[2]}</td>  
                <td>${row[3]}</td>  
            </tr>
        </c:forEach>
        </table>
    </body>
</html>
