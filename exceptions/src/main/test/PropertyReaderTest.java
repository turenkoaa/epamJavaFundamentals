import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PropertyReaderTest {
    @Test
    public void getValue() throws Exception {

            assertNull(PropertyReader.getValue("src/main/test/resources/notfoundfile", "some"));
            assertNull(PropertyReader.getValue("src/main/test/resources/test.properties", "some"));
            assertThat(PropertyReader.getValue("src/main/test/resources/test.properties", "key"), is("value"));
    }

}