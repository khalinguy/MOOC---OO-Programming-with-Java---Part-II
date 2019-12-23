/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Linh Nguyen
 */
public class SavageCalculator {
    private int value;
    
    public SavageCalculator(){
        this.value = value;
    }
    
    public int getValue(){
        return value;
    }
    
    public void increase(int input) {
        this.value += input;
       
    }


    public void decrease(int input) {
        this.value -= input;
        
    }


    public void setZero() {
        this.value = 0;
    }
}
