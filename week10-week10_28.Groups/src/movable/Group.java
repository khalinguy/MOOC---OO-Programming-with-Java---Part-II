/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movable;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Linh Nguyen
 */
public class Group implements Movable {
    private List<Movable> group;
    
    public Group (){
        group = new ArrayList<Movable>();
    }
    
    @Override
    public String toString(){
        String string = "";
        for(Movable movable: group){
            string += movable;
            string += "\n";
        }
        
        return string;
    }
    
    public void addToGroup(Movable movable){
        group.add(movable);
        
    }
    @Override
    public void move(int dx, int dy) {
        for (Movable movable: group){
            movable.move(dx, dy);
        }
    }
    
}
