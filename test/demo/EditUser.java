/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import static demo.AddListingTest.LandlordEmail;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import static demo.Methods.*;
import static demo.PostRequesttest.TenantEmail;
import static demo.SignupTest.signup;
import static demo.logintest.adminLogin;
import static demo.logintest.login;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.sql.Driver;
import org.openqa.selenium.WebElement;

/**
 *
 * @author Farida Osama
 */
public class EditUser {

    public static WebDriver Edituser() throws Exception {

        WebDriver driver = adminLogin();
        Robot rb = new Robot();
        WebDriver driver1 = null;
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#sidebar > ul > li:nth-child(2) > a")).click();
        Thread.sleep(2000);
        if(getCellData(25,0).equals("Tenant"))
        {
            driver.findElement(By.cssSelector("#users > li:nth-child(1) > a")).click();
        }
        else
        {
            driver.findElement(By.cssSelector("#users > li:nth-child(6) > a")).click();
        }
        
        Thread.sleep(20000);
        driver.findElement(By.cssSelector("#tt-table_wrapper > div:nth-child(1) > div.m-auto.float-right.col-sm-12.col-md-6 > div > button.dt-button.btn.btn-primary.btn-sm > span > i")).click();
        Thread.sleep(3000);
        if(getCellData(25,0).equals("Tenant"))
        {
            driver.findElement(By.cssSelector("#name")).sendKeys("Tenant");
            Thread.sleep(2000);
            driver.findElement(By.cssSelector("#email")).sendKeys(getCellData(25,1));
            Thread.sleep(2000);
        }
        else
        {
            driver.findElement(By.cssSelector("#name")).sendKeys("Landlord");
            Thread.sleep(2000);
            driver.findElement(By.cssSelector("#email")).sendKeys(getCellData(25,1));
            Thread.sleep(2000);
        }
        driver.findElement(By.cssSelector("#password")).sendKeys("123456");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#mobile")).sendKeys("01111111");
        Thread.sleep(4000);
        if(getCellData(25,0).equals("Tenant"))
        {
            driver.findElement(By.cssSelector("#tenant_form > div > div.col-12.mt-2 > div > div:nth-child(1) > button")).click();
            
            Thread.sleep(2000);
        }
        else
        {
            driver.findElement(By.cssSelector("#landlord_form > div > div.col-12.mt-2 > div > div:nth-child(1) > button")).click();
            Thread.sleep(2000);
        }
        
        Thread.sleep(20000);
         if(getCellData(25,0).equals("Tenant"))
        {
           driver.findElement(By.cssSelector("#tt-table_wrapper > div:nth-child(2) > div > div.dataTables_scroll > div.dataTables_scrollFoot > div > table > tfoot > tr > td:nth-child(7) > input")).sendKeys(getCellData(25,1));
            Thread.sleep(5000);
        }
        else
        {
            driver.findElement(By.cssSelector("#tt-table_wrapper > div:nth-child(2) > div > div.dataTables_scroll > div.dataTables_scrollFoot > div > table > tfoot > tr > td:nth-child(7) > input")).sendKeys(getCellData(25,1));
            Thread.sleep(5000);
        }
        driver.findElement(By.cssSelector("#tt-table > tbody > tr:nth-child(1) > td:nth-child(3) > a")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#email")).clear();
        Thread.sleep(4000);
        if(getCellData(25,0).equals("Tenant"))
        {
            driver.findElement(By.cssSelector("#email")).sendKeys("modified"+TenantEmail);
        }
        else
        {
            driver.findElement(By.cssSelector("#email")).sendKeys("modified"+LandlordEmail);
        }
        
        Thread.sleep(8000);
        if(getCellData(25,0).equals("Tenant"))
        {
          driver.findElement(By.cssSelector("#tenant_update_form > div > div.col-12.mt-2 > div > div:nth-child(1) > button")).click();
        }
        else
        {
         driver.findElement(By.cssSelector("#landlord_update_form > div > div.col-12.mt-2 > div > div:nth-child(1) > button")).click();
        }
        Thread.sleep(8000); 
        
       
        if(getCellData(25,0).equals("Tenant"))
        {
             driver1 = login("modified"+TenantEmail, "123456");
        }
        else
        {
             driver1 = login("modified"+LandlordEmail, "123456");
        }
        Thread.sleep(6000);
        try {
            // Check whether a certain element appears which confirms that the login was not successful
            assertEquals(true, driver1.findElements(By.tagName("button")).get(3).isDisplayed());
             driver1.close();
        } catch (NoSuchElementException e) {

            assertTrue(false);
            driver1.close();
        }

        return driver;
    }

    @Test
    public void test() throws Exception {
        WebDriver driver = Edituser();
        driver.close();
    }

}
