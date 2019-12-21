/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package containers;

/**
 *
 * @author Linh Nguyen
 */
public class ProductContainerRecorder extends ProductContainer {
    private ContainerHistory containerhistory;
    
    
    public ProductContainerRecorder (String productName, double capacity, double initialVolume){
        super(productName, capacity);
        super.addToTheContainer(initialVolume);
        containerhistory = new ContainerHistory();
        containerhistory.add(initialVolume);
        
    }
    
    public String history(){
        return this.containerhistory.toString();
    }
    
    public  void addToTheContainer(double amount){
        super.addToTheContainer(amount);
        this.containerhistory.add(super.getVolume());
    }
    public double takeFromTheContainer(double amount){
        double preVol = super.getVolume();
        super.takeFromTheContainer(amount);
        this.containerhistory.add(super.getVolume());
        return preVol - super.getVolume();
    }
    
    public void printAnalysis(){
        System.out.println("Product: " + this.getName());
        System.out.println("History: " + this.history());
        System.out.println("Greatest product amount: " + this.containerhistory.maxValue());
        System.out.println("Smallest product amount: " + this.containerhistory.minValue());
        System.out.println("Average: " + this.containerhistory.average());
        System.out.println("Greatest change: " + this.containerhistory.greatestFluctuation());
        System.out.println("Variance: " + this.containerhistory.variance());
    }
    
}
