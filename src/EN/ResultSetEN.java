/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EN;

import java.util.ArrayList;

/**
 *
 * @author root
 */
public class ResultSetEN 
{
    //The column headers that the result set will return
    private String[] headers;
    //The values that the result set will return
    private ArrayList<String[]> listValues;

    /**
     * @return the headers
     */
    public String[] getHeaders() {
        return headers;
    }

    /**
     * @param headers the headers to set
     */
    public void setHeaders(String[] headers) {
        this.headers = headers;
    }

    /**
     * @return the listValues
     */
    public ArrayList<String[]> getListValues() {
        return listValues;
    }

    /**
     * @param listValues the listValues to set
     */
    public void setListValues(ArrayList<String[]> listValues) {
        this.listValues = listValues;
    }
}
