/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmsimulator;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Linh Nguyen
 */
public class Farm implements Alive {
    private String name;
    private Barn barn;
    private List<Cow> cows;
    
    public Farm (String name, Barn barn){
        this.name = name;
        this.barn = barn;
        cows = new ArrayList<Cow>();
    }
    
    public void addCow(Cow cow){
        cows.add(cow);
    }
    public String getOwner(){
        return name;
    }
    
    @Override
    public void liveHour() {
        for (Cow cow: cows){
            cow.liveHour();
        }
    }
    
    public void manageCows() throws Exception{
        barn.takeCareOf(cows);
    }
    public void installMilkingRobot(MilkingRobot milkingRobot){
        barn.installMilkingRobot(milkingRobot);
    }
    
    public String printCows(){
        String print = "";
        for (Cow cow: cows){
            print += "        " + cow.toString();
            print += "\n";
        }
        
        return print;
    }
    
    public String toString(){
        return "Farm owner: " + this.name + "\nBarn bulk tank: " + barn.toString() + "\nAnimals:\n" + printCows();
    }
}
