import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.PrintStream;

public class CrazyLoggerTest {
    private static CrazyLogger log;
    private PrintStream out = System.out;
    private ByteOutputStream testStream = new ByteOutputStream();
    private PrintStream ps = new PrintStream(testStream);



}
