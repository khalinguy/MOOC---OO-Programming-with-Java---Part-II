/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personnel;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
/**
 *
 * @author Linh Nguyen
 */
public class Employees {
    private List<Person> employees;
    
    public Employees(){
        employees = new ArrayList<Person>();
    }
    
    public void add (Person person){
        employees.add(person);
    }
    
    public void add (List<Person> persons){
        for (Person p: persons){
            this.employees.add(p);
        }
    }
    
    public void print(){
        Iterator<Person> iterator = employees.iterator();
        
        while (iterator.hasNext()){
            Person person = iterator.next();
            System.out.println(person);
        }
        
    }
    
    public void print (Education education){
        Iterator<Person> iterator = employees.iterator();
        
        while (iterator.hasNext()){
            Person p = iterator.next();
            if (p.getEducation() == education){   
                System.out.println(p);
                
            }
        }
    }
    
    public void fire (Education education){
        Iterator<Person> iterator = employees.iterator();
        
        while (iterator.hasNext()){
            if (iterator.next().getEducation() == education){
                iterator.remove();
            }
        }
    }
}
