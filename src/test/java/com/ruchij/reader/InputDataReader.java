package com.ruchij.reader;

import java.io.*;
import java.net.URL;
import java.util.stream.Stream;

public class InputDataReader {
    public static Stream<String> read(String resourceName) throws FileNotFoundException {
        URL resource = InputDataReader.class.getClassLoader().getResource(resourceName);

        if (resource == null) {
            throw new FileNotFoundException("Unable to find resource: " + resourceName);
        }

        FileReader fileReader = new FileReader(resource.getFile());
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        return bufferedReader.lines();
    }
}
