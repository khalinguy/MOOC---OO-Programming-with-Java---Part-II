/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Linh Nguyen
 */
public class Printer {

    private Scanner reader;
    private final File file;

    public Printer(String fileName) throws Exception {
        this.file = new File(fileName);

    }

    public void printLinesWhichContain(String word) throws Exception {
        this.reader = new Scanner(file);
        
        while (reader.hasNextLine()) {
            String s = reader.nextLine();
            if (s.contains(word)) {
                System.out.println(s);
            }
        }
        reader.close();
    }

}
