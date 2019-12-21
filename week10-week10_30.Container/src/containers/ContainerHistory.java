/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package containers;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Linh Nguyen
 */
public class ContainerHistory {

    private List<Double> history;

    public ContainerHistory() {
        history = new ArrayList<Double>();
    }

    public void add(double situation) {
        history.add(situation);
    }

    public void reset() {
        history.clear();
    }

    public String toString() {
        return "" + history;
    }

    public double maxValue() {
        double max = history.get(0);
        if (history.isEmpty()) {
            return 0;
        }
        for (double cap : history) {
            if (cap > max) {
                max = cap;
            }
        }
        return max;
    }

    public double minValue() {
        double min = history.get(0);
        if (history.isEmpty()) {
            return 0;
        }
        for (double cap : history) {
            if (cap < min) {
                min = cap;
            }
        }
        return min;
    }
    
    public double average(){
        if (history.isEmpty()){
            return 0;
        }
        double sum = 0.0;
        for (double vol: history){
            sum += vol;
        }
        
        double avg = (double) sum/history.size();
        return avg;
    }
    
    public double greatestFluctuation(){
        if (history.isEmpty() || history.size() == 1){
            return 0;
        }
        double gap = Math.abs(history.get(0)-history.get(1));
        for (int i = 0; i < history.size()-1; i ++){
            double num = Math.abs(history.get(i) - history.get(i+1));
            if (num > gap){
                gap = num;
            }
        }
        
        return gap;
        
    }
    
    public double variance(){
        if (history.isEmpty() || history.size() == 1){
            return 0;
        }
        
        double variance = 0.0;
        
        for (double vol: history){
            variance += Math.pow(vol-average(), 2.0);
        }
        
        return variance/(history.size() - 1);
    }
}
