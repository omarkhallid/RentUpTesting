/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demo;

import static demo.AddListingTest.AddlistingTest;
import static demo.Methods.getCellData;
import static demo.logintest.adminLogin;
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
 * @author Tarek Radwan
 */
public class DeleteProperty {
    static boolean x=true;
    public  static WebDriver deleteProperty() throws Exception
    {
        
        WebDriver driver = adminLogin();
        WebDriverWait wait = new WebDriverWait(driver,30);
         
          //Thread.sleep(3000);
          wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#sidebar > ul > li:nth-child(2) > a")));
          driver.findElement(By.cssSelector("#sidebar > ul > li:nth-child(2) > a")).click();
          //Thread.sleep(2000);
          wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#users > li:nth-child(5) > a")));
          driver.findElement(By.cssSelector("#users > li:nth-child(5) > a")).click();
          //Thread.sleep(20000);    
          wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#properties-table > tbody > tr:nth-child(1) > td:nth-child(2) > label > span")));
          if(getCellData(32,0).equals("test1"))
          {
              driver.findElement(By.cssSelector("#myInputTextField")).sendKeys("test1");
          }
          else
          {
              driver.findElement(By.cssSelector("#myInputTextField")).sendKeys(getCellData(32,0));
          }
          Thread.sleep(10000);
         
          String text=driver.findElement(By.cssSelector("#properties-table > tbody > tr:nth-child(1) > td:nth-child(3)")).getText();
          System.out.println(text);                         
          Thread.sleep(2000);
          driver.findElement(By.cssSelector("#properties-table > tbody > tr:nth-child(1) > td:nth-child(2) > button")).click();
          Thread.sleep(5000); 
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
        
          if(driver.findElement(By.cssSelector("#properties-table > tbody > tr:nth-child(1) > td:nth-child(3)")).getText().equals(text))
          {
              x=false;
          }
          
        
        return driver;
        
    }
   @Test 
    public  void DeletePropertytest() throws Exception
    {  
      
         WebDriver driver=null;
        driver = deleteProperty();
        try {
            // Check whether a certain element appears which confirms that the login was not successful
            assertEquals(true, x); 
            driver.close();
        } catch(NoSuchElementException e){
            driver.close();
            assertTrue(false); 
            
        }
        
    }
    
}
