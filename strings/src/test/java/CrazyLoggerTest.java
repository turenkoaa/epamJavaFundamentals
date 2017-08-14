import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class CrazyLoggerTest {
    private static CrazyLogger log;
    private PrintStream out = System.out;
    private ByteOutputStream testStream = new ByteOutputStream();
    private PrintStream ps = new PrintStream(testStream);

    @BeforeEach
    public void init() {
        log = new CrazyLogger();
        log.add("One message");
        log.add("Two message");
        log.add("Twenty one message");
    }

    @Test
    public void findInLog() {
        System.setOut(ps);
        log.findInfo("one");

        System.setOut(out);
        String result = new String(testStream.getBytes()).trim();
        assertThat(result, containsString("One message"));
        assertThat(result, containsString("Twenty one message"));
    }



}
