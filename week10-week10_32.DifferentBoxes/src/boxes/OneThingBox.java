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
public class OneThingBox extends Box{
    private List<Thing> box;
    public OneThingBox(){
        box = new ArrayList<Thing>();
    }

    @Override
    public void add(Thing thing) {
        if (box.size()<1){
            box.add(thing);
        }
    }

    @Override
    public boolean isInTheBox(Thing thing) {
        return box.contains(thing);
    }
    
}
