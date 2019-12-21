/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package containers;

/**
 *
 * @author Linh Nguyen
 */
public class ProductContainer extends Container {
    private String productName;
    
    public ProductContainer(String productName, double capacity){
        super(capacity);
        this.productName = productName;
    }
    
    public String getName(){
        return productName;
    }
    
    public void setName(String newName){
        productName = newName;
    }
    
    public String toString(){
        return productName + ": " + super.toString();
    }
}
