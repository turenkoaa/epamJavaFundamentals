import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@SuppressWarnings("WeakerAccess")
public class PropertyReader {

    public static String getValue(String fileName, String key) throws FileNotFoundException{
        Properties properties = new Properties();

        try (InputStream inputStream = new FileInputStream(fileName)) {
            properties.load(inputStream);
            return properties.getProperty(key);
        } catch (FileNotFoundException e) {
            System.err.println("File was not found");
            return null;
        } catch (IllegalArgumentException e) {
            System.err.println("Property was not found by key");
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
