package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


class GoogleDocsAccess {

//   public static final int FIVE_MINUTES = 5 * 60;

   void login(WebDriver driver, String login, String password) {
        WebElement userTextField = driver.findElement(By.id("identifierId"));
        WebElement nextButton = driver.findElement(By.id("identifierNext"));

        userTextField.sendKeys(login);
        nextButton.click();

        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofMinutes(5).getSeconds());
//        WebDriverWait driverWait = new WebDriverWait(driver, FIVE_MINUTES);
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("passwordNext")));

        WebElement passwordTextField = driver.findElement(By.cssSelector("[aria-label=\"Digite sua senha\"]"));
        WebElement loginNextButton = driver.findElement(By.id("passwordNext"));

        passwordTextField.sendKeys(password);
        loginNextButton.click();
    }

   public void openFile(WebDriver driver, String title) {
      WebDriverWait driverWait = new WebDriverWait(driver, 4);
      driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("docs-homescreen-item-container")));

      WebElement document = driver.findElement(By.cssSelector("[title=\"" + title + "\"]"));
      document.click();
   }
}
