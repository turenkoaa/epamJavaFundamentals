package t3;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class EncodingChange {
    static String input = "src\\main\\resources\\UTF-8.txt";
    static String output = "src\\main\\resources\\UTF-16.txt";

    static List<String> readFile(String filename) {
        try {
            return Files.readAllLines(Paths.get(filename), Charset.forName("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    static void writeFile(String filename, List<String> lines) {
        try {
            Files.write(Paths.get(filename), lines, Charset.forName("UTF-16"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        List<String> lines = readFile(input);
        writeFile(output, lines);
    }
}
