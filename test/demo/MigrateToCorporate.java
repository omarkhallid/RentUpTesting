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
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author Farida Osama
 */
public class MigrateToCorporate {

    public static WebDriver migrateuser() throws Exception {
        //WebDriver driver2 = AddlistingTest();
        WebDriver driver = adminLogin();
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver,30);
        
        
        //Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#sidebar > ul > li:nth-child(2) > a"))); 

        //click on users offers properties
        driver.findElement(By.cssSelector("#sidebar > ul > li:nth-child(2) > a")).click();
        //Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#users > li:nth-child(6) > a")));
        
        //click on LandLords
        driver.findElement(By.cssSelector("#users > li:nth-child(6) > a")).click();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"myInputTextField\"]")));
        
        //search on certain Field by Email
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#tt-table > tbody > tr > td:nth-child(8)")));
        String name = getCellData(35,0);
        driver.findElement(By.xpath("//*[@id=\"myInputTextField\"]")).sendKeys(name);
        Thread.sleep(25000);
        String userId = "";
        String delUserId = "";
        
             try {
             //Thread.sleep(5000);
             assertEquals(true,driver.findElement(By.xpath("//*[@id=\"tt-table\"]/tbody/tr/td[4]")).isDisplayed());
             userId = driver.findElement(By.xpath("//*[@id=\"tt-table\"]/tbody/tr/td[4]")).getText();
             System.out.println(driver.findElement(By.cssSelector("#tt-table > tbody > tr > td:nth-child(8)")).getText());
             
             //click on migrate
             driver.findElement(By.cssSelector("#tt-table > tbody > tr > td:nth-child(3) > a.btn.btn-warning")).click();
             Thread.sleep(5000);
             
             //Another search for Asserting
             driver.findElement(By.xpath("//*[@id=\"myInputTextField\"]")).sendKeys(name);
             Thread.sleep(25000);
             assertEquals(true,driver.findElement(By.xpath("//*[@id=\"tt-table\"]/tbody/tr/td[4]")).isDisplayed());
             delUserId = driver.findElement(By.xpath("//*[@id=\"tt-table\"]/tbody/tr/td[4]")).getText();
             if(userId.equals(delUserId))
             {
                 boolean x = true ;
                 assertEquals(false, x);
             }
             
             
        } catch (NoSuchElementException e) {
            System.out.println("NO Such User Found! OR ");

            //driver2.close();
            driver.quit();
        }
        
      
        return driver;
    }
    
     @Test
        public void test() throws Exception {
        WebDriver driver = migrateuser();
        driver.quit();
    }

}
