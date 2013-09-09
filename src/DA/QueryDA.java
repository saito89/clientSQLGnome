/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DA;

import java.sql.*;
import java.util.ArrayList;
import EN.*;
import java.io.FileInputStream;
import java.util.Properties;
/**
 *
 * @author root
 */
public class QueryDA 
{
    /**
     * This method executes the query provided
     * @param _query
     * @return
     * @throws Exception 
     */
    public static ResultSetEN ExecuteQuery(String _query) throws Exception
    {
        try
        {
            Properties prop = LoadPropertiesFile();
            Connection conn = SQLDA.Open(prop.getProperty("host"),Integer.parseInt(prop.getProperty("port")), prop.getProperty("dataBaseName"), prop.getProperty("user"), prop.getProperty("password"));
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
    /**
     * This method loads the property file named config.properties
     * @return
     * @throws Exception 
     */
    public static Properties LoadPropertiesFile() throws Exception
    {
        try
        {
            Properties prop = new Properties();
            prop.load(new FileInputStream("config.properties"));
            return prop;            
        }
        catch(Exception e)
        {
            throw e;
        }
    }
    /**
     * This method gets the tables from the selected schema
     * @return
     * @throws Exception 
     */
    public static ArrayList<String> GetDBTables() throws Exception
    {
        try
        {
            
            Properties prop = LoadPropertiesFile();
            Connection conn = SQLDA.Open(prop.getProperty("host"),Integer.parseInt(prop.getProperty("port")), prop.getProperty("dataBaseName"), prop.getProperty("user"), prop.getProperty("password"));
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM information_schema.tables");
            ArrayList<String> listTables = new ArrayList<>();
            while(rs.next())
            {
                listTables.add(rs.getString("TABLE_NAME"));
            }
            return listTables;
        }
        catch(Exception e)
        {
            throw e;
        }
    }
    
}
