/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LN;

import DA.*;
import EN.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Properties;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author root
 */
public class QueryLN 
{
    /**
     * This method executes the given query and returns the resultset
     * @param _query
     * @return
     * @throws Exception 
     */
    public static ResultSetEN ExecuteQuery(String _query) throws Exception
    {
        try
        {
            return QueryDA.ExecuteQuery(_query);
        }
        catch(Exception e)
        {
            throw e;
        }
    }
    /**
     * This method populates the Table with the given resultset
     * @param _resultSetEN
     * @return 
     */
    public static DefaultTableModel CreateModel(ResultSetEN _resultSetEN)
    {
        try
        {
            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(_resultSetEN.getHeaders());
            for(int j = 0; j < _resultSetEN.getListValues().size();j++)
            {                
                model.addRow(_resultSetEN.getListValues().get(j));
            }
            model.fireTableDataChanged();
            return model;
        }
        catch(Exception e)
        {
            throw e;
        }
    }
    /**
     * This method creates the property file where the connection information will be provided
     * @param _host
     * @param _port
     * @param _dataBaseName
     * @param _user
     * @param _password
     * @throws Exception 
     */
    public static void CreatePropertiesFile(String _host,int _port,String _dataBaseName, String _user, String _password) throws Exception
    {
        try
        {
            Properties prop = new Properties();
            prop.setProperty("host", _host);
            prop.setProperty("port",Integer.toString(_port));
            prop.setProperty("dataBaseName", _dataBaseName);
            prop.setProperty("user", _user);
            prop.setProperty("password", _password);
            prop.store(new FileOutputStream("config.properties"), null);
            
        }
        catch(Exception e)
        {
            throw e;
        }
    }
    
    public static String[] GetDBTables() throws Exception
    {
        try
        {
            ArrayList<String> listTables = QueryDA.GetDBTables();
            String[] returnList = new String[listTables.size()];
            int counter = 0;
            for(int i = 0; i < listTables.size();i++)
            {
                returnList[counter] = listTables.get(i);
                counter++;
            }
            return returnList;
        }
        catch(Exception e)
        {
            throw e;
        }
    }
}
