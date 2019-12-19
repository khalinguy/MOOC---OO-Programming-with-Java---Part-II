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
public class Container {
    private int maxWeight;
    private ArrayList<Suitcase> container;
    
    public Container(int maxWeight){
        this.maxWeight = maxWeight;
        container = new ArrayList<Suitcase>();
    }
    
    public void addSuitcase (Suitcase suitcase){
        if (totalWeight()+ suitcase.totalWeight() <= maxWeight){
            container.add(suitcase);
        }
    }
    
    public int totalWeight (){
        int weight = 0;
        for (Suitcase suitcase: container){
            weight += suitcase.totalWeight();
        }
        return weight;
    }
    public void printThings(){
        for (Suitcase suitcase: container){
            suitcase.printThings();
        }
    }
    
    public String toString(){
        return container.size() + " suitcases" + " (" + totalWeight() + " kg)";
    }
    
}
