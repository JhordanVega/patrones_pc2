<%-- 
    Document   : ReporteTrabajador
    Created on : 26/05/2019, 01:15:40 AM
    Author     : Administrador
--%>

<%@ include file="../Logica/Logica_ReporteTrabajador.jsp" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@ include file="../tpl/incluirLibrerias.jsp" %>
    </head>
    <body>
        <br><br>
        <h1 class="text-center">Reporte del trabajador <%=trabajador.getNombre()%> - <%=anio%> </h1>
        <br>
        <div class="container">
            
            <div class="row">
                
                <div class="offset-md-1 col-md-10">

                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th class="text-center" scope="col">MES</th>
                                <th class="text-center" scope="col">NOMBRE DE LA FILIAL</th>
                                <th class="text-center" scope="col">TIPO DE TRABAJO</th>
                                <th class="text-center" scope="col">HORAS TRABAJADAS</th>
                                <th class="text-center" scope="col">PAGO POR HORA</th>
                                <th class="text-center" scope="col">SUELDO</th>
                            </tr>
                        </thead>

                        <tbody>
                            <%= contratoDAO.mostrarReporte(idTrabajador, anio)%> 
                        </tbody>
                    </table>    

                    <a class="btnVolver" href="index.jsp">Volver</a>

                </div>
            </div> 
        </div>
    </body>
</html>
