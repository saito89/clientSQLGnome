/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LN;

import DA.*;
import EN.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author root
 */
public class QueryLN 
{
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
}
