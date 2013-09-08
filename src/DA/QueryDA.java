/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DA;

import java.sql.*;
import java.util.ArrayList;
import EN.*;
/**
 *
 * @author root
 */
public class QueryDA 
{
    public static ResultSetEN ExecuteQuery(String _query) throws Exception
    {
        try
        {
            Connection conn = SQLDA.Open("190.7.192.3", 1433, "CCMPAY", "sa", "D4t42012");
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(_query);
            ArrayList<String[]> list = new ArrayList<>();
            ResultSetMetaData metaData = rs.getMetaData();
            int columns = metaData.getColumnCount();
            String[] listColumnsNames = new String[columns];
            
            int cou = 0;
            for(int j = 1; j <= columns; j++)
            {                
                listColumnsNames[cou] = metaData.getColumnName(j).toString();
                cou++;
            }
            
            
            while(rs.next())
            {
                String [] listRow = new String[columns];
                int count = 0;
                for(int i = 1; i <= columns; i++)
                {
                    listRow[count] = rs.getObject(i).toString();
                    count++;
                }
                list.add(listRow);
            }
            
            
            conn.close();
            ResultSetEN resulSetEN = new ResultSetEN();
            resulSetEN.setHeaders(listColumnsNames);
            resulSetEN.setListValues(list);
            return resulSetEN;
            
        }
        catch(Exception e)
        {
            throw e;
        }
    }
    
}
