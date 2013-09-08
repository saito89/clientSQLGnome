/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DA;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author erick
 */
public class SqlDA 
{
    static Connection con;
    
    public static Connection Connect(String _host,int _port,String _dataBaseName, String _user, String _password) throws SQLException
    {
        try
        {
            String address = "jdbc:derby://"+_host+":"+_port+"/"+_dataBaseName;
            con = DriverManager.getConnection(address, _user, _password);
            return con;
        }
        catch(Exception e)
        {
            throw e;
        }
    }
    
    public static void Close() throws SQLException
    {
        try
        {
            con.close();
        }
        catch(Exception e)
        {
            throw e;
        }
    }
}
