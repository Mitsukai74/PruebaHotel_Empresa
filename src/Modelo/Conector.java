
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Conector {
    private static final String url="jdbc:mysql://localhost:3306/hotelAlura";
    private static final String usuario="root";
    private static final String clave="";
     
    
    public Connection CrearConexion(){
        Connection con = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url,usuario,clave);
            if (con != null)
                {
                    System.out.println("Conexión ok");
                }
                else
                {System.out.println("Conexión fallida");}
        } catch (SQLException ex) {
            Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con; 
    }
    
}
