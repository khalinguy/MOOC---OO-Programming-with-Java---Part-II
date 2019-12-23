/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference.domain;

/**
 *
 * @author Linh Nguyen
 */
public class Person {
    private String name;
    
    public Person (String name){
        this.name = name;
    }
    
    public String getName(){
        return this.name;
    }
    
    public String toString(){
        return this.name;
    }
    
    @Override
    public boolean equals(Object object){
        if (object == null){
            return false;
        }
        
        if (this.getClass() != object.getClass()){
            return false;
        }
        
        Person compared = (Person) object;
        
        return this.name.equals(compared.name);
    }
    
    @Override
    public int hashCode(){
        if (this.name == null){
            return 7;
        }
        
        return this.name.hashCode();
    }
}
