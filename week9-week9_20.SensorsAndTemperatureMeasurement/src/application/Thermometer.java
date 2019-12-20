/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;
import java.util.Random;
/**
 *
 * @author Linh Nguyen
 */
public class Thermometer implements Sensor {
    private Random random;
    private boolean switching;
    
    public Thermometer(){
        random = new Random();
        switching = false;
    }
    public int measure (){
        switching = true;
        return random.nextInt(61) - 30;
    }
    public void on(){
        switching = true;
    }
    
    public void off(){
        switching = false;
    }
    public boolean isOn(){
        return switching;
    }
    
}
