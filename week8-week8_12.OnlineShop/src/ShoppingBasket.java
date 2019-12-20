/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
/**
 *
 * @author Linh Nguyen
 */
public class ShoppingBasket {
    private List<Purchase> basket;
    
    public ShoppingBasket(){
        basket = new ArrayList<Purchase>();
    }
    
    public void add(String product, int price){
        Purchase purchase = new Purchase(product,1,price);
        
        if(basket.contains(purchase)){
            purchase.increaseAmount();
        }
        if (!basket.contains(purchase)){
            basket.add(purchase);
        } 
    }
    
    public int price(){
        int sum = 0;
        for (Purchase purchase: basket){
            sum += purchase.price();
        }
        return sum;
    }
    
    public void print(){
        
        Map<String, Integer> print = new HashMap<String, Integer>();
        
        for(Purchase purchase: basket){
            String itemName = purchase.name();
            
            if(print.containsKey(itemName)){
                print.put(itemName, print.get(itemName)+1);
            } else {
                print.put(itemName,1);
            }
        }
        
        for(String key: print.keySet()){
            System.out.println(key + ": " + print.get(key));
        }
    }
}
