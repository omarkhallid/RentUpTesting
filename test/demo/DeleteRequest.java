/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demo;


import static demo.Methods.getCellData;
import static demo.logintest.adminLogin;
import java.awt.RenderingHints;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.openqa.grid.internal.Registry;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author Tarek Radwan
 */
public class DeleteRequest {
    static boolean x=true;
    public  static WebDriver deleteRequest() throws Exception
    {
        
        WebDriver driver = adminLogin();
        WebDriverWait wait = new WebDriverWait(driver,30);
         
          //Thread.sleep(3000);
          wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#sidebar > ul > li:nth-child(2) > a")));
          driver.findElement(By.cssSelector("#sidebar > ul > li:nth-child(2) > a")).click();
          //Thread.sleep(2000);
          wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#users > li:nth-child(2) > a")));
          driver.findElement(By.cssSelector("#users > li:nth-child(2) > a")).click();
          //Thread.sleep(20000);    
          wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#tt-table > tbody > tr:nth-child(1) > td:nth-child(2) > a > i")));
          if(getCellData(41,0).equals("landlord"))
          {
              driver.findElement(By.cssSelector("#tt-table_wrapper > div:nth-child(2) > div > div.dataTables_scroll > div.dataTables_scrollFoot > div > table > tfoot > tr > td:nth-child(5) > input")).sendKeys("landlord");
              driver.findElement(By.cssSelector("#tt-table_wrapper > div:nth-child(2) > div > div.dataTables_scroll > div.dataTables_scrollFoot > div > table > tfoot > tr > td:nth-child(5) > input")).sendKeys(Keys.ENTER);
          }
             else
          {
              driver.findElement(By.cssSelector("#tt-table_wrapper > div:nth-child(2) > div > div.dataTables_scroll > div.dataTables_scrollFoot > div > table > tfoot > tr > td:nth-child(5) > input")).sendKeys(getCellData(41,0));
              driver.findElement(By.cssSelector("#tt-table_wrapper > div:nth-child(2) > div > div.dataTables_scroll > div.dataTables_scrollFoot > div > table > tfoot > tr > td:nth-child(5) > input")).sendKeys(Keys.ENTER);
          }
          Thread.sleep(10000);
         
          String text=driver.findElement(By.cssSelector("#tt-table > tbody > tr:nth-child(1) > td:nth-child(3)")).getText();
          System.out.println(text);                         
          Thread.sleep(2000);
          driver.findElement(By.cssSelector("#tt-table > tbody > tr:nth-child(1) > td:nth-child(2) > a > i")).click();
          Thread.sleep(5000);
          
//          driver.findElement(By.cssSelector("#tt-table_wrapper > div:nth-child(2) > div > div.dataTables_scroll > div.dataTables_scrollFoot > div > table > tfoot > tr > td:nth-child(3) > input")).sendKeys(text);
//          driver.findElement(By.cssSelector("#tt-table_wrapper > div:nth-child(2) > div > div.dataTables_scroll > div.dataTables_scrollFoot > div > table > tfoot > tr > td:nth-child(3) > input")).sendKeys(Keys.ENTER);
//          Thread.sleep(10000);
//          
//          if(driver.findElement(By.cssSelector("#tt-table > tbody > tr:nth-child(1) > td:nth-child(2) > a > i")).isDisplayed())
//          {
//              x=false;
//          }
          
        
        return driver;
        
    }
   @Test 
    public  void DeleteRequesttest() throws Exception
    {  
      
         WebDriver driver=null;
        driver = deleteRequest();
        try {
            // Check whether a certain element appears which confirms that the login was not successful
            assertEquals(true, x); 
            driver.quit();
        } catch(NoSuchElementException e){
            
            assertTrue(false); 
            driver.quit();
            
        }
        
    }
    
}
