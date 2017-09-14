package t2;

import t1.JavaKeyWords;

import java.io.*;
import java.util.*;

@SuppressWarnings("WeakerAccess")
public class SymbolStreamReader {


    private String inFileName;
    private String outFileName;

    public SymbolStreamReader(String inFileName, String outFileName) {
        this.inFileName = inFileName;
        this.outFileName = outFileName;
    }


    public List<String> read() {

        List<String> words = new ArrayList<>();

        try (Reader input = new BufferedReader(new FileReader(inFileName))) {

            StringBuilder stringBuilder = new StringBuilder();
            int i;
            char ch;
            while ((i = input.read()) > 0) {
                ch = (char) i;
                if (ch == ' ' || ch == '\n' || ch == '(' || ch == ')') {
                    words.add(stringBuilder.toString());
                    stringBuilder = new StringBuilder();
                } else {
                    stringBuilder.append((char)i);
                }
            }

        } catch (IOException | SecurityException e) {
            e.printStackTrace();
        }

        return words;

    }

    private  Map<String, Integer> count(List<String> words) {
        Map<String, Integer> wordsCount = new HashMap<>();
        Integer newValue;
        for (String word : words) {
            if (JavaKeyWords.keyWords.contains(word)) {
                newValue = wordsCount.getOrDefault(word, 0) + 1;
                wordsCount.put(word, newValue);
            }
        }

        return wordsCount;
    }

    private void write( Map<String, Integer> wordsCount) {

        try (OutputStreamWriter output = new FileWriter(outFileName);) {
            for (Map.Entry<String, Integer> entry : wordsCount.entrySet()) {
                output.write(String.format("%s %d%n", entry.getKey(), entry.getValue()));;
            }
        } catch (IOException | SecurityException e) {
            e.printStackTrace();
        }
    }

    public void  writeWordsCount(){
        write(count(read()));

    }



}
