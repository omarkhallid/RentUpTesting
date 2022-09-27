/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demo;

import static demo.AddListingTest.AddlistingTest;
import static demo.DeleteUser.Deleteuser;
import static demo.Methods.LandlordEmail;
import static demo.Methods.TenantEmail;
import static demo.Methods.getCellData;
import static demo.PostRequesttest.PostRequestTest;
import static demo.logintest.adminLogin;
import static demo.logintest.login;
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
public class DeleteTenant {
     public static WebDriver Deletetenant() throws Exception {
        WebDriver driver2 = PostRequestTest();
        WebDriver driver = adminLogin();
        Thread.sleep(2000);

        //click on users offers properties
        driver.findElement(By.cssSelector("#sidebar > ul > li:nth-child(2) > a")).click();
        Thread.sleep(2000);

        //click on Tenant
        driver.findElement(By.cssSelector("#users > li:nth-child(1) > a")).click();
        Thread.sleep(20000);

        //search for specific user
        driver.findElement(By.cssSelector("#tt-table_wrapper > div:nth-child(2) > div > div.dataTables_scroll > div.dataTables_scrollFoot > div > table > tfoot > tr > td:nth-child(8) > input")).sendKeys(TenantEmail);
        
        Thread.sleep(2000);
        Robot rb1 = new Robot();
        rb1.keyPress(KeyEvent.VK_ENTER);
        rb1.keyRelease(KeyEvent.VK_ENTER);
        
        Thread.sleep(2000);
        
         //click on delete
        driver.findElement(By.cssSelector("#tt-table > tbody > tr > td:nth-child(3) > button.btn.btn-xs.btn-danger.btn-delete")).click();
        driver.switchTo().alert().accept();
        Thread.sleep(2000);
        WebDriver driver1 = login(TenantEmail, "123456");
        
        try {
            String txt = driver1.findElement(By.cssSelector("#auth-modal___BV_modal_body_ > div > span:nth-child(1) > div > div")).getText();
            assertEquals("users.validation_messages.wrong_email_or_password" , txt);
        } catch (NoSuchElementException e) {

           
            driver2.close();
            driver1.close();
            driver.close();
            
        }
      
        return driver;
    }
    
  
                    
     
       @Test
    public void test() throws Exception {
        WebDriver driver = Deletetenant();
        driver.close();
    }
    
}
