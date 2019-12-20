/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author Linh Nguyen
 */
public class AverageSensor implements Sensor {
    private List<Sensor> avgSensor;
    private List<Integer> readings;
    
    public AverageSensor(){
        avgSensor = new ArrayList<Sensor>();
        readings = new ArrayList<Integer>();
    }
    
    public void on(){
        for (Sensor sensor: avgSensor){
            sensor.on();
        }
    }
    public void off(){
        for (Sensor sensor: avgSensor){
            sensor.off();
        }
    }
    public boolean isOn(){
                
        for (Sensor sensor: avgSensor){
            if(!sensor.isOn()){
                return false;
            }
        }
        return true;
    }
    
    public int measure(){
        if(!isOn() || avgSensor.isEmpty()){
            throw new IllegalStateException();
        }
        int sum = 0;
        for(Sensor sensor: avgSensor){
            sum += sensor.measure();
        }
        int average = sum/avgSensor.size();
        readings.add(average);
        return average;
    }
    
    public void addSensor(Sensor additional){
        avgSensor.add(additional);
    }
    
    public List<Integer> readings(){
        return readings;
    }
}
