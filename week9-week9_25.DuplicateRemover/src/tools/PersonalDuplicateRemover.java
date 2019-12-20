/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.util.Set;
import java.util.HashSet;

/**
 *
 * @author Linh Nguyen
 */
public class PersonalDuplicateRemover implements DuplicateRemover {
    private Set<String> Stringlist;
    private int dupCount;
    
    public PersonalDuplicateRemover (){
        Stringlist = new HashSet<String>();
    }
    
    @Override
    public void add(String characterString) {
        if (!Stringlist.contains(characterString)){
            Stringlist.add(characterString);
        } else {
            dupCount ++;
        }
    }

    @Override
    public int getNumberOfDetectedDuplicates() {
        return dupCount;
    }

    @Override
    public Set<String> getUniqueCharacterStrings() {
        return Stringlist;
    }

    @Override
    public void empty() {
        Stringlist.removeAll(Stringlist);
        dupCount = 0;
    }
    
}
