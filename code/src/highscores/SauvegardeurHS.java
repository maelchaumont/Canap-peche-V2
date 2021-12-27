package highscores;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Map;

public class SauvegardeurHS {

    public void sauvegardeHS(String pseudo, Integer score) throws IOException {

        try
        {
            String filename= "rsrc/data/dataHighscores.txt";
            File theFile = new File(filename);
            if(!theFile.exists())
                theFile.createNewFile();

            FileWriter fw = new FileWriter(filename,true);
            fw.write(pseudo + " -> " + score + System.getProperty("line.separator"));
            fw.close();
        }
        catch(IOException ioe)
        {
            System.err.println("IOException: " + ioe.getMessage());
        }
    }
}
