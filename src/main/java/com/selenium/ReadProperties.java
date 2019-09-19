package com.selenium;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {

    public static Properties readPropertiesFile(String propertiesFile) {
        Properties properties = new Properties();

        try (InputStream input = Main.class.getResourceAsStream(propertiesFile)) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return properties;
    }
}
