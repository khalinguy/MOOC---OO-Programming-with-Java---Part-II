/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moving.domain;

import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author Linh Nguyen
 */
public class Box implements Thing {
    private int maxCapacity;
    private List<Thing> list;
    
    public Box(int maximumCapacity){
        maxCapacity = maximumCapacity;
        list = new ArrayList<Thing>();
    }
    
    @Override
    public int getVolume(){
        int volume = 0;
        for (Thing thing: list){
            volume += thing.getVolume();
        }
        return volume;
    }
    
    public boolean addThing(Thing thing){
        if (getVolume() + thing.getVolume() <= maxCapacity){
            list.add(thing);
            return true;
        }
        
        return false;
    }
    
    @Override
    public String toString(){
        return "things in the box: " + getVolume();
    }
    
    
}
