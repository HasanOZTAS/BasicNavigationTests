package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ebaySeleniumTest {

    public static void main(String[] args) throws InterruptedException {

        /*
        Go to Ebay
        search Selenium
        click on search button
        verify title contains Selenium
         */

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://www.ebay.com/");

        Thread.sleep(2000);

        WebElement searchSelenium = driver.findElement(By.xpath("(//input)[3]"));
        searchSelenium.sendKeys("Selenium");

        Thread.sleep(2000);

        WebElement clickOnSearch = driver.findElement(By.xpath("//input[@type='submit']"));
        clickOnSearch.click();

        String title = driver.getTitle();

        if(title.contains("Selenium")) {
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
        }

        //driver.quit();


    }
}
