/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmsimulator;

import java.util.Random;

/**
 *
 * @author Linh Nguyen
 */
public class Cow implements Alive, Milkable{

    private String name;
    private double capacity;
    private double amount;
    private Random random;

    private static final String[] NAMES = new String[]{
        "Anu", "Arpa", "Essi", "Heluna", "Hely",
        "Hento", "Hilke", "Hilsu", "Hymy", "Ihq", "Ilme", "Ilo",
        "Jaana", "Jami", "Jatta", "Laku", "Liekki",
        "Mainikki", "Mella", "Mimmi", "Naatti",
        "Nina", "Nyytti", "Papu", "Pullukka", "Pulu",
        "Rima", "Soma", "Sylkki", "Valpu", "Virpi"};

    public Cow() {
        random = new Random();
        name = NAMES[random.nextInt(NAMES.length)];
        capacity = 15 + new Random().nextInt(40-15) + 1;
        amount = 0;
    }

    public Cow(String name) {
        this.name = name;
        capacity = 15 + new Random().nextInt(40-15) + 1;
        amount = 0;
    }
    
    public String getName(){
        return name;
    }
    
    public double getCapacity(){
        return capacity;
    }
    
    public double getAmount(){
        return amount;
    }
    
    public String toString(){
        return this.name + " " + Math.ceil(this.amount) + "/" + this.capacity;
    }

    @Override
    public void liveHour() {
        amount += (7 + new Random().nextInt(20 - 7 + 1))/ 10.0;
        if (this.amount > this.capacity){
            this.amount = this.capacity;
        }
    }

    @Override
    public double milk() {
        double milk = this.amount;
        amount = 0;
        return milk;
    }
}
