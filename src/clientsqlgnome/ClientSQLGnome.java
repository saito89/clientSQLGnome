/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clientsqlgnome;

import LN.*;

/**
 *
 * @author erick
 */
public class ClientSQLGnome {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        try
        {
            QueryLN.ExecuteQuery("select top 1 * from Banco");
            String prueba = "hola";
        }
        catch(Exception e)
        {
            throw e;
        }
        
        
    }
}
