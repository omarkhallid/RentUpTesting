/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demo;


import org.openqa.selenium.WebDriver;
import static demo.AddListingTest.AddlistingTest;
import static demo.AddListingTest.LandlordEmail;
import static demo.ApproveListing.Approvetest;

import static demo.Methods.getCellData;
import static demo.PostRequesttest.PostRequestTest;
import static demo.logintest.login;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 *
 * @author Tarek Radwan
 */
public class SendOfferTest {
    WebDriver driver=null;
    WebDriver driver1=null;
    WebDriver driver2=null;
    WebDriver driver3=null;
   
   
     @Test
    public  void OFferTest() throws Exception 
    {
       Robot rb = new Robot();
       driver= PostRequestTest();
       driver.close();
       Thread.sleep(5000);
       driver1 = AddlistingTest();
       driver1.close();
//       Thread.sleep(3000);
      driver2=Approvetest();
       driver2.close();
       Thread.sleep(4000);
       driver3=login(LandlordEmail,getCellData(18,2));
       WebDriverWait wait = new WebDriverWait(driver3,30);
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#__layout > div > header > div > div.desktop-nav > div > div > div:nth-child(2) > button")));
       //driver3.findElement(By.cssSelector("#__layout > div > header > nav > div > div.nav-links.d-none.d-lg-flex > a:nth-child(3)")).click();
      // driver3.findElements(By.tagName("a")).get(6).click();
      //open i am a landlord              
       driver3.findElement(By.cssSelector("#__layout > div > header > div > div.desktop-nav > div > div > div:nth-child(2) > button")).click();
            Thread.sleep(8000);
                                            
//        driver3.findElement(By.cssSelector("#__BVID__51 > ul > div > div > div:nth-child(1) > div.actions > a.btn.btn_outlined")).click();
          for (WebElement we : driver3.findElements(By.tagName("span")))
                    if (we.getText().contains("Marketplace")){
                        we.click();
                        break;
                    }
         Thread.sleep(2000); 
        driver3.findElement(By.cssSelector("#__layout > div > header > div > div.desktop-nav > div > div > div:nth-child(2) > button")).click();
            Thread.sleep(2000);            
       driver3.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div.mt-3.container > div.filter-options > div.filters > div > div.dropdown-container > span")).click();
       Thread.sleep(3000);
       if(getCellData(5,0).equals("z"))
       {
           driver3.findElement(By.cssSelector("#desktop-option-container > div.search-field-container > input")).sendKeys(getCellData(4,0));
       }
       else
       {
           driver3.findElement(By.cssSelector("#desktop-option-container > div.search-field-container > input")).sendKeys(getCellData(5,0));
       }
       Thread.sleep(2000);
       driver3.findElement(By.cssSelector("#desktop-option-container > div.options-container > div > div.option-label")).click();
       Thread.sleep(3000);
       driver3.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div.mt-3.container > div.b-overlay-wrap.position-relative > div.row.mt-3 > div:nth-child(1) > div > div.col-9 > div > h1")).click();
       Thread.sleep(3000);                  
       driver3.findElement(By.className("modal-footer")).findElements(By.tagName("button")).get(driver3.findElement(By.className("modal-footer")).findElements(By.tagName("button")).size()-1).click();
            
       
       Thread.sleep(3000);
       driver3.findElement(By.tagName("input")).click();
       rb.keyPress(KeyEvent.VK_CONTROL);
       rb.keyPress(KeyEvent.VK_SHIFT);
       rb.keyPress(KeyEvent.VK_RIGHT);
       rb.keyRelease(KeyEvent.VK_CONTROL);
       rb.keyRelease(KeyEvent.VK_SHIFT);
       rb.keyRelease(KeyEvent.VK_RIGHT);
       for(int i=0;i<5;i++)
       {
           rb.keyPress(KeyEvent.VK_BACK_SPACE);
           rb.keyRelease(KeyEvent.VK_BACK_SPACE);
       }

       Thread.sleep(4000);
       driver3.findElement(By.tagName("input")).sendKeys("9898");
       Thread.sleep(3000);
       //driver3.findElement(By.className("b-sidebar-body")).findElements(By.tagName("button")).get(driver3.findElement(By.className("b-sidebar-body")).findElements(By.tagName("button")).size()-1).click();
//       for (WebElement we : driver.findElements(By.tagName("button")))
//               if (we.getText().equals("Best and final offer"))
//                        we.click();
//             Thread.sleep(1000);
         for (WebElement we : driver3.findElements(By.tagName("button")))
                    if (we.getText().contains("Best and final offer")){
                        we.click();
                        break;
                    }
         Thread.sleep(2000);
         // go to my properties
         driver3.findElement(By.cssSelector("#__layout > div > header > div > div.desktop-nav > div > div > div:nth-child(2) > button")).click();
            Thread.sleep(4000);
          for (WebElement we : driver3.findElements(By.tagName("a")))
                    if (we.getText().contains("My Offers")){
                        we.click();
                        break;
                    }
         Thread.sleep(4000);
         
         
         
         JavascriptExecutor js = (JavascriptExecutor) driver3;
         js.executeScript("window.scrollBy(0,-1200)");
         
         try {
            // Check whether a certain element appears which confirms that the login was not successful
            assertEquals(true, driver3.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div.b-overlay-wrap.position-relative > div > div > div:nth-child(1) > a > div")).isDisplayed()); 
        } catch(NoSuchElementException e){
            assertTrue(false);
            driver3.close();
        }
        Thread.sleep(2000);
        
        // Close the web driver
        driver3.close();
    }
}
