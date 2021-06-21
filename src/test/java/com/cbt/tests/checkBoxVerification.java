package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sun.awt.windows.WBufferStrategy;

import java.util.List;

public class checkBoxVerification {

    WebDriver driver;

    @BeforeMethod
    public void setup() {

        driver = BrowserFactory.getDriver("chrome");
    }

    @AfterMethod
    public void quitBrowser() throws InterruptedException {

        Thread.sleep(3000);
        driver.quit();
    }


    @Test
    public void CheckboxVerify1() throws InterruptedException {

        // Go to http://www.seleniumeasy.com/test/basic-checkbox-demo.html
        driver.get("http://www.seleniumeasy.com/test/basic-checkbox-demo.html");

        WebElement successCheckbox = driver.findElement(By.xpath("//div[@id='txtAge']"));

        // Verify “Success – Check box is checked” message is NOT displayed.
        Assert.assertFalse(successCheckbox.isDisplayed(), "verify not displayed");

        System.out.println("Before clicking: " + successCheckbox.getText());
        System.out.println("successCheckbox.isDisplayed() = " + successCheckbox.isDisplayed());


        WebElement clickCheckbox = driver.findElement(By.xpath("//input[@id='isAgeSelected']"));
        // Click to checkbox under “Single Checkbox Demo” section
        Thread.sleep(2500);
        clickCheckbox.click();

        // Verify “Success – Check box is checked” message is displayed.
        Assert.assertTrue(successCheckbox.isDisplayed(), "verify displayed");

        System.out.println("After clicking : " + successCheckbox.getText());
        System.out.println("successCheckbox.isDisplayed() = " + successCheckbox.isDisplayed());
    }


    @Test
    public void CheckboxVerify2() {

        // Go to http://www.seleniumeasy.com/test/basic-checkbox-demo.html
        driver.get("http://www.seleniumeasy.com/test/basic-checkbox-demo.html");

        // Verify “Check All” button text is “Check All”
        WebElement checkAllBtn = driver.findElement(By.xpath("//input[@value='Check All']"));
        System.out.println("checkAllBtn.getAttribute(\"value\") = " + checkAllBtn.getAttribute("value"));

        // Verify “Check All” button text is “Check All”
        String actualText = checkAllBtn.getAttribute("value");

        String expectedText = "Check All";

        Assert.assertEquals(actualText,expectedText, "verify equality");
        System.out.println("actualText.equals(expectedText) = " + actualText.equals(expectedText));

        // Click to “Check All” button
        checkAllBtn.click();

        // Verify all check boxes are checked
        List<WebElement> checkButtons = driver.findElements(By.className("cb1-element"));
        //List<WebElement> checkButtons = driver.findElements(By.cssSelector(".cb1-element"));
        //List<WebElement> checkButtons = driver.findElements(By.xpath("//input[@class='cb1-element']"));

        System.out.println("checkButtons.size() = " + checkButtons.size());
        Assert.assertEquals(checkButtons.size(), 4, "verify buttons size is 4");

        for (WebElement checkButton : checkButtons) {
            Assert.assertTrue(checkButton.isSelected());
            System.out.println("checkButton.isSelected() = " + checkButton.isSelected());
        }

        System.out.println();

        WebElement checkbox1 = driver.findElement(By.xpath("(//input[@class='cb1-element'])[1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("(//input[@class='cb1-element'])[2]"));
        WebElement checkbox3 = driver.findElement(By.xpath("(//input[@class='cb1-element'])[3]"));
        WebElement checkbox4 = driver.findElement(By.xpath("(//input[@class='cb1-element'])[4]"));

        Assert.assertTrue(checkbox1.isSelected(), "verify selected");
        System.out.println("checkbox1.isSelected() = " + checkbox1.isSelected());
        Assert.assertTrue(checkbox2.isSelected(), "verify selected");
        System.out.println("checkbox2.isSelected() = " + checkbox2.isSelected());
        Assert.assertTrue(checkbox3.isSelected(), "verify selected");
        System.out.println("checkbox3.isSelected() = " + checkbox3.isSelected());
        Assert.assertTrue(checkbox4.isSelected(), "verify selected");
        System.out.println("checkbox4.isSelected() = " + checkbox4.isSelected());

        // Verify button text changed to “Uncheck All”
        System.out.println("After checking the button: " + checkAllBtn.getAttribute("value"));

        String afterChecking = "Uncheck All";

        Assert.assertEquals(checkAllBtn.getAttribute("value"), "Uncheck All");


    }


}
