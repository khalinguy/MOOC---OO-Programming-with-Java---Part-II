/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmsimulator;

/**
 *
 * @author Linh Nguyen
 */
public class BulkTank {
    private double capacity;
    private double volume;
    public BulkTank(){
        capacity = 2000;
        volume = 0;
    }
    
    public BulkTank(double capacity){
        this.capacity = capacity;
        volume = 0;
    }
    
    public double getCapacity(){
        return this.capacity;
    }
    
    public double getVolume(){
        return this.volume;
    }
    
    public double howMuchFreeSpace(){
        return this.capacity - this.volume;
    }
    
    public void addToTank(double amount){
        if (amount <= howMuchFreeSpace() && amount > 0){
            this.volume += amount;
        } else if (amount > howMuchFreeSpace()) {
            this.volume = this.capacity;
        }
    }
    
    public double getFromTank(double amount){
        double the = this.volume;
        if (amount > 0 && amount <= this.volume){
            this.volume -= amount;
        } else if (amount > this.volume){
            this.volume = 0;
        }
        return the;
    }
    
    @Override
    public String toString(){
        return "" + Math.ceil(volume) + "/" + Math.ceil(capacity);
    }
}
