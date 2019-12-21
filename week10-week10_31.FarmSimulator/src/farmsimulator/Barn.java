/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmsimulator;
import java.util.Collection;
/**
 *
 * @author Linh Nguyen
 */
public class Barn{
    private MilkingRobot robot;
    private BulkTank tank;
    
    public Barn (BulkTank tank){
        robot = new MilkingRobot();
        this.tank = tank;
    }
    
    public BulkTank getBulkTank(){
        return this.tank;
    }
    
    public void installMilkingRobot(MilkingRobot milkingRobot){
        robot.setBulkTank(this.tank);
    }
    
    public void takeCareOf (Cow cow) throws Exception{
        robot.milk(cow);
    }
    public void takeCareOf (Collection<Cow> cows) throws Exception{
        for (Milkable cow: cows){
            robot.milk(cow);
        }
    }
    
    public String toString(){
        return this.tank.toString();
    }


}
