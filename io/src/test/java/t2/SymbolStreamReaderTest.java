package t2;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class SymbolStreamReaderTest {
    @Test
    public void writeWordsCount() throws Exception {
        SymbolStreamReader symbolReader = new SymbolStreamReader("src\\test\\resources\\input.txt", "src\\test\\resources\\output.txt");
        symbolReader.writeWordsCount();
        Map<String, Integer> map = new HashMap<>();
        map.put("new", 1);
        map.put("synchronized", 1);
        map.put("private", 2);
        map.put("static", 1);
        map.put("void", 2);
        map.put("public", 1);
        map.put("for", 1);
        map.put("class", 1);
        map.put("if", 1);

        Map<String, Integer> resultMap = new HashMap<>();
        InputStream inputStream = new FileInputStream("src\\test\\resources\\output.txt");
        int i;
        StringBuilder stringBuilder = new StringBuilder();
        String key = null;
        Integer value;
        while ((i = inputStream.read()) > 0) {
            if (i == ' ') {
                key = stringBuilder.toString();
                stringBuilder = new StringBuilder();
            } else if (i == '\n') {
                value = Integer.valueOf(stringBuilder.toString());
                stringBuilder = new StringBuilder();
                resultMap.put(key, value);
            } else if (i == '\r') {
                //nop
            }else {
                stringBuilder.append((char)i);
            }
        }
        inputStream.close();

        assertEquals(map, resultMap);
    }

}