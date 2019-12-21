/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boxes;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Linh Nguyen
 */
public class MaxWeightBox extends Box{
    private List<Thing> box;
    private int maxWeight;
    
    public MaxWeightBox (int maxWeight){
        box = new ArrayList<Thing>();
        this.maxWeight = maxWeight;
    }
    @Override
    public void add(Thing thing) {
        int boxWeight = 0;
        for (Thing stuff: box){
            boxWeight += stuff.getWeight();
        }
        if (thing.getWeight() + boxWeight <= this.maxWeight){
            box.add(thing);  
        }
        
    }
    
    @Override
    public boolean isInTheBox(Thing thing) {
        return box.contains(thing);
    }
    
}
