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
public class Flight {
    private Plane plane;
    private String original;
    private String destination;
    
    public Flight(Plane plane, String original, String destination){
        this.plane = plane;
        this.original = original;
        this.destination = destination;
    }
    
    public String toString(){
        return this.plane + " (" + this.original + "-" + this.destination + ")";
    }
}
