package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class practiceCybertekForgotPassword {

    public static void main(String[] args) throws InterruptedException {

        /*
        Open Chrome browser
        2. Go to http://practice.cybertekschool.com/forgot_password Links to an external site.
        3. Locate all the WebElements on the page using XPATH locator only (total of 6)
            a. “Home” link
            b. “Forgot password” header
            c. “E-mail” text
            d. E-mail input box
            e. “Retrieve password” button
        4.Print text of a,b,c,e and put some email to d
         */

        //  1
        WebDriver driver = BrowserFactory.getDriver("chrome");
        //  2
        driver.get("http://practice.cybertekschool.com/forgot_password");

        //  a
        WebElement homeLink = driver.findElement(By.xpath("//a[@class=\"nav-link\"]"));
        String homeLinkText = homeLink.getText();
        System.out.println(homeLinkText);

        //  b
        WebElement forgotPasswordHeader = driver.findElement(By.xpath("(//h2)"));
        String  forgotPasswordHeaderText = forgotPasswordHeader.getText();
        System.out.println(forgotPasswordHeaderText);

        //  c
        WebElement emailText = driver.findElement(By.xpath("//label[contains(@for, 'email')]"));
        // WebElement emailText = driver.findElement(By.xpath("(//label)"));    //  second option
        String emailTextText = emailText.getText();
        System.out.println(emailTextText);

        //  d
        WebElement emailInputBox = driver.findElement(By.xpath("//input[@name='email']"));
        // WebElement emailInputBox = driver.findElement(By.xpath("(//input)"));
        // WebElement emailInputBox = driver.findElement(By.xpath("(//input[contains(@name, 'email')])"));
        emailInputBox.sendKeys("mike@smith.com");

        Thread.sleep(3000);


        //  e
        WebElement retrievePassword = driver.findElement(By.xpath("//i[contains(@class, 'icon-2x')]"));
        String retrievePasswordText = retrievePassword.getText();
        System.out.println(retrievePasswordText);

        driver.quit();



    }


}
