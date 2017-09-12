import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;

import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNull;

class PropertyReaderTest {
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
    public void readAllTest() throws Exception {
        propertyReader.readProperties("src/test/resources/file_not_exist.testProperties");
        assertNull(propertyReader.getProperties());

        Map<Object, Object> testPropertiesMap = new HashMap<>();
        testPropertiesMap.putAll(testProperties);
        propertyReader.readProperties("src/test/resources/test.properties");
        assertThat(propertyReader.getProperties(), Is.is(testPropertiesMap));
    }
/*
    @Test
    public void readValueTest() throws Exception {
        PropertiesReader pr = new PropertiesReader();

        String value = pr.readValue("src/test/resources/forTest.testProperties", "parameter1");

        assertThat(value, is(testProperties.getProperty("parameter1")));

        value = pr.readValue("src/test/resources/forTest.testProperties", "parameter10");

        assertThat(value, is("No value found for the key parameter10"));
    }
    */
}