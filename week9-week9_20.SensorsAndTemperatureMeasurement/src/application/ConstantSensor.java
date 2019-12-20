/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

/**
 *
 * @author Linh Nguyen
 */
public class ConstantSensor implements Sensor {
    private int temp;
    
    public ConstantSensor(int temp){
        this.temp = temp;
    }
    public void on(){
        
    }
    
    public void off(){
        
    }
    
    public boolean isOn(){
        return true;
    }
    public int measure(){
        return this.temp;
    }
}
