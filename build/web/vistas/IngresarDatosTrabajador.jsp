<%-- 
    Document   : IngresarDatosTrabajador
    Created on : 26/05/2019, 01:13:41 AM
    Author     : Administrador
--%>



<%@ include file="../Logica/Logica_IngresarDatosTrabajador.jsp" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EMPRESA DE CALZADO</title>
        <%@ include file="../tpl/incluirLibrerias.jsp" %>
        
    </head>
    <body>
        <br><br>
        <h1 class="text-center">EMPRESA DE CALZADO</h1>
        <h2 class="text-center">VER REPORTE DE TRABAJADOR</h2>
        
        <div class="container">
            <div class="row">
                
                <div class="marco offset-md-2 col-md-8 offset-lg-3 col-lg-6">
            
                    
                    <form method="get" action="Controlador">
                        
                        <label>DNI del trabajador: </label>
                        <select required name="idTrabajador">
                            <%=trabajadorDAO.listarTrabajadores() %>
                        </select>
                        <br>
                        
                        <label>Año: </label>
                        <input required type="number" name="anio"  min="1800" max="2500">
                        <br>
                        <br>
                        <button class="btnVolver" name="accion" value="reporteTrabajador" type="submit">Enviar</button>
                    </form>
                </div>
            </div>
        </div>        
                
    </body>
</html>
