import com.oracle.webservices.internal.api.databinding.DatabindingMode;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertyReader {

    private Map<Object, Object> properties;

    public Map<Object, Object> getProperties() {
        return properties;
    }

    public void readProperties(String fileName) {

        try (InputStream file = new FileInputStream(fileName)) {
            Properties propertiesFromFile = new Properties();
            propertiesFromFile.load(file);
            properties = new HashMap<>();
            properties.putAll(propertiesFromFile);
        } catch (FileNotFoundException e) {
            properties = null;
        } catch (IOException e) {
            e.printStackTrace();
            properties = null;
        }
    }

    public String getProperty(String fileName, String key){
        if (properties == null) readProperties(fileName);
        return (String) properties.getOrDefault(key,
                "No property with key " + key);

    }

}
