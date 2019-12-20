/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
/**
 *
 * @author Linh Nguyen
 */
public class Plane {
    private String planeID;
    private int capacity;
   
    public Plane(String planeID, int capacity){
        this.planeID = planeID;
        this.capacity = capacity;
    }
    
    public String getID (){
        return planeID;
    }
    
    public int getCapacity(){
        return this.capacity;
    }
    
    public String toString(){
        return this.planeID + " (" + this.capacity + " ppl)";
    }
}
