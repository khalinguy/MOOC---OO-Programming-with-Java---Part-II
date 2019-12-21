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
public class BlackHoleBox extends Box{
    private List<Thing> box; 
    
    public BlackHoleBox(){
        box = new ArrayList<Thing>();
    }
    @Override
    public void add(Thing thing) {
        box.add(thing);
    }

    @Override
    public boolean isInTheBox(Thing thing) {
        return false;
    }
    
}
