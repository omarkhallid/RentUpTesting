/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demo;


import org.openqa.selenium.WebDriver;
import static demo.AddListingTest.AddlistingTest;
import static demo.ApproveListing.Approvetest;
import static demo.Methods.LandlordEmail;
import static demo.Methods.getCellData;
import static demo.PostRequesttest.PostRequestTest;
import static demo.logintest.login;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
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
      driver1 = AddlistingTest();
//       Thread.sleep(3000);
      driver2=Approvetest();
       driver2.close();
       Thread.sleep(4000);
       driver3=login(LandlordEmail,getCellData(18,2));
       Thread.sleep(5000);
       //driver3.findElement(By.cssSelector("#__layout > div > header > nav > div > div.nav-links.d-none.d-lg-flex > a:nth-child(3)")).click();
      // driver3.findElements(By.tagName("a")).get(6).click();
         driver3.findElement((By.cssSelector("#dropdown-divider__BV_toggle_ > div > h1"))).click();
         Thread.sleep(2000);
         driver3.findElement(By.cssSelector("#dropdown-divider > ul > li:nth-child(5) > a > a")).click();
         Thread.sleep(2000);
       driver3.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div.main-container-market.is-desktop-device > div.form-container.mt-3.container > div.row.align-items-center.mb-3 > div.col-4.order-3 > div > div > span")).click();
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
       driver3.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div.main-container-market.is-desktop-device > div.form-container.mt-3.container > div.row.mt-3 > div:nth-child(1) > div > div.col-9 > div > h1")).click();
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
         driver3.findElements(By.tagName("button")).get(16).click();
         Thread.sleep(2000);
         driver3.findElement(By.cssSelector("#dropdown-divider__BV_toggle_ > div > h1")).click();
         Thread.sleep(1000);
         driver3.findElement(By.cssSelector("#dropdown-divider > ul > li:nth-child(4) > a > a")).click();
         Thread.sleep(2000);
         
         
         
         try {
            // Check whether a certain element appears which confirms that the login was not successful
            assertEquals(true, driver3.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div > div.b-overlay-wrap.position-relative > div > div.offers-container > div > div > div.property-title.col-12")).isDisplayed()); 
        } catch(NoSuchElementException e){
            assertTrue(false);
            driver3.close();
        }
        Thread.sleep(2000);
        
        // Close the web driver
        driver3.close();
    }
}
