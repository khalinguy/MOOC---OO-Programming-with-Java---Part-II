/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author Linh Nguyen
 */
public class Dungeon {
    
    private Random random = new Random();
    private int length;
    private int height;
    private int vampries;
    private int moves;
    private boolean vampiresMove;
    private List<Vampires> vampiresList;
    private Player player;
    private Scanner reader;
    

    public Dungeon(int length, int height, int vampires, int moves, boolean vampiresMove) {
        this.length = length;
        this.height = height;
        this.vampries = vampires;
        this.moves = moves;
        this.vampiresMove = vampiresMove;

        this.vampiresList = new ArrayList<Vampires>();
        this.player = new Player(this.length, this.height);

        for (int i = 0; i < this.vampries; i++) {
            vampiresList.add(new Vampires(this.length, this.height));
        }
        reader = new Scanner(System.in);
    }

    public void run() {
        while (this.moves > 0) {
            this.printInfo();
            
            while (this.checkOverLap()){
                this.resetInitialPosition();
            }
            this.printDungeon();
            this.playerAndVampiresMove();
            
            
            if (this.vampiresList.isEmpty()){
                System.out.println("YOU WIN");
                break;
            }
            
            this.moves --;
        }
        
        if (!vampiresList.isEmpty()){
            System.out.println("YOU LOSE");
        }
    }
    
    public void printInfo(){
        System.out.println(this.moves + "\n\n" + this.player);
        for (Vampires v: this.vampiresList){
            System.out.println(v);
        }
        System.out.println("");
    }

    public void printDungeon() {
        for (int y = 0; y < this.height; y++) {
            for (int x = 0; x < this.height; x++) {
                Loop:
                while (true) {
                    if (this.player.coordinates().equals(x + "x" + y + "y")) {
                        System.out.print("@");
                        break;
                    }

                    for (int i = 0; i < this.vampiresList.size(); i++) {
                        if (this.vampiresList.get(i).coordinates().equals(x + "x" + y + "y")) {
                            System.out.print("v");
                            break Loop;
                        }
                    }

                    System.out.print(".");
                    break;
                }
            }
            System.out.println("");
        }
        System.out.println("");
    }
    
    public void playerAndVampiresMove(){
        char[] command = reader.nextLine().toLowerCase().toCharArray();
        for (int i = 0; i< command.length; i++){
            this.player.command(command[i]);
            if (this.vampiresMove) {
                this.vampiresMove();
            }

            this.playerKillVampire();
        }
    }

    public void vampiresMove() {
        List<Vampires> backupVampireList = new ArrayList<Vampires>(this.vampiresList);

        while (true) {
            for (Vampires vampire : this.vampiresList) {
                vampire.move();
            }

            if (this.checkOverLap()) {
                this.vampiresList = backupVampireList;
            }

            break;
        }
    }
    public void playerKillVampire(){
        for (int i = 0; i < this.vampiresList.size(); i ++){
            if (this.player.coordinates().equals(vampiresList.get(i).coordinates())){
                this.vampiresList.remove(i);
            }
        }
    }
    public boolean checkOverLap(){
        for (int i = 0; i < this.vampiresList.size()-1; i++){
            for (int o = i+1; o < this.vampiresList.size(); o ++){
                if (vampiresList.get(i).coordinates().equals(vampiresList.get(i+1).coordinates())){
                    return true;
                }    
            }
        }
        return false;
    }
    
    public void resetInitialPosition(){
        for (Vampires v: this.vampiresList){
            v.resetInitialPosition();
        }
    }
}
