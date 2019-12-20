/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;
/**
 *
 * @author Linh Nguyen
 */
public class TextUserInterface {
    private Scanner reader;
    private Dictionary dict;
    
    public TextUserInterface(Scanner reader, Dictionary dictionary){
        this.reader = reader;
        this.dict = dictionary;
    }
    
    public void start(){
        System.out.println("Statement: \n   add - adds a word pair to the dictionary"
                + "\n   translate - asks a word and prints its translation"
                + "\n   quit - quit the text user interface");
        while (true){
            System.out.print("Statement: ");
            String input = reader.nextLine();
            if (input.equalsIgnoreCase("quit")){
                System.out.println("Cheers!");
                break;
            } else if (input.equalsIgnoreCase("add")) {
                add();
                
            } else if (input.equalsIgnoreCase("translate")){
                translate();
            }
            else {
                System.out.println("Unknown statement");
            }
        }
    }
    
    public void add(){
        System.out.print("In Finnish: ");
        String word = reader.nextLine();
        System.out.print("Translation: ");
        String trans = reader.nextLine();
        this.dict.add(word,trans);
    }
    
    public void translate(){
        System.out.print("Give a word: ");
        String word = reader.nextLine();
        System.out.println("Translation: " + dict.translate(word));
    }
}
