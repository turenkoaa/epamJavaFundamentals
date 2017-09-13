import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.Assert.*;


public class ByteStreamReaderTest {

    @Test
    public void testCount() throws IOException{
        ByteStreamReader byteStreamReader = new ByteStreamReader("src\\test\\resources\\input.txt", "src\\test\\resources\\output.txt");
        byteStreamReader.writeWordsCount();
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
        InputStream inputStream = new FileInputStream("output.txt");
        int i;
        StringBuilder stringBuilder = new StringBuilder();
        String key = null;
        int value;
        while ((i = inputStream.read()) > 0) {
            if (i == ' ') {
                key = stringBuilder.toString();
                stringBuilder = new StringBuilder();
            } else if (i == '\n') {
                value = new Integer(stringBuilder.toString());
                stringBuilder = new StringBuilder();
                resultMap.put(key, value);
            } else {
                stringBuilder.append((char)i);
            }
        }
        inputStream.close();

        assertEquals(map, resultMap);

    }


}