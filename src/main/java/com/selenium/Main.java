package com.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.Properties;

public class Main {
    private static String propertiesFile = "/selenium.properties";

    public static void main(String[] args) {
        GoogleDocsAccess access = new GoogleDocsAccess();
        Properties properties = ReadProperties.readPropertiesFile(propertiesFile);
        File file = new File(properties.getProperty("chrome-driver"));

        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

        //Step 1- Driver Instantiation: Instantiate driver object as FirefoxDriver
        WebDriver driver = new ChromeDriver();

        //Step 2- Navigation: Open a website
        driver.navigate().to(properties.getProperty("site"));

        String login = properties.getProperty("login");
        String password = properties.getProperty("password");
        access.login(driver, login, password);

        String title = properties.getProperty("document-title");
        access.openFile(driver, title);
    }


}
