package classes.highscores;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Stream;

public class ChargeurHS {


    public Map<Integer, String> chargeHS() {
        Map<Integer, String> mapTemp = new TreeMap<>(
                (Comparator<Integer>) (o1, o2) -> o2.compareTo(o1)
        );
        Map<Integer, String> mapToReturn = new TreeMap<>(
                (Comparator<Integer>) (o1, o2) -> o2.compareTo(o1)
        );


        try{
            String filename= "rsrc/data/dataHighscores.txt";
            FileReader fr = new FileReader(filename);
            BufferedReader bfr = new BufferedReader(fr);
            String ligneLue;

            while ((ligneLue = bfr.readLine()) != null) {
                String[] ligneLueSplit = ligneLue.split(" -> "); //découpe la ligne
                mapTemp.put(Integer.parseInt(ligneLueSplit[0]), ligneLueSplit[1]); //ajoute la ligne dans la Map
            }
            bfr.close();
            fr.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        //petit problème pour le moment, des personnes différentes ne peuvent pas avoir le mm score
        for (final Map.Entry<Integer, String> entry : mapTemp.entrySet()) {
            if(mapToReturn.size() == 5) break;

            int key =  entry.getKey();
            String value =  entry.getValue();
            mapToReturn.put(key, value);
        }
        return mapToReturn;
    }

}
