package msp_solution.file1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class Wald {

    public Map<Integer, Integer> baumStatistik() {
        Map<Integer, Integer> statistik = new HashMap<>();

        try (BufferedReader reader = getReader("baeume.csv")) {
            reader.lines()
                  .skip(1)
                  .map(line -> Integer.valueOf(line.split(";", 4)[2]))
                  .forEach(year -> {
                      Integer currentCount = statistik.get(year);
                      if (currentCount == null) {
                          currentCount = 0;
                      }
                      statistik.put(year, currentCount + 1);
                  });
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }

        return statistik;
    }

    public int anzahlBaeume(Map<Integer, Integer> statistik) {

        int totalCount = 0;

        for (int count : statistik.values()) {
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
