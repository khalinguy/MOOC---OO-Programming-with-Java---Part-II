/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.HashMap;
/**
 *
 * @author Linh Nguyen
 */
public class PromissoryNote {
    private HashMap<String, Double> note;
    
    public PromissoryNote(){
        this.note = new HashMap<String, Double>();
    }
    public void setLoan(String toWhom, double value){
        note.put(toWhom, value);
    }
    public double howMuchIsTheDebt(String key){
        if (note.containsKey(key)){
            return note.get(key);
        }
        return 0;
    }
}
