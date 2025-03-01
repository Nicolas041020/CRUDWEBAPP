<%-- 
    Document   : proyectinfo
    Created on : Feb 28, 2025, 11:06:01 PM
    Author     : nicoc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Proyecto</title>
    </head>
    <body>
        <h1>Proyecto</h1>
        <form action="./ProyectoServlet" method="POST">
            <table>
            <tr>
                <td>Proyecto ID</td>
                <td><input type="text" name = "proyectoId" value="${proyectos.proyectoId}"/></td>
            </tr>
            <tr>
                <td>Nombre</td>
                <td><input type="text" name = "nombre" value="${proyectos.nombre}"/></td>
            </tr>
            <tr>
                <td>Descripcion</td>
                <td><input type="text" name = "descripcion" value="${proyectos.descripcion}"/></td>
            </tr>
            <tr>
                <td>Localidad</td>
                <td><input type="text" name = "localidad" value="${proyectos.localidad}"/></td>
            </tr>
            <tr>
                <td>Presupuesto</td>
                <td><input type="text" name = "presupuesto" value="${proyectos.presupuesto}"/></td>
            </tr>
            <tr>
                <td>numero de habitantes</td>
                <td><input type="text" name = "n_habitantes" value="${proyectos.n_habitantes}"/></td>
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
           
                <th>Proyecto ID</th>
                <th>Nombre</th>
                <th>Descripcion</th>
                <th>Localidad</th>
                <th>Presupuesto</th>
                <th>numero de habitantes</th>
                
                
                 <c:forEach items="${allProy}" var="proy">
                <tr>
                    <td>${proy.proyectoId}</td>
                    <td>${proy.nombre}</td>
                    <td>${proy.descripcion}</td>
                    <td>${proy.localidad}</td>
                    <td>${proy.presupuesto}</td>
                    <td>${proy.n_habitantes}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
