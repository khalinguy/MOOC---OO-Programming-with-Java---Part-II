/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.util.Set;
import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;

/**
 *
 * @author Linh Nguyen
 */
public class PersonalMultipleEntryDictionary implements MultipleEntryDictionary {
    private Map<String, Set<String>> dict;
    
    public PersonalMultipleEntryDictionary(){
        dict = new HashMap<String,Set<String>>();
    }
    @Override
    public void add(String word, String entry) {
        
        if(!dict.containsKey(word)){
            this.dict.put(word, new HashSet<String>());
        }
        this.dict.get(word).add(entry);
    }

    @Override
    public Set<String> translate(String word) {
        if (!this.dict.containsKey(word)){
            return null;
        }
        return this.dict.get(word);
    }

    @Override
    public void remove(String word) {
        this.dict.remove(word, dict.get(word));
    }
    
}
