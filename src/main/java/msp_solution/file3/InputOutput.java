package msp_solution.file3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InputOutput {

    public List<Integer> countChars(String fileName) {
        try (BufferedReader reader = getReader(fileName)) { // 3
            return reader.lines()                           // 1
                         .map(String::length)               // 3
                         .collect(Collectors.toList());     // 2
        } catch (IOException e) {
            return null;                                    // 1
        }
    }

    private BufferedReader getReader(String fileName) {     // 2
        InputStream       inputStream = getClass().getResourceAsStream(fileName);
        InputStreamReader reader      = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        return new BufferedReader(reader);
    }

}
