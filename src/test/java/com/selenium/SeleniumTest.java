package com.selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class SeleniumTest {

    @Test
    public void ChromeTest () {
        File file = new File("D:\\workspace\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

        //Step 1- Driver Instantiation: Instantiate driver object as FirefoxDriver
        WebDriver driver = new ChromeDriver();

        //Step 2- Navigation: Open a website
        driver.navigate().to("https://docs.google.com/");

        String login = "gabriellelodi@gmail.com";
        String password = "novavida4712";
        login(driver, login, password);



        //Step 3- Assertion: Check its title is correct
        //assertEquals method Parameters: Message, Expected Value, Actual Value
        Assert.assertEquals("Title check", "Selenium Tutorial JAVA and JUnit in 7 Easy Steps",
                driver.getTitle());

        //Step 4- Close Driver
        driver.close();

        //Step 5- Quit Driver
        driver.quit();
    }

    private void login(WebDriver driver, String login, String password) {
        WebElement userTextField = driver.findElement(By.id("identifierId"));
        WebElement nextButton = driver.findElement(By.id("identifierNext"));

        userTextField.sendKeys(login);
        nextButton.click();

    }


}
