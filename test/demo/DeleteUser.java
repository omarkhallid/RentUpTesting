/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import static demo.AddListingTest.AddlistingTest;
import static demo.AddListingTest.LandlordEmail;

import static demo.Methods.createRandomString;
import static demo.Methods.getCellData;
import static demo.SignupTest.signup;
import static demo.logintest.adminLogin;
import static demo.logintest.login;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author Farida Osama
 */
public class DeleteUser {

    public static WebDriver Deleteuser() throws Exception {
        
        WebDriver driver1 = AddlistingTest();
        driver1.close();
        WebDriver driver = adminLogin();
        WebDriverWait wait = new WebDriverWait(driver,30);
       
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#sidebar > ul > li:nth-child(2) > a")));
        //click on users offers properties
        driver.findElement(By.cssSelector("#sidebar > ul > li:nth-child(2) > a")).click();
        
        
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#users > li:nth-child(6) > a")));
        //click on landlord
        driver.findElement(By.cssSelector("#users > li:nth-child(6) > a")).click();
        Thread.sleep(4000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#tt-table_wrapper > div:nth-child(2) > div > div.dataTables_scroll > div.dataTables_scrollFoot > div > table > tfoot > tr > td:nth-child(7) > input")));
        //search for specific user
        
        driver.findElement(By.cssSelector("#myInputTextField")).sendKeys(LandlordEmail);
        Thread.sleep(10000);                
        
        
        //click on delete
        driver.findElement(By.cssSelector("#tt-table > tbody > tr:nth-child(1) > td:nth-child(3) > button.btn.btn-xs.btn-danger.btn-delete")).click();
        Thread.sleep(2000);
       
        
        
        //click on yes delete 
        Robot rb = null;
        try {
            rb = new Robot();
        } catch (Exception ex) {
        }
        rb.setAutoDelay(250);
        for (int i = 0; i < 4; i++) {
            rb.keyPress(KeyEvent.VK_TAB);
            rb.keyRelease(KeyEvent.VK_TAB);
        }
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_SHIFT);
        rb.keyPress(KeyEvent.VK_M);

        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyRelease(KeyEvent.VK_SHIFT);
        rb.keyRelease(KeyEvent.VK_M);
        Thread.sleep(4000);
        
       
       // driver2.close();
        return driver;
    }

    @Test
    public void test() throws Exception {
        boolean x;
        WebDriver driver = Deleteuser();
        driver.close();
        WebDriver driver2 = login(LandlordEmail, "123456");
        Thread.sleep(4000);
        
         try {
                // Check whether a certain element appears which confirms that the login was not successful
                assertEquals(true, driver2.findElement(By.cssSelector("#auth-modal___BV_modal_body_ > div > span:nth-child(1) > div > div")).isDisplayed());   
                                                                        
            } catch(NoSuchElementException e){
                driver2.close();
                assertTrue(false);
                
                  
            }
        driver2.close();
    }

}
