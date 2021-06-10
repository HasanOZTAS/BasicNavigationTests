package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StringUtility;
import org.openqa.selenium.WebDriver;

public class NavigationTests {

    public static void main(String[] args) {

        //chromeTest();
        //firefoxTest();
        //edgeTest();
        safariTest();

    }



        public static void chromeTest() {

            WebDriver driver = BrowserFactory.getDriver("chrome");
            driver.get("https://google.com");

            String titleGoogle = driver.getTitle();
            System.out.println("Title1 = " + titleGoogle);

            driver.navigate().to("https://etsy.com");
            String titleEtsy = driver.getTitle();
            System.out.println("Title2 = " + titleEtsy);

            driver.navigate().back();

            String nextTitleGoogle = driver.getTitle();
            StringUtility.verifyEquals(titleGoogle, nextTitleGoogle);

            driver.navigate().forward();

            String nextTitleEtsy = driver.getTitle();
            StringUtility.verifyEquals(titleEtsy, nextTitleEtsy);

            driver.quit();

        }

        public static void firefoxTest() {

            WebDriver driver = BrowserFactory.getDriver("firefox");
            driver.get("https://google.com");

            String titleGoogle = driver.getTitle();
            System.out.println("Title1 = " + titleGoogle);

            driver.navigate().to("https://etsy.com");
            String titleEtsy = driver.getTitle();
            System.out.println("Title2 = " + titleEtsy);

            driver.navigate().back();

            String nextTitleGoogle = driver.getTitle();
            StringUtility.verifyEquals(titleGoogle, nextTitleGoogle);

            driver.navigate().forward();

            String nextTitleEtsy = driver.getTitle();
            StringUtility.verifyEquals(titleEtsy, nextTitleEtsy);

            driver.quit();

        }

        public static void edgeTest() {

            WebDriver driver = BrowserFactory.getDriver("edge");
            driver.get("https://google.com");

            String titleGoogle = driver.getTitle();
            System.out.println("Title1 = " + titleGoogle);

            driver.navigate().to("https://etsy.com");
            String titleEtsy = driver.getTitle();
            System.out.println("Title2 = " + titleEtsy);

            driver.navigate().back();

            String nextTitleGoogle = driver.getTitle();
            StringUtility.verifyEquals(titleGoogle, nextTitleGoogle);

            driver.navigate().forward();

            String nextTitleEtsy = driver.getTitle();
            StringUtility.verifyEquals(titleEtsy, nextTitleEtsy);

            driver.quit();
        }

        public static void safariTest() {

        WebDriver driver = BrowserFactory.getDriver("safari");
        }



}
