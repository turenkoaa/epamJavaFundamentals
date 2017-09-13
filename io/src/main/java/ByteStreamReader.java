import java.io.*;
import java.nio.charset.Charset;
import java.util.*;

@SuppressWarnings("WeakerAccess")
public class ByteStreamReader {
    private static Set<String> keyWords = new HashSet<>();

    private String inFileName;
    private String outFileName;

    public ByteStreamReader(String inFileName, String outFileName) {
        this.inFileName = inFileName;
        this.outFileName = outFileName;
    }

    static {
        keyWords.addAll(Arrays.asList(
                "abstract", "continue", "for", "new", "switch",
                "assert", "default", "goto", "package", "synchronized",
                "boolean", "do", "if", "private", "this",
                "break", "double", "implements", "protected", "throw",
                "byte", "else", "import", "public", "throws",
                "case", "enum", "instanceof", "return", "transient",
                "catch", "extends", "int", "short", "try",
                "char", "final", "interface", "static", "void",
                "class", "finally", "long", "strictfp", "volatile",
                "const", "float", "native", "super", "while"
        ));
    }

    public List<String> read() {

        List<String> words = new ArrayList<>();

        try (InputStream input = new BufferedInputStream(new FileInputStream(inFileName))) {

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
            if (keyWords.contains(word)) {
                newValue = wordsCount.getOrDefault(word, 0) + 1;
                wordsCount.put(word, newValue);
            }
        }

        return wordsCount;
}

    private void write( Map<String, Integer> wordsCount) {

        try (OutputStream f = new BufferedOutputStream(new FileOutputStream(outFileName, false))) {
            for (Map.Entry<String, Integer> entry : wordsCount.entrySet()) {
                f.write(String.format("%s %d%n", entry.getKey(), entry.getValue()).getBytes());
            }
        } catch (IOException | SecurityException e) {
            e.printStackTrace();
        }
    }

    public void  writeWordsCount(){
        write(count(read()));

    }



}
