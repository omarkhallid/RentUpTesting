/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demo;

import static demo.AddListingTest.AddlistingTest;
import static demo.AddListingTest.LandlordEmail;
import static demo.DeleteUser.Deleteuser;

import static demo.Methods.createRandomString;
import static demo.Methods.getCellData;
import static demo.PostRequesttest.PostRequestTest;
import static demo.SignupTest.signup;
import static demo.logintest.adminLogin;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author Farida Osama
 */
public class MigrateToCorporate {

    public static WebDriver migrateuser() throws Exception {
        WebDriver driver2 = AddlistingTest();
        WebDriver driver = adminLogin();
        Thread.sleep(2000);

        //click on users offers properties
        driver.findElement(By.cssSelector("#sidebar > ul > li:nth-child(2) > a")).click();
        Thread.sleep(2000);

        //click on landlord
        driver.findElement(By.cssSelector("#users > li:nth-child(6) > a")).click();
        Thread.sleep(25000);

        //search for specific user
        
        driver.findElement(By.cssSelector("#tt-table_wrapper > div:nth-child(2) > div > div.dataTables_scroll > div.dataTables_scrollFoot > div > table > tfoot > tr > td:nth-child(8) > input")).sendKeys(LandlordEmail);
        
        Thread.sleep(2000);
        Robot rb1 = null;
        try {
            rb1 = new Robot();
        } catch (Exception ex) {
        }
        rb1.setAutoDelay(250);
        rb1.keyPress(KeyEvent.VK_ENTER);
        rb1.keyRelease(KeyEvent.VK_ENTER);
        
        Thread.sleep(2000);
        
        

        //click on migrate
        driver.findElement(By.cssSelector("#tt-table > tbody > tr > td:nth-child(3) > a.btn.btn-warning")).click();
        Thread.sleep(3000);

        //click on users offers properties
        driver.findElement(By.cssSelector("#sidebar > ul > li:nth-child(2) > a")).click();
        Thread.sleep(3000);

        //click on corporate users
        driver.findElement(By.cssSelector("#users > li:nth-child(7) > a")).click();
        Thread.sleep(2000);
        
        //search for the migrated user
        driver.findElement(By.cssSelector("#tt-table_wrapper > div:nth-child(2) > div > div.dataTables_scroll > div.dataTables_scrollFoot > div > table > tfoot > tr > td:nth-child(6) > input")).sendKeys(LandlordEmail);
        Thread.sleep(3000);
        
          Robot rb = null;
        try {
            rb = new Robot();
        } catch (Exception ex) {
        }
        rb.setAutoDelay(250);
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(2000);
        
        
        try {
             assertEquals(true, driver.findElement(By.cssSelector("#tt-table > tbody > tr > td:nth-child(3) > a:nth-child(1)")).isDisplayed());
        } catch (NoSuchElementException e) {

            driver2.close();
            driver.close();
        }
        
      
        return driver;
    }
    
     @Test
    public void test() throws Exception {
        WebDriver driver = migrateuser();
        driver.close();
    }

}
