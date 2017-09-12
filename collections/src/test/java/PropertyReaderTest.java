import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;

import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;

public class PropertyReaderTest {

    Properties testProperties;
    PropertyReader propertyReader;

    @Before
    public void init() throws Exception {
        propertyReader = new PropertyReader();

        try (FileOutputStream f = new FileOutputStream("src/test/resources/test.properties")) {
            testProperties = new Properties();
            testProperties.setProperty("key1", "value1");
            testProperties.setProperty("key2", "value2");
            testProperties.store(f, "File with test testProperties.");
        }
    }

    @Test
    public void readProperties() throws Exception {
        propertyReader.readProperties("src/test/resources/file_not_exist.properties");
        assertNull(propertyReader.getProperties());

        Map<Object, Object> testPropertiesMap = new HashMap<>();
        testPropertiesMap.putAll(testProperties);
        propertyReader.readProperties("src/test/resources/test.properties");

        assertThat(propertyReader.getProperties(), is(testPropertiesMap));
    }

    @Test
    public void getProperty() throws Exception {
        PropertyReader pr = new PropertyReader();

        assertThat(pr.getProperty("src/test/resources/test.properties", "key1"),
                is(testProperties.getProperty("key1")));

        assertThat(pr.getProperty("src/test/resources/test.properties", "key3"),
                is("No property with key key3"));
    }

}