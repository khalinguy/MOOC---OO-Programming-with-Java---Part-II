/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moving.logic;
import java.util.List;
import java.util.ArrayList;
import moving.domain.Thing;
import moving.domain.Box;
/**
 *
 * @author Linh Nguyen
 */
public class Packer {
    private int boxesVolume;
    
    public Packer (int boxesVolume){
        this.boxesVolume = boxesVolume;
    }
    
    public List<Box> packThings (List<Thing> things){
        int sum = 0;
        int boxcount = 0;
        List<Box> Boxes = new ArrayList<Box>();
        Box firstbox = new Box(this.boxesVolume);
        Boxes.add(firstbox);
        
        for(int i = 0; i < things.size(); i ++){
            sum += things.get(i).getVolume();
            if (sum > boxesVolume){
                sum = things.get(i).getVolume();
                Box newbox = new Box(this.boxesVolume);
                newbox.addThing(things.get(i));
                Boxes.add(newbox);
                boxcount++;
            } else if (sum <= boxesVolume){
                Boxes.get(boxcount).addThing(things.get(i));
                      
            }

        }
        
        return Boxes;
    }
}
