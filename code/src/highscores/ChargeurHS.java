package highscores;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ChargeurHS {


    public Map<String, Integer> chargeHS() {
        Map<String, Integer> mapTemp = new HashMap<String, Integer>();
        Map<String, Integer> mapToReturn = new HashMap<String, Integer>();

        try{
            String filename= "rsrc/data/dataHighscores.txt";
            FileReader fr = new FileReader(filename);
            BufferedReader bfr = new BufferedReader(fr);
            String ligneLue;

            while ((ligneLue = bfr.readLine()) != null) {
                String[] ligneLueSplit = ligneLue.split(" -> "); //découpe la ligne
                mapTemp.put(ligneLueSplit[0], Integer.parseInt(ligneLueSplit[1])); //ajoute la ligne dans la Map
            }
            bfr.close();
            fr.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        for (final Map.Entry<String, Integer> entry : mapTemp.entrySet()) {
            String key =  entry.getKey();
            int value =  entry.getValue();
            boolean alreadyExists = false;

            for (final Map.Entry<String, Integer> entryMapToReturn : mapToReturn.entrySet()) {
                if (entry.equals(entryMapToReturn)) {
                    alreadyExists = true;
                    break;
                }
            }
            if(!alreadyExists)
                mapToReturn.put(key, value);
        }
        return mapToReturn;
    }

}
