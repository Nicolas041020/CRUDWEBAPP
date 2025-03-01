<%-- 
    Document   : studentinfo
    Created on : Feb 24, 2025, 12:24:43 PM
    Author     : nicoc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Information</title>
    </head>
    <body>
        <h1>Student Information</h1>
        <form action="./StudentServlet" method="POST">
            <table>
            <tr>
                <td>Student ID</td>
                <td><input type="text" name = "studentId" value="${student.studentId}"/></td>
            </tr>
            <tr>
                <td>First Name</td>
                <td><input type="text" name = "firstname" value="${student.firstname}"/></td>
            </tr>
            <tr>
                <td>Last Name</td>
                <td><input type="text" name = "lastname" value="${student.lastname}"/></td>
            </tr>
            <tr>
                <td>Year Level</td>
                <td><input type="text" name = "yearLevel" value="${student.yearLevel}"/></td>
            </tr>
            <tr>
                <td colspan ="2">
                    <input type="submit" name="action" value ="Add"/>
                    <input type="submit" name="action" value ="Edit"/>
                    <input type="submit" name="action" value ="Delete"/>
                    <input type="submit" name="action" value ="Search"/>
                </td>
            </tr>
            
        </table>
        </form>
        <br>
        <table border ="1">
           
                <th>ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Year Level</th>
                
                 <c:forEach items="${allStudent}" var="stud">
                <tr>
                    <td>${stud.studentId}</td>
                    <td>${stud.firstname}</td>
                    <td>${stud.lastname}</td>
                    <td>${stud.yearLevel}</td>
                </tr>
            </c:forEach>
        </table>
        
        <h1>Course Information</h1>
        <form action="./CourseServlet" method="POST">
            <table>
            <tr>
                <td>Course code</td>
                <td><input type="text" name = "code" value="${course.code}"/></td>
            </tr>
            <tr>
                <td>Name</td>
                <td><input type="text" name = "name" value="${course.name}"/></td>
            </tr>
            <tr>
                <td>Number of Credits</td>
                <td><input type="text" name = "n_credits" value="${course.n_credits}"/></td>
            </tr>
            <tr>
                <td>Semester</td>
                <td><input type="text" name = "semester" value="${course.semester}"/></td>
            </tr>
            <tr>
                <td>Number of admitted students</td>
                <td><input type="text" name = "n_AStudents" value="${course.n_AStudents}"/></td>
            </tr>
            
            <tr>
                <td colspan ="2">
                    <input type="submit" name="action" value ="AddC"/>
                    <input type="submit" name="action" value ="EditC"/>
                    <input type="submit" name="action" value ="DeleteC"/>
                    <input type="submit" name="action" value ="SearchC"/>
                </td>
            </tr>
            </table>
        </form>
        <br>
        <br>
        <table border ="1">
           
                <th>Code</th>
                <th>Name</th>
                <th>Credits</th>
                <th>Semester</th>
                <th>Admitted Students</th>
                
                 <c:forEach items="${allCourse}" var="course">
                <tr>
                    <td>${course.code}</td>
                    <td>${course.name}</td>
                    <td>${course.n_credits}</td>
                    <td>${course.semester}</td>
                    <td>${course.n_AStudents}</td>
                </tr>
            </c:forEach>
              </table>
    </body>
</html>
