package library;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class EnvPropertiesManager {

    private static final String envFilePath = ".env";

    public static Properties getPropertiesFromFile() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(new File(envFilePath)));
        } catch (Exception e) {
            throw new RuntimeException("Exception while load .env file");
        }
        return properties;
    }
}
