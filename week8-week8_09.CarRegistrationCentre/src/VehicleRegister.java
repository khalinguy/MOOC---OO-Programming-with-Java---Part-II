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
public class VehicleRegister {
    private final HashMap<RegistrationPlate, String> vehicle;
    
    public VehicleRegister(){
        vehicle = new HashMap<RegistrationPlate, String> ();
    }
    
    public boolean add(RegistrationPlate plate, String owner){
        if(vehicle.get(plate) == null){
            vehicle.put(plate, owner);
            return true;
        }
        
        return false;
    }
    
    public String get(RegistrationPlate plate){
        if (vehicle.containsKey(plate)){
            return vehicle.get(plate);
        }
        return null;
    }
    
    public boolean delete (RegistrationPlate plate){
        if (vehicle.containsKey(plate)){
            vehicle.remove(plate);
            return true;
        }
        
        return false;
    }
    
    public void printRegistrationPlates(){
        for (RegistrationPlate key : vehicle.keySet()) {
            System.out.println(key);
        }
    }
    
    public void printOwners(){
        ArrayList<String> owner = new ArrayList<String>();
        for (RegistrationPlate key: vehicle.keySet()){
            String ownerName = vehicle.get(key);
            if (!owner.contains(ownerName)){
                owner.add(ownerName);
            }
        }
        
        for(String name: owner){
            System.out.println(name);
        }
    }
    
}
