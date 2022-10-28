/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demo;

import static demo.Methods.domain;
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
public class DeleteOffer {
     static boolean x=true;
    public  static WebDriver deleteOffer() throws Exception
    {
        
        WebDriver driver = adminLogin();
        WebDriverWait wait = new WebDriverWait(driver,30);
         
          //Thread.sleep(3000);
          wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#sidebar > ul > li:nth-child(2) > a")));
          driver.findElement(By.cssSelector("#sidebar > ul > li:nth-child(2) > a")).click();
          //Thread.sleep(2000);
          wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#users > li:nth-child(5) > a")));
          driver.findElement(By.cssSelector("#users > li:nth-child(3) > a")).click();
          //Thread.sleep(20000);    
          wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#tt-table_wrapper > div:nth-child(2) > div > div.dataTables_scroll > div.dataTables_scrollFoot > div > table > tfoot > tr > td:nth-child(7) > input")));
          if(getCellData(32,0).equals("test1"))
          {
              driver.findElement(By.cssSelector("#tt-table_wrapper > div:nth-child(2) > div > div.dataTables_scroll > div.dataTables_scrollFoot > div > table > tfoot > tr > td:nth-child(7) > input")).sendKeys("test1");
          }
          else
          {
              driver.findElement(By.cssSelector("#tt-table_wrapper > div:nth-child(2) > div > div.dataTables_scroll > div.dataTables_scrollFoot > div > table > tfoot > tr > td:nth-child(7) > input")).sendKeys(getCellData(32,0));
          }
          Thread.sleep(2000);
          Robot rb = null;
          try {
            rb = new Robot();
        } catch (Exception ex) {
        }
          rb.keyPress(KeyEvent.VK_ENTER);
          rb.keyRelease(KeyEvent.VK_ENTER);
          Thread.sleep(8000);
                                                            
          String text=driver.findElement(By.xpath("//*[@id=\"tt-table\"]/tbody/tr[1]/td[3]")).getText();
          System.out.println(text);                         
          Thread.sleep(2000);
          driver.findElement(By.cssSelector("#tt-table > tbody > tr:nth-child(1) > td:nth-child(2) > a > i")).click();
          Thread.sleep(5000); 
          
        rb.setAutoDelay(250);
       
        rb.keyPress(KeyEvent.VK_TAB);
        rb.keyRelease(KeyEvent.VK_TAB);
        
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_SHIFT);
        rb.keyPress(KeyEvent.VK_M);

        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyRelease(KeyEvent.VK_SHIFT);
        rb.keyRelease(KeyEvent.VK_M);
        Thread.sleep(2000);
        if(domain.equals("https://rentup.co/"))
        {
        driver.get("https://api.rentup.co/dashboard/offers#");
        driver.navigate().refresh();
        }
        else
        {
            driver.get("https://api.rentup.com.eg/dashboard/offers#");
            driver.navigate().refresh();
        }
        Thread.sleep(10000);
        if(getCellData(32,0).equals("test1"))
          {
              driver.findElement(By.cssSelector("#tt-table_wrapper > div:nth-child(2) > div > div.dataTables_scroll > div.dataTables_scrollFoot > div > table > tfoot > tr > td:nth-child(7) > input")).sendKeys("test1");
          }
          else
          {
              driver.findElement(By.cssSelector("#tt-table_wrapper > div:nth-child(2) > div > div.dataTables_scroll > div.dataTables_scrollFoot > div > table > tfoot > tr > td:nth-child(7) > input")).sendKeys(getCellData(32,0));
          }
        Thread.sleep(3000);
        Robot rb2 = null;
          try {
            rb2 = new Robot();
        } catch (Exception ex) {
        }
          Thread.sleep(3000);
          rb2.keyPress(KeyEvent.VK_ENTER);
          rb2.keyRelease(KeyEvent.VK_ENTER);;
        Thread.sleep(8000);
          if(driver.findElement(By.xpath("//*[@id=\"tt-table\"]/tbody/tr[1]/td[3]")).getText().equals(text))
          {
              x=false;
          }
          
        
        return driver;
        
    }
   @Test 

   public  void DeleteOffertest() throws Exception
    {  
      
         WebDriver driver=null;
        driver = deleteOffer();
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
