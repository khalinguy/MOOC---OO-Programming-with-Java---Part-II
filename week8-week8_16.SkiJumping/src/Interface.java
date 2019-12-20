/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
/**
 *
 * @author Linh Nguyen
 */
public class Interface {
    private List<Jumper> jumpers;
    private Scanner reader;
    
    public Interface(){
        reader = new Scanner(System.in);
        jumpers = new ArrayList<Jumper>();
    }
    
    public void start(){
        ask();
        main();
    }
    public void ask(){
        System.out.println("Kumpula ski jumping week");
        System.out.println("Write the names of the participants one at a time; "
                + "an empty string brings you to the jumping phase.");
        while(true){
            System.out.print("  Participant name: ");
            String name = reader.nextLine();
            if(name.isEmpty()){
                break;
            } 
            this.jumpers.add(new Jumper(name));
              
        }
    }
    
    public void main(){
        int round = 1;
        System.out.println("The tournament begins!");
        
        while (true){
            System.out.print("Write \"jump\" to jump; otherwise you quit: ");
            String option = reader.nextLine();

            if (!option.equals("jump")) {
                break;
            }

            System.out.println("\nRound " + round + "\n");
            
            jumpingOrder(round);
            roundresults(round);
            round ++;
        }
        
        tournamentResult();
        
    }
    
    public void jumpingOrder(int round){
        System.out.println("Jumping order:");
        int order = 1;
        for (Jumper jumper : this.jumpers) {
            System.out.println("  " + order + ". " + jumper.printJumperResults());
            jumper.jump(round);
            order++;
        }
        System.out.println("");
    }
    
    public void roundresults(int round){
        System.out.println("Results of round " + round);
        for (Jumper jumper: jumpers){
            System.out.println("  " + jumper.getName());
            System.out.println(jumper.getPoints(round));
        }
        
        System.out.println("");
        Collections.sort(jumpers);
    }
    
    public void tournamentResult(){
        System.out.println("\nThanks!\n");
        System.out.println("Tournament results:");
        System.out.println("Position    Name");
        int order = 1;
        Collections.reverse(jumpers);
        for(Jumper jumper: jumpers){
            System.out.println(order + "" + jumper);
            order ++;
        }
    }
}
