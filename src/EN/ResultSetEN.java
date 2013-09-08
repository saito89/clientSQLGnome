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
    private ArrayList<String> headers;
    private ArrayList<ArrayList<String>> listValues;

    /**
     * @return the headers
     */
    public ArrayList<String> getHeaders() {
        return headers;
    }

    /**
     * @param headers the headers to set
     */
    public void setHeaders(ArrayList<String> headers) {
        this.headers = headers;
    }

    /**
     * @return the listValues
     */
    public ArrayList<ArrayList<String>> getListValues() {
        return listValues;
    }

    /**
     * @param listValues the listValues to set
     */
    public void setListValues(ArrayList<ArrayList<String>> listValues) {
        this.listValues = listValues;
    }
}
