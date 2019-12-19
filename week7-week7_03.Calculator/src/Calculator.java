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
public class Calculator {
    private final Reader reader;
    private int count;
    
    public Calculator(){
        this.reader = new Reader();
        this.count = count;
    }
    public void start() {
        while (true) {
            System.out.print("command: ");
            String command = reader.readString();
            if (command.equals("end")) {
                break;
            }

            if (command.equals("sum")) {
                sum();
                count++;
            } else if (command.equals("difference")) {
                difference();
                count++;
            } else if (command.equals("product")) {
                product();
                count++;
            }
        }

        statistics();
    }
    private void sum (){
        int sum = inputNumbers().get(0) + inputNumbers().get(0);
        System.out.println("sum of the values " + sum);
    }    
    private void difference (){
        int difference = inputNumbers().get(0) - inputNumbers().get(0);
        System.out.println("difference of the values" + difference);
    }        
    
    private void product (){
        int product = inputNumbers().get(0) * inputNumbers().get(0);
        System.out.print("product of the values" + product);
    } 
    
    private void statistics(){
        System.out.println("Calculations done " + count);
    }
    
    private ArrayList<Integer> inputNumbers(){
        int inputcount = 0;
        ArrayList<Integer> input = new ArrayList<Integer>();
        if (inputcount % 2 == 0){
            System.out.print("value1: ");
            int value1 = reader.readInteger();
            input.add(value1);
        } else {
            System.out.println("value2: ");
            int value2 = reader.readInteger();
            input.add(value2);
        }
        inputcount++;
        return input;
    }
}
