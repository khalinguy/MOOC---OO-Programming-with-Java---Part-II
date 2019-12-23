/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clicker.applicationlogic;

/**
 *
 * @author Linh Nguyen
 */
public class PersonalCalculator implements Calculator {
    private int count;
            
    public PersonalCalculator(){
        count = 0;
    }
    @Override
    public int giveValue() {
        return count;
    }

    @Override
    public void increase() {
        count++;
    }
    
}
