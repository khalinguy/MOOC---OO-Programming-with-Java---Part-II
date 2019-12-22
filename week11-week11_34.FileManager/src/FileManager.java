
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileManager {

    private File file;
    private Scanner reader;

    public List<String> read(String file) throws FileNotFoundException {
        Scanner reader;
        this.file = new File(file);
        reader = new Scanner(this.file);

        List<String> words = new ArrayList<String>();

        if (this.file.exists()) {
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                words.add(line);
            }

            return words;
        } else {
            return null;
        }
    }

    public void save(String file, String text) throws IOException {
        this.file = new File(file);
        FileWriter writer = new FileWriter(file);

        writer.write(text);
        writer.close();

    }

    public void save(String file, List<String> texts) throws IOException {
        FileWriter writer = new FileWriter(file);
        this.file = new File(file);
        for (String line: texts){
            writer.write(line + "\n");
        }
        writer.close();
        
    }
}
