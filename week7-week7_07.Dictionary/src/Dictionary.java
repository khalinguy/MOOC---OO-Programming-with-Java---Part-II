/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.HashMap;
import java.util.ArrayList;
/**
 *
 * @author Linh Nguyen
 */
public class Dictionary {
    private HashMap<String, String> dict;
    
    public Dictionary(){
        dict = new HashMap<String, String> ();
    }
    public void add (String word, String translation){
        dict.put(word, translation);
    }
    
    public String translate (String word){
        if (dict.containsKey(word)){
            return dict.get(word);
        }
        return null;
    }
    
    public int amountOfWords(){
        return dict.size();
    }
    
    public ArrayList<String> translationList(){
        ArrayList<String> list = new ArrayList<String>();
        for (String key: dict.keySet()){
            list.add(key + " = " + dict.get(key));
        }
        return list;
    }
    
}
