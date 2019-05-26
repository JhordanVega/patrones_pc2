<%@page import="ModeloDAO.ContratoDAO"%>
<%@page import="Modelo.Trabajador"%>
<%@page import="ModeloDAO.TrabajadorDAO"%>

<%    
    
    int idTrabajador = Integer.valueOf(request.getParameter("idTrabajador"));
    int anio = Integer.valueOf(request.getParameter("anio"));
    
    TrabajadorDAO trabajadorDAO = new TrabajadorDAO();
    Trabajador trabajador = trabajadorDAO.obtenetTrabajador(idTrabajador);
    
    ContratoDAO contratoDAO = new ContratoDAO(); 
       
            
%>
