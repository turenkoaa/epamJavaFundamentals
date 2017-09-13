
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class CrazyLoggerTest {
    private CrazyLogger log;
    private PrintStream out;
    private ByteArrayOutputStream testStream;
    private PrintStream ps;

    @Before
    public void init() {
        out = System.out;
        testStream = new ByteArrayOutputStream();
        ps = new PrintStream(testStream);
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
        String result = new String(testStream.toString()).trim();
        assertThat(result, containsString("One message"));
        assertThat(result, containsString("Twenty one message"));
    }



}
