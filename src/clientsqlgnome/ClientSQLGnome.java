/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clientsqlgnome;
import DA.SQLDA;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author erick
 */
public class ClientSQLGnome {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        try
        {
            Connection con = SQLDA.Open("190.7.192.3", 1433, "CCMPAY", "sa", "D4t42012");
            con.close();
            String prueba = "hola";
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        
        
    }
}
