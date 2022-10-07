
package Controlador;

import Modelo.Conector;
import Modelo.Huesped;
import Modelo.Reserva;
import Modelo.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConsultasSQL extends Conector{
    Conector creandoConexion = new Conector();
    public int idReserva;
    
     
    public boolean loginUsuario(User usr) throws ClassNotFoundException{
        Connection con=creandoConexion.CrearConexion();
        PreparedStatement ps = null;
        ResultSet rs=null;       
        
        String sql = "SELECT usuario,clave FROM usuarios WHERE usuario = ?";                  
        try {
            ps = con.prepareStatement(sql);            
            ps.setString(1, usr.getUsuario());            
            rs = ps.executeQuery();
            System.out.println("usuario de la BD: "+rs.getString(1));
            System.err.println("clave de la BD: "+rs.getInt(2));

            if (rs.next()) {                
                if(usr.getClave().equals(rs.getString(2))){
                    usr.setUsuario(rs.getString(1));                    
                    return true;
                }else{
                    return false;
                }
            }
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(ConsultasSQL.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
            return false;
        } 
           
    }
    public boolean registarReserva(Reserva reserva){
        Connection con = CrearConexion();
        PreparedStatement ps = null;
        ResultSet rs= null;
        
        String sql = "INSERT INTO reservas (valor,medio_pago)VALUES(?,?)";
        try {
            ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,reserva.getValor());
            ps.setString(2, reserva.getFormaPago());
            
            ps.executeUpdate();
            
            try {
                rs= ps.getGeneratedKeys();
                while (rs.next()) {
                System.out.println("El ID "+rs.getInt(1));
                reserva.setId(rs.getInt(1));
                idReserva = reserva.getId();
                    System.out.println(idReserva);
            }
                
            } catch (Exception e) {
            }        
            
            return true;
        } catch (SQLException e) {
            System.out.println("el error es "+e);
            return false;
        }
        
    }
    public boolean registrarHuesped(Huesped huesped){
        Connection con = CrearConexion();
        PreparedStatement ps = null;
        ResultSet rs=null;
        
        String sql = "INSERT INTO huespedes (nombre,apellido,nacionalidad)VALUES(?,?,?)";
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1,huesped.getNombre());
            ps.setString(2,huesped.getApellido());
            ps.setString(3,huesped.getNacionalidad());
            
            ps.executeUpdate();
            
            
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(ConsultasSQL.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public String consultarId(String texto){
             return texto;
    }

}
