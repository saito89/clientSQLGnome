/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DA;

import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author root
 */
public class QueryDA 
{
    public static ArrayList<ArrayList<String>> ExcecuteQuery(String _query) throws Exception
    {
        try
        {
            Connection conn = SQLDA.Open("190.7.192.3", 1433, "CCMPAY", "sa", "D4t42012");
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(_query);
            ArrayList<ArrayList<String>> list = new ArrayList<>();
            ResultSetMetaData metaData = rs.getMetaData();
            int columns = metaData.getColumnCount();
            ArrayList<String> listColumnsNames = new ArrayList<>();
            
            for(int j = 1; j <= columns; j++)
            {                
                String columnName = metaData.getColumnName(j).toString();
                listColumnsNames.add(columnName);
            }
            
            list.add(listColumnsNames);
            
            while(rs.next())
            {
                ArrayList<String> listRow = new ArrayList<>();
                for(int i = 1; i <= columns; i++)
                {
                    String cell = rs.getObject(i).toString();
                    listRow.add(cell);
                }
                list.add(listRow);
            }
            
            
            conn.close();
            
            return list;
            
        }
        catch(Exception e)
        {
            throw e;
        }
    }
    
}
