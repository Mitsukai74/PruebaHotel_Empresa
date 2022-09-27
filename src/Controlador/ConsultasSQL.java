
package Controlador;

import Modelo.Conector;
import Modelo.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConsultasSQL {
    Conector creandoConexion = new Conector();
    
     
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

}
