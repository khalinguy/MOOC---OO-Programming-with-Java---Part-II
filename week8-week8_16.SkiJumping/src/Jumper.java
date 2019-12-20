/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Map;
import java.util.HashMap;
/**
 *
 * @author Linh Nguyen
 */
public class Jumper implements Comparable <Jumper> {
    private String name;
    private Map<Integer, Points> points;
    
    public Jumper(String name){
        this.name = name;
        this.points = new HashMap<Integer, Points>();
    }
    public void jump(int round) {
        this.points.put(round, new Points());
    }

    public String getName(){
        return this.name;
    }
    public Points getPoints(int round){
        return this.points.get(round);
    }
    public int getTotalPoints(){
        int totalPoints = 0;
        for (Points point: this.points.values()){
            totalPoints += point.validPoints();
        }
        return totalPoints;
    }
    
    public String printJumperResults() {
        return this.name + " (" + this.getTotalPoints() + " points)";
    }
    
    public String printLengths() {
        String printLengths = "";
        for (Points points : this.points.values()) {
            printLengths += " " + points.getLength() + " m,";
        }
  
        printLengths = printLengths.substring(0, printLengths.length() - 1);
        return printLengths;
    }

    public int compareTo(Jumper jumper){
        return this.getTotalPoints() - jumper.getTotalPoints();
    }
    
    public String toString(){
        String results = "           " + this.printJumperResults() + "\n            jump lengths:" + this.printLengths();
        return results;
    }
}
