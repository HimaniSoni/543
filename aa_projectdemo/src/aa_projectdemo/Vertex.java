/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aa_projectdemo;

import java.util.LinkedList;

/**
 *
 * @author Himani Soni
 */
public class Vertex {
    LinkedList incidentEdgeList;
    private Object data;              // an object associated with this vertex
    private Object name;              // a name associated with this vertex
    
    /**
     * Constructor that allows data and a name to be associated
     * with the vertex.
     * @param data     an object to be associated with this vertex
     * @param name     a name to be associated with this vertex
     */
    public Vertex(Object data, Object name) {
        this.data = data;
        this.name = name;
        this.incidentEdgeList = new LinkedList();
    }
    
    /**
     * Return the name associated with this vertex.
     * @return  the name of this vertex
     */
    public Object getName(){
        return this.name;
    }
    
    /**
     * Return the data associated with this vertex.
     * @return  the data of this vertex
     */
    public Object getData() {
        return this.data;
    }
    
    /**
     * Set the data associated with this vertex.
     * @param data  the data of this vertex
     */
    public void setData(Object data) {
        this.data = data;
    }
}
