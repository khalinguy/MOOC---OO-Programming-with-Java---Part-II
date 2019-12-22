/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Linh Nguyen
 */
public class MindfulDictionary {

    private final Map<String, String> dict;
    private Scanner reader;
    private File file;

    public MindfulDictionary() {
        dict = new HashMap<String, String>();
    }

    public MindfulDictionary(String file) {
        this.file = new File(file);
        reader = new Scanner(file);
        dict = new HashMap<String, String>();
    }

    public void add(String word, String translation) {
        if (!dict.containsKey(word)) {
            dict.put(word, translation);
        }
    }

    public String translate(String word) {
        if (dict.containsKey(word)) {
            return dict.get(word);
        }
        if (dict.containsValue(word)) {
            for (String key : dict.keySet()) {
                if (dict.get(key).equals(word)) {
                    return key;
                }
            }

        }
        return null;

    }

    public void remove(String word) {
        if (dict.containsKey(word)) {
            dict.remove(word, dict.get(word));
        } else if (dict.containsValue(word)) {
            String key = "";
            for (String string : dict.keySet()) {
                if (dict.get(string).equals(word)) {
                    key = string;
                }
            }
            dict.remove(key, word);
        }
    }

    public boolean load() {
        try {
            Scanner fileReader = new Scanner(this.file);
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                String[] parts = line.split(":");
                this.dict.put(parts[0], parts[1]);

            }
            return true;
        } catch (FileNotFoundException e){
            return false;
        }
    }
    
    public boolean save(){
        try {
            FileWriter filewriter = new FileWriter (file);
            for (String key: dict.keySet()){
                filewriter.write(key + ":" + dict.get(key) + "\n");     
            }
            filewriter.close();
            return true;
        } catch (IOException e){
            return false;
        }
    }
}
