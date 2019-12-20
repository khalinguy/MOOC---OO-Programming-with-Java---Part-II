/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
/**
 *
 * @author Linh Nguyen
 */
public class Points {
    private Random random;
    private int length;
    private List<Integer> votes;
    
    public Points(){
        random = new Random();
        this.length = random.nextInt(61) + 60;
        this.votes = new ArrayList<Integer>();
        
        for (int i = 0; i < 5; i++){
            int vote = random.nextInt(11) + 10;
            votes.add(vote);
        }
    }
    
    public int validPoints(){
        Collections.sort(votes);
        int validPoints = 0;
        validPoints += this.length;
        for (int i = 1; i < 4; i ++){
            validPoints += votes.get(i);
        }
        
        return validPoints;
    }
    public int getLength(){
        return this.length;
        
    }
    public String getVote(){
        String vote = "[";
        for (int i = 0; i < 4; i++) {
            vote += this.votes.get(i) + ", ";
        }
        vote += this.votes.get(4) + "]";
        return vote;
    }
    
    public String toString(){
        String results = "    length: " + this.length + "\n" + "    judge votes: " + this.getVote();
        return results;
    }
}
