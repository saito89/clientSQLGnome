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
public class SQLDA 
{
    static Connection con;
    
    public static Connection Open(String _host,int _port,String _dataBaseName, String _user, String _password) throws SQLException, Exception
    {
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String address = "jdbc:sqlserver://"+_host+":"+_port+";databaseName="+_dataBaseName;
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
