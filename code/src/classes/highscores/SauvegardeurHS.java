package classes.highscores;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SauvegardeurHS {

    public void sauvegardeHS(Integer score, String pseudo) throws IOException {

        try
        {
            String filename= "rsrc/data/dataHighscores.txt";
            File theFile = new File(filename);

            FileWriter fw = new FileWriter(filename,true);
            fw.write(score + " -> " + pseudo + System.getProperty("line.separator"));
            fw.close();
        }
        catch(IOException ioe)
        {
            System.err.println("IOException: " + ioe.getMessage());
        }
    }
}
