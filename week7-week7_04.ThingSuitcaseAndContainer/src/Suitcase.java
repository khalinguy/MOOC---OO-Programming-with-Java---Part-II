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
public class Suitcase {
    private final ArrayList<Thing> suitcase;
    private final int maximumWeight;

    public Suitcase(int maximumWeight){
        suitcase = new ArrayList<Thing>();
        this.maximumWeight = maximumWeight;
    }
    
    public void addThing(Thing thing){
        int weight = totalWeight();
        weight += thing.getWeight();
        if (weight <= this.maximumWeight){
            suitcase.add(thing);
        }
    }
    
    public int totalWeight(){
        int sum = 0;
        for (Thing thing: suitcase){
            sum += thing.getWeight();
        }
        return sum;
    }
    public String toString(){
        if (suitcase.size() == 0){
            return "empty " + "(" + totalWeight() + " kg)";
        } else if (suitcase.size() == 1){
            return suitcase.size() + " thing " + "(" + totalWeight() + " kg)";
        }
        
        return suitcase.size() + " things (" + totalWeight() + " kg)";
    }
    
    public void printThings(){
        for (Thing thing: suitcase){
            System.out.println(thing);
        }
    }
    
    public Thing heaviestThing(){
        Thing heaviest = null;
        if (suitcase.size() > 0){
            heaviest = suitcase.get(0);
            for (Thing thing: suitcase){
                if (heaviest.getWeight() < thing.getWeight()){
                    heaviest = thing;
                }
            }
        }
        return heaviest;
    }

}
