/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
/**
 *
 * @author Linh Nguyen
 */
public class Hand implements Comparable<Hand> {
    private List<Card> hand;
    
    public Hand(){
        hand = new ArrayList<Card>();
    }
    
    public void add(Card card){
        hand.add(card);
    }
    public void print(){
        for(Card card: hand){
            System.out.println(card);
        }
    }
    public void sort(){
        Collections.sort(this.hand);
    }
    
    public int compareTo(Hand comparedHand){
        int sum1 = 0; 
        for (Card card : comparedHand.hand){
            sum1 += card.getValue();
        }
        
        int sum2 = 0;
        for (Card card : this.hand){
            sum2 += card.getValue();
        }
        
        return sum2 - sum1;
    }
    public void sortAgainstSuit(){
        SortAgainstSuitAndValue suitSorter = new SortAgainstSuitAndValue();
        Collections.sort(this.hand, suitSorter);
    }
}
