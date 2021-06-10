package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class wikipediaTest {

    public static void main(String[] args) throws InterruptedException {

        /*
        Go to wikipedia.org (Links to an external site.)
        enter search term `selenium webdriver`
        click on search button
        click on search result `Selenium (software)`
        verify url ends with `Selenium_(software)'
         */

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://www.wikipedia.org/");

        WebElement searchBar = driver.findElement(By.xpath("//input[@id='searchInput']"));
        searchBar.sendKeys("selenium webdriver");

        Thread.sleep(2500);

        WebElement clickSearch = driver.findElement(By.xpath("//button[contains(@class, 'pure-button')]"));
        clickSearch.click();

        Thread.sleep(3000);

        WebElement seleniumSoftware = driver.findElement(By.xpath("//a[@href='/wiki/Selenium_(software)']"));
        seleniumSoftware.click();

        String currentUrl = driver.getCurrentUrl();

        if(currentUrl.endsWith("Selenium_(software)")) {
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
            System.out.println(currentUrl);
        }


    }
}
