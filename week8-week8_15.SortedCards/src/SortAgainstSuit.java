/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Linh Nguyen
 */
public class SortAgainstSuit {
    public int compare(Card card1, Card card2) {
        return card1.getSuit() - card2.getSuit();
    }
}
