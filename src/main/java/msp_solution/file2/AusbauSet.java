package msp_solution.file2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Dieter Holz
 */
public class AusbauSet {

    public Map<String, Integer> inhalt() {                  // 10 insgesamt
        Map<String, Integer> inhalt = new HashMap<>();

        try (BufferedReader reader = getReader("schienen.csv")) {
            reader.lines()
                  .skip(1)
                  .map(line -> line.split(";", 5)[1])
                  .forEach(typ -> {
                      int currentCount = 0;
                      if (inhalt.containsKey(typ)) {
                          currentCount = inhalt.get(typ);
                      }
                      inhalt.put(typ, currentCount + 1);
                  });
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }

        return inhalt;
    }

    public int anzahlSchienen(Map<String, Integer> inhalt) {
        int totalCount = 0;

        for (int count : inhalt.values()) {
            totalCount += count;
        }

        return totalCount;
    }


    private BufferedReader getReader(String fileName) {
        InputStream       inputStream = getClass().getResourceAsStream(fileName);  // damit kann man vom File lesen
        InputStreamReader reader      = new InputStreamReader(inputStream, StandardCharsets.UTF_8); // lesen von Text-File
        return new BufferedReader(reader);  // damit man zeilenweise lesen kann
    }
}
