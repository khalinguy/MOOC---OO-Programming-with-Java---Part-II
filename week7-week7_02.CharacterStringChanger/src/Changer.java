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
public class Changer {
    private ArrayList<Change> changer;
    public Changer(){
        changer = new ArrayList<Change>();
    }
    public void addChange(Change change){
        changer.add(change);
    }
    public String change(String characterString){
        for (Change change:changer){
            characterString = change.change(characterString);
        }
        return characterString;
    }
}
