/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import Config.Conexion;
import Modelo.Trabajador;
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
public class TrabajadorDAO {
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public Trabajador obtenetTrabajador(int idTrabajador){
        
        try {
            String sql = "SELECT * FROM trabajador WHERE idtrabajador = ?";
            
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setInt(1, idTrabajador);
            rs = ps.executeQuery();
            
            rs.next();
            
            Trabajador trabajador = new Trabajador(idTrabajador, rs.getInt("dni"), 
                    rs.getString("nombre"), rs.getString("tipo_trabajador"));
            
            return trabajador;
            
        } catch (SQLException ex) {
            Logger.getLogger(TrabajadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;

    }
    
    public String listarTrabajadores(){
       
    
        String selectTrabajador = "";

        try {
            String sql = "SELECT idtrabajador, dni FROM trabajador order by dni";
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                selectTrabajador += "<option value='" + rs.getString(1) + "' >" + rs.getString(2) + "</option>";
            }

        } catch (SQLException e) {
            System.out.println("Error crear la sentencia "
                    + e.getMessage());
        }
        
        return selectTrabajador;
    }
}
