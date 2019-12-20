/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
/**
 *
 * @author Linh Nguyen
 */
public class Analysis {
    private final File file;

    
    public Analysis(File file) throws Exception{
        this.file = file;
    }
    public int lines()throws FileNotFoundException {
        
        Scanner readLines = new Scanner(file);
        int lines = 0;
        
        while (readLines.hasNextLine()){
            String s = readLines.nextLine();
            lines++;
        }
        readLines.close();
        return lines;

    }
    
    public int characters()throws FileNotFoundException, Exception{
        Scanner readChar = new Scanner(file);
        
        int character = lines();
        
        while(readChar.hasNextLine()){
            String s = readChar.useDelimiter("").nextLine();
            character += s.length();
        }
        
        readChar.close();
        
        return character;
    }
}