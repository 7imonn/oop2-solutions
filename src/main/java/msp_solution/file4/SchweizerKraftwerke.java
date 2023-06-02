package msp_solution.file4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class SchweizerKraftwerke {

    public Map<Integer, Double> leistungProJahr() {
        Map<Integer, Double> result = new HashMap<>();
        try (BufferedReader reader = getReader("kraftwerke.csv")) {
            reader.lines()
                  .skip(1)
                  .map(s -> s.split(";", 3))
                  .forEach(s -> {
                      int    jahr = Integer.parseInt(s[2]);
                      double mw   = Double.parseDouble(s[1]);
                      result.putIfAbsent(jahr, 0.0);
                      result.put(jahr, result.get(jahr) + mw);
                  });
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
        return result;
    }

    private BufferedReader getReader(String fileName) {
        InputStream       inputStream = getClass().getResourceAsStream(fileName);  // damit kann man vom File lesen
        InputStreamReader reader      = new InputStreamReader(inputStream, StandardCharsets.UTF_8); // lesen von Text-File
        return new BufferedReader(reader);  // damit man zeilenweise lesen kann
    }

    public double gesamtLeistung(Map<Integer, Double> leistungProJahr) {
//        return leistungProJahr.values().stream().collect(Collectors.summingDouble(value -> value));
        return leistungProJahr.values()
                              .stream()
                              .mapToDouble(value -> value)
                              .sum();
    }
}
