/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author Linh Nguyen
 */
public class UserInterface {
    private Scanner reader;
    private ArrayList<Plane> planes;
    private ArrayList<Flight> flights;
    
    public UserInterface(){
        this.reader = new Scanner(System.in);
        this.planes = new ArrayList<Plane>();
        this.flights = new ArrayList<Flight>();
    }
    
    public void start(){
        while (true){
            System.out.print("Airport panel\n" +
                                "--------------------\n" +
                                "\n" +
                                "Choose operation:\n" +
                                "[1] Add airplane\n" +
                                "[2] Add flight\n" +
                                "[x] Exit\n"
                                 + "> ");
            
            String input1 = reader.nextLine();
            if (input1.equalsIgnoreCase("1")){
                addPlane();
            } else if (input1.equalsIgnoreCase("2")){
                addFlight();
            } else if(input1.equalsIgnoreCase("x")){
                break;
            }
            
        }
        
        while (true){
            System.out.print("Flight service\n" +
                                "------------\n" +
                                "\n" +
                                "Choose operation:\n" +
                                "[1] Print planes\n" +
                                "[2] Print flights\n" +
                                "[3] Print plane info\n" +
                                "[x] Quit\n"
                                + "> ");
            String input2 = reader.nextLine();
            if (input2.equalsIgnoreCase("1")){
                printPlanes();
            } else if (input2.equalsIgnoreCase("2")){
                printFlights();
            } else if (input2.equalsIgnoreCase("3")){
                printPlaneInfo();
            } 
            else if(input2.equalsIgnoreCase("x")){
                break;
            }
        }
    }
    
    public void addPlane(){
        System.out.print("Give plane ID: ");
        String planeID = reader.nextLine();
        System.out.print("Give plane capacity: ");
        int capacity = Integer.parseInt(reader.nextLine());
        planes.add (new Plane(planeID, capacity));
    }
    
    public void addFlight(){
        System.out.print("Give plane ID: ");
        String planeID = reader.nextLine();
        Plane pla = getPlane(planeID);
        System.out.print("Give departure airport code: ");
        String original = reader.nextLine();
        System.out.println("Give destination airport code: ");
        String destination = reader.nextLine();
        
        flights.add (new Flight(pla, original, destination));
    }
    
    public void printPlanes(){
        for (Plane plane: planes){
            System.out.println(plane);
        }
    }
    
    public void printFlights(){
        for (Flight flight: flights){
            System.out.println(flight);
        }
    }
    
    public void printPlaneInfo(){
        System.out.print("Give plane ID:");
        String planeID = reader.nextLine();
        System.out.println(getPlane(planeID));
    }
    
    private Plane getPlane(String word){
        for (Plane pl: planes){
            if(pl.getID().equalsIgnoreCase(word)){
                return pl;
            }
        }
        return null;
    }
}
