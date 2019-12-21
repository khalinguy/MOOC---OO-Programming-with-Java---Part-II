/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PhoneSearch;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


import PhoneSearch.Address;
import PhoneSearch.PhoneNumber;

/**
 *
 * @author Linh Nguyen
 */
public class Person implements Comparable<Person> {
    private Map<String, PhoneNumber> numberByName;
    private Map<String, Address> nameByAddress;
    private Map<String, String> nameByPhone;
    private String name;
    
    public Person(String name, String number){
        this.numberByName = new HashMap<String, PhoneNumber>();
        this.nameByPhone = new HashMap<String, String>();
        this.nameByAddress = new HashMap<String, Address>();
        this.name = name;
        
        this.numberByName.put(name, new PhoneNumber());
        this.numberByName.get(name).add(number);
        this.nameByPhone.put(number, name);
    }
    
    public Person(String name, String street, String city) {
        this.numberByName = new HashMap<String, PhoneNumber>();
        this.nameByPhone = new HashMap<String, String>();
        this.nameByAddress = new HashMap<String, Address>();
        this.name = name;

        this.nameByAddress.put(name, new Address());
        this.nameByAddress.get(name).setStreet(street);
        this.nameByAddress.get(name).setCity(city);
    }
    

    public boolean phoneSearchByPerson(String name){
        if (this.numberByName.containsKey(name)){
            return true;
        }
        return false;
    }
    
    public Set<String> printNumbers(){
        return this.numberByName.get(this.name).getNumbers();
    }
    
    public boolean searchByPhoneNumber (String number){
        if(this.nameByPhone.containsKey(number)){
            return true;
        }
        return false;
    }
    
    public void addAddress(String street, String city){
        if (this.nameByAddress.get(this.name) == null){
            this.nameByAddress.put(this.name, new Address());
        }
        
        this.nameByAddress.get(this.name).setStreet(street);
        this.nameByAddress.get(this.name).setCity(city);
    }
    
    public String getName(){
        return name;
    }
    
    public void addNumber(String number){
        this.nameByPhone.put(number, this.name);
        if(this.numberByName.get(this.name) != null){
            this.numberByName.get(this.name).add(number);
        } else {
            this.numberByName.put(this.name, new PhoneNumber());
            this.numberByName.get(this.name).add(number);
        }
    }

    public boolean keyWordSearch (String keyword){
        if (this.nameByAddress.get(this.name) != null){
            if(this.nameByAddress.get(this.name).addressContainsKeyword(keyword) || this.name.contains(keyword)){
                return true;
            } else {
                return false;
            }
        } else if (this.name.contains(keyword)) {
            return true;
        }
        
        return false;
        
    }
    public boolean searchAddressByName (String name){
        return this.nameByAddress.containsKey(name);
    }
    
    public boolean nameEqualsTo (String name){
        if (this.name.equals(name)){
            return true;
        }
        
        return false;
    }
    
    public Address printAddress(){
        return this.nameByAddress.get(this.name);
    }
    public String printName(String number){
        return this.nameByPhone.get(number);
    }
    @Override
    public int compareTo(Person person) {
        return this.name.compareToIgnoreCase(person.name);
    }
}
