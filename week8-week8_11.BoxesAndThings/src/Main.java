/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Linh Nguyen
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Box box = new Box(10);
        Box smallbox = new Box(5);
        box.add( new Book("Fedor Dostojevski", "Crime and Punishment", 2) ) ;
        box.add( new Book("Robert Martin", "Clean Code", 1) );
        box.add( new Book("Kent Beck", "Test Driven Development", 0.7) );

        smallbox.add( new CD("Pink Floyd", "Dark Side of the Moon", 1973) );
        smallbox.add( new CD("Wigwam", "Nuclear Nightclub", 1975) );
        smallbox.add( new CD("Rendezvous Park", "Closer to Being Here", 2012) );
        

        box.add(smallbox);
        
        System.out.println( box );
        // TODO code application logic here
    }
    
}
