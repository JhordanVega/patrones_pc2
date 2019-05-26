/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import Config.Conexion;
import Modelo.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrador
 */
public class ContratoDAO {
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public String mostrarReporte(int idTrabajador, int anio){
        
        String tablaReporte = "";
        try {
            
            String sql = "SELECT "
                    + " ELT(MONTH(fecha), \"Enero\", \"Febrero\", \"Marzo\", \"Abril\", \"Mayo\", \"Junio\", \"Julio\", \"Agosto\", \"Septiembre\", \"Octubre\", \"Noviembre\", \"Diciembre\") as mes, "
                    + " empresa_filial.nombre, tipo_trabajo, horas_trabajadas, pago_por_hora, horas_trabajadas*pago_por_hora as sueldo "
                    + " FROM contrato INNER JOIN empresa_filial "
                    + " ON idempresa_filial = empresa_filial_idempresa_filial "
                    + " INNER JOIN trabajador "
                    + " ON idtrabajador = trabajador_idtrabajador "
                    + " WHERE trabajador_idtrabajador = ? "
                    + " AND YEAR(fecha) = ? ORDER BY mes ";
            
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setInt(1, idTrabajador);
            ps.setInt(2, anio);
            rs = ps.executeQuery();
            
            while(rs.next()){ 
                tablaReporte += ""
                + "<tr>"
                    + "<td class='text-center'>" + rs.getString("mes") + "</td>"
                    + "<td class='text-center'>" + rs.getString("empresa_filial.nombre") + "</td>"
                    + "<td class='text-center'>" + rs.getString("tipo_trabajo") + "</td>"
                    + "<td class='text-center'>" + Integer.valueOf(rs.getString("horas_trabajadas"))+ "</td>"
                    + "<td class='text-center'>" + Double.valueOf(rs.getString("pago_por_hora")) + "</td>"
                    + "<td class='text-center'>" + Double.valueOf(rs.getString("sueldo")) + "</td>"
                + "</tr>";
            } 
            
            return tablaReporte;
            
            
        } catch (SQLException e) {
            tablaReporte = "falló";
            return tablaReporte;
        }
        
    }
}
