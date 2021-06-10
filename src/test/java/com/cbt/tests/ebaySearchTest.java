package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ebaySearchTest {

    public static void main(String[] args) throws InterruptedException {

        /*
        Go to Ebay
        enter search term
        click on search button
        print number of results
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.ebay.com/");
        WebElement searchTerm = driver.findElement(By.xpath("(//input)[3]"));

        Thread.sleep(3500);
        searchTerm.sendKeys("apple");

        WebElement clickSearch = driver.findElement(By.xpath("//input[contains(@value, 'Search')]"));
        clickSearch.click();

        WebElement numberOfResults = driver.findElement(By.xpath("//h1/span[@class='BOLD']"));

        String printResults = numberOfResults.getText();
        System.out.println("Result: " + printResults);

        //driver.quit();


    }
}
