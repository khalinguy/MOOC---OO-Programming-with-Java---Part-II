/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordinspection;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author 
 */
public class WordInspection {

    private final File file;

    public WordInspection(File file) {
        this.file = file;
    }
    
    public int wordCount() throws FileNotFoundException, Exception {
        int count = 0;
        Scanner r = readFile();
        String s = "";
        while (r.hasNextLine()){
            s = r.nextLine();
            count ++;
        }
        r.close();
        return count;
    }
    
    public List<String> wordsContainingZ() throws FileNotFoundException, Exception {
        List<String> zlist = new ArrayList<String>();
        Scanner r = readFile();
        while (r.hasNextLine()){
            String string = r.nextLine();
            if(string.trim().contains("z")){
                zlist.add(string);
            }
        }
        r.close();
        return zlist;
    }
    
    public List<String> wordsEndingInL() throws FileNotFoundException, Exception {
        List<String> endingL = new ArrayList<String>();
        Scanner r = readFile();
        while (r.hasNextLine()){
            String string = r.nextLine();
            if(string.trim().endsWith("l")){
                endingL.add(string);
            }
        }
        return endingL;
    }
    
    public List<String> palindromes() throws FileNotFoundException, Exception {
        List<String> palindromes = new ArrayList<String>();
        Scanner r = readFile();
        
        while (r.hasNextLine()){
            String string = r.nextLine();
            if (string.equalsIgnoreCase(reverse(string))) {
                    palindromes.add(string);
            }
        }
        return palindromes;
    }
    
    public List<String> wordsWhichContainAllVowels() throws FileNotFoundException, Exception {
        List<String> vowels = new ArrayList<String>();
        Scanner r = readFile();
        while (r.hasNextLine()){
            String string = r.nextLine();
            if (string.trim().contains("a")&& string.trim().contains("i") &&
                    string.trim().contains("e") && string.trim().contains("u") 
                    &&string.trim().contains("y")&& string.trim().contains("ä")
                    &&string.trim().contains("ö") && string.trim().contains("o")) {
                vowels.add(string);
            }
        }
        return vowels;
    }
    
    public Scanner readFile() throws FileNotFoundException, Exception {
        try {
            Scanner reader = new Scanner(this.file, "UTF-8");
            return reader;
        } catch(FileNotFoundException e){
            return null;
        }
    }
    
    public String reverse(String s){
        int i = 1;
        String reversed = "";
        while (i <= s.length()) {
            char character = s.charAt(s.length() - i);
            reversed += character;
            i++;
        }
        return reversed;
    }
}