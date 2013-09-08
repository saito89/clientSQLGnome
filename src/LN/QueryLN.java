/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LN;

import DA.*;
import EN.*;

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
}
