/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demo;

import static demo.Methods.login;
import static demo.Methods.platform;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author Tarek Radwan
 */
public class PostRequesttest {
    Methods m = new Methods();
    @Test
    public void ChromePostRequestTest() throws Exception {

        String email = m.getCellData(1, 0);
    	String password = m.getCellData(1, 1);
        // Set Firefox Web Driver
        WebDriver driver=null;
        
        driver = login(email,password);
        if(platform.equals("Desktop"))
        {
            Thread.sleep(8000);
        driver.findElement(By.cssSelector("#__layout > div > header > nav > div > div.nav-links.d-none.d-lg-flex > a:nth-child(2)")).click();  //post A request
        driver.findElement(By.cssSelector("#citySelect > div > span")).click();  //click on city
        
        Thread.sleep(3000);
        if(m.getCellData(5, 0).equals("z"))
        {
             driver.findElement(By.className("dropdown-search")).sendKeys(m.getCellData(4, 0)); // send data in the search bar
             driver.findElement(By.className("option-label")).click();  // click on the selected 
             Thread.sleep(3000);
             
        }
        else
        {
             driver.findElement(By.className("dropdown-search")).sendKeys(m.getCellData(5, 0));
             driver.findElement(By.className("option-label")).click();
             Thread.sleep(3000);
        }
        
        if(m.getCellData(5, 1).equals("z"))
        {
            driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div.p-3.post-form-container > div:nth-child(1) > div > div > div.row.justify-content-center > div > div:nth-child(2) > div > span")).click();
            driver.findElement(By.className("dropdown-search")).sendKeys(m.getCellData(4, 1));
            driver.findElement(By.className("option-label")).click();
             Thread.sleep(3000);
        }
        else if(!(m.getCellData(5, 1).equals("z"))&&!(m.getCellData(5, 1).equals("nothing")))
        {
            driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div.p-3.post-form-container > div:nth-child(1) > div > div > div.row.justify-content-center > div > div:nth-child(2) > div > span")).click();
            driver.findElement(By.className("dropdown-search")).sendKeys(m.getCellData(5, 1));
            driver.findElement(By.className("option-label")).click();
             Thread.sleep(3000);
        }
        
        if(m.getCellData(5, 2).equals("z"))
        {
            driver.findElement(By.cssSelector("#neighborhoodSelect > div > span")).click();
            driver.findElement(By.className("dropdown-search")).sendKeys(m.getCellData(4, 2));
            driver.findElement(By.className("option-label")).click();
            Thread.sleep(3000);
        }
        else if(!(m.getCellData(5, 2).equals("z"))&&!(m.getCellData(5, 2).equals("nothing")))
        {
            driver.findElement(By.cssSelector("#neighborhoodSelect > div > span")).click();
            driver.findElement(By.className("dropdown-search")).sendKeys(m.getCellData(5, 2));
            driver.findElement(By.className("option-label")).click();
            Thread.sleep(3000);
        }
       
        //driver.findElement(By.className("dropdown-search")).sendKeys(District);
   
       
        driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div.p-3.post-form-container > div:nth-child(1) > div > div > div.step-next-container > button")).click();
        Thread.sleep(3000);
        if(m.getCellData(5, 3).equals("z"))
        {
             driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div.p-3.post-form-container > div:nth-child(2) > main > div > div > div.mt-4.step-content.pt-2.mx-auto.col-lg-6.col-12 > div.section-white.px-minus-15 > div.row.px-2.row-cols-12 > div:nth-child(2) > button")).click();
                               
        }
        else if (m.getCellData(5, 3).equals("Nights"))
        {
           driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div.p-3.post-form-container > div:nth-child(2) > main > div > div > div.mt-4.step-content.pt-2.mx-auto.col-lg-6.col-12 > div.section-white.px-minus-15 > div.row.px-2.row-cols-12 > div:nth-child(1) > button > span")).click();
           
        }
        else
        {
            
            driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div.p-3.post-form-container > div:nth-child(2) > main > div > div > div.mt-4.step-content.pt-2.mx-auto.col-lg-6.col-12 > div.section-white.px-minus-15 > div.row.px-2.row-cols-12 > div:nth-child(3) > button > span")).click();
        }

         Thread.sleep(2000);
         if(m.getCellData(5, 4).equals("z"))
         {
             driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div.p-3.post-form-container > div:nth-child(2) > main > div > div > div.mt-4.step-content.pt-2.mx-auto.col-lg-6.col-12 > div.section-white.px-minus-15 > div.row.mt-1 > div > div > span:nth-child(4)")).click();
         }
         else if (m.getCellData(5, 4).equals("3"))
         {
              driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div.p-3.post-form-container > div:nth-child(2) > main > div > div > div.mt-4.step-content.pt-2.mx-auto.col-lg-6.col-12 > div.section-white.px-minus-15 > div.row.mt-1 > div > div > span:nth-child(3)")).click();
         }
         else
         {
              driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div.p-3.post-form-container > div:nth-child(2) > main > div > div > div.mt-4.step-content.pt-2.mx-auto.col-lg-6.col-12 > div.section-white.px-minus-15 > div.row.mt-1 > div > div > span:nth-child(8)")).click();
         }
       
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#datepicker")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("datepicker__dialog_")).findElements(By.tagName("footer")).get(1).findElements(By.tagName("button")).get(0).click();

        
        Thread.sleep(2000);     
        if(m.getCellData(5, 5).equals("z"))
        {
            driver.findElement(By.tagName("input")).sendKeys(m.getCellData(4, 5));
        }
        else
        {
            driver.findElement(By.tagName("input")).sendKeys(m.getCellData(5, 5));
        }
        Thread.sleep(2000);  
        driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div.p-3.post-form-container > div:nth-child(2) > main > div > div > div:nth-child(3) > div > div.col-7 > div > button")).click();
        Thread.sleep(4000);
        
        if(m.getCellData(5, 6).equals("z") && !(m.getCellData(5,6).equals("NA")))
           {
              driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div.p-3.post-form-container > div:nth-child(3) > div > div.mt-4.step-content.pt-2.mx-auto.col-lg-6.col-12 > div.mt-2.section-white.col-12 > main > div > div:nth-child(1) > div")).click();
               Thread.sleep(1000);
           }
       
        if(!(m.getCellData(5, 7).equals("NA")))
           {
              driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div.p-3.post-form-container > div:nth-child(3) > div > div.mt-4.step-content.pt-2.mx-auto.col-lg-6.col-12 > div.mt-2.section-white.col-12 > main > div > div:nth-child(2) > div")).click();
              Thread.sleep(1000);
           }
        
        
         if(m.getCellData(5, 9).equals("z"))
         {
             driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div.p-3.post-form-container > div:nth-child(3) > div > div.mt-4.step-content.pt-2.mx-auto.col-lg-6.col-12 > div:nth-child(2) > main > div > div:nth-child(2) > div > span")).click();
         }
         else if (m.getCellData(5, 9).equals("Furnished"))
         {
             driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div.p-3.post-form-container > div:nth-child(3) > div > div.mt-4.step-content.pt-2.mx-auto.col-lg-6.col-12 > div:nth-child(2) > main > div > div:nth-child(1) > div > span")).click();
         }
         else
         {
             driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div.p-3.post-form-container > div:nth-child(3) > div > div.mt-4.step-content.pt-2.mx-auto.col-lg-6.col-12 > div:nth-child(2) > main > div > div:nth-child(3) > div > span")).click();
         }
         if(!(m.getCellData(5, 10).equals("z")))
         {
         int x = Integer.parseInt(m.getCellData(5, 10));
         Thread.sleep(2000);
         for(int i=0;i<x-1;i++)
         {
             driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div.p-3.post-form-container > div:nth-child(3) > div > div.mt-4.step-content.pt-2.mx-auto.col-lg-6.col-12 > div:nth-child(3) > div > div.col-md-12.col-lg-8 > span > div.counter-input-contianer > button:nth-child(3) > svg")).click();
             Thread.sleep(1000);
         }
         }
         else
         {
              driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div.p-3.post-form-container > div:nth-child(3) > div > div.mt-4.step-content.pt-2.mx-auto.col-lg-6.col-12 > div:nth-child(3) > div > div.col-md-12.col-lg-8 > span > div.counter-input-contianer > button:nth-child(3) > svg")).click();
         }
         
         if(m.getCellData(5, 11).equals("z"))
            {
                     driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div.p-3.post-form-container > div:nth-child(3) > div > div.mt-4.step-content.pt-2.mx-auto.col-lg-6.col-12 > div:nth-child(4) > main > div > div:nth-child(9) > div > span")).click();
            }
         else
         {
             if(m.getCellData(5, 11).equals("Duplex"))
             {
                 driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div.p-3.post-form-container > div:nth-child(3) > div > div.mt-4.step-content.pt-2.mx-auto.col-lg-6.col-12 > div:nth-child(4) > main > div > div:nth-child(2) > div")).click();
             }
             else
             {
                 driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div.p-3.post-form-container > div:nth-child(3) > div > div.mt-4.step-content.pt-2.mx-auto.col-lg-6.col-12 > div:nth-child(4) > main > div > div:nth-child(5) > div > span")).click();
             }
         }
         Thread.sleep(2000);
         driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div.p-3.post-form-container > div:nth-child(3) > div > div:nth-child(3) > div > div.col-7 > div > button")).click();
        
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div.p-3.post-form-container > div:nth-child(3) > div > div:nth-child(5) > button")).click();
        Thread.sleep(4000);
        try {
            // Check whether a certain element appears which confirms that the login was not successful
            assertEquals(true, driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div.is-desktop-device.container > div:nth-child(1) > div > h1")).isDisplayed()); 
        } catch(NoSuchElementException e){
            assertTrue(false);
        }
        Thread.sleep(2000);
        
        // Close the web driver
        driver.close();

        }
        else
        {
        Thread.sleep(8000);
        driver.findElement(By.cssSelector("#__layout > div > div.main-content-container.home > div > div.onboardingMobile.d-sm-block.d-md-none.p-0.m-0 > div > div.bt-home-control > a.slider-post-link")).click();  //post A request
        
        driver.findElement(By.cssSelector("#citySelect > div > span")).click();  //click on city
        
        Thread.sleep(3000);
        if(m.getCellData(5, 0).equals("z"))
        {
             driver.findElement(By.className("dropdown-search")).sendKeys(m.getCellData(4, 0)); // send data in the search bar
             driver.findElement(By.className("option-label")).click();  // click on the selected 
             Thread.sleep(3000);
             
        }
        else
        {
             driver.findElement(By.className("dropdown-search")).sendKeys(m.getCellData(5, 0));
             driver.findElement(By.className("option-label")).click();
             Thread.sleep(3000);
        }
        
        if(m.getCellData(5, 1).equals("z"))
        {
            driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div.p-3.post-form-container > div:nth-child(1) > div > div > div.row.justify-content-center > div > div:nth-child(2) > div > span")).click();
            driver.findElement(By.className("dropdown-search")).sendKeys(m.getCellData(4, 1));
            driver.findElement(By.className("option-label")).click();
             Thread.sleep(3000);
        }
        else if(!(m.getCellData(5, 1).equals("z"))&&!(m.getCellData(5, 1).equals("nothing")))
        {
            driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div.p-3.post-form-container > div:nth-child(1) > div > div > div.row.justify-content-center > div > div:nth-child(2) > div > span")).click();
            driver.findElement(By.className("dropdown-search")).sendKeys(m.getCellData(5, 1));
            driver.findElement(By.className("option-label")).click();
             Thread.sleep(3000);
        }
        
        if(m.getCellData(5, 2).equals("z"))
        {
            driver.findElement(By.cssSelector("#neighborhoodSelect > div > span")).click();
            driver.findElement(By.className("dropdown-search")).sendKeys(m.getCellData(4, 2));
            driver.findElement(By.className("option-label")).click();
            Thread.sleep(3000);
        }
        else if(!(m.getCellData(5, 2).equals("z"))&&!(m.getCellData(5, 2).equals("nothing")))
        {
            driver.findElement(By.cssSelector("#neighborhoodSelect > div > span")).click();
            driver.findElement(By.className("dropdown-search")).sendKeys(m.getCellData(5, 2));
            driver.findElement(By.className("option-label")).click();
            Thread.sleep(3000);
        }
       
        //driver.findElement(By.className("dropdown-search")).sendKeys(District);
   
       
        driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div.p-3.post-form-container > div:nth-child(1) > div > div > div.step-next-container > button")).click();
        Thread.sleep(3000);
        if(m.getCellData(5, 3).equals("z"))
        {
             driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div.p-3.post-form-container > div:nth-child(2) > main > div > div > div.mt-4.step-content.pt-2.mx-auto.col-lg-6.col-12 > div.section-white.px-minus-15 > div.row.px-2.row-cols-12 > div:nth-child(2) > button")).click();
                               
        }
        else if (m.getCellData(5, 3).equals("Nights"))
        {
           driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div.p-3.post-form-container > div:nth-child(2) > main > div > div > div.mt-4.step-content.pt-2.mx-auto.col-lg-6.col-12 > div.section-white.px-minus-15 > div.row.px-2.row-cols-12 > div:nth-child(1) > button > span")).click();
           
        }
        else
        {
            
            driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div.p-3.post-form-container > div:nth-child(2) > main > div > div > div.mt-4.step-content.pt-2.mx-auto.col-lg-6.col-12 > div.section-white.px-minus-15 > div.row.px-2.row-cols-12 > div:nth-child(3) > button > span")).click();
        }

         Thread.sleep(2000);
         if(m.getCellData(5, 4).equals("z"))
         {
             driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div.p-3.post-form-container > div:nth-child(2) > main > div > div > div.mt-4.step-content.pt-2.mx-auto.col-lg-6.col-12 > div.section-white.px-minus-15 > div.row.mt-1 > div > div > span:nth-child(4)")).click();
         }
         else if (m.getCellData(5, 4).equals("3"))
         {
              driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div.p-3.post-form-container > div:nth-child(2) > main > div > div > div.mt-4.step-content.pt-2.mx-auto.col-lg-6.col-12 > div.section-white.px-minus-15 > div.row.mt-1 > div > div > span:nth-child(3)")).click();
         }
         else
         {
              driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div.p-3.post-form-container > div:nth-child(2) > main > div > div > div.mt-4.step-content.pt-2.mx-auto.col-lg-6.col-12 > div.section-white.px-minus-15 > div.row.mt-1 > div > div > span:nth-child(8)")).click();
         }
       
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#datepicker")).click();
        Thread.sleep(5000);
        driver.findElements(By.id("datepicker__dialog_")).get(0).findElements(By.tagName("footer")).get(1).findElements(By.tagName("button")).get(0).click();
        
        Thread.sleep(2000);     
        if(m.getCellData(5, 5).equals("z"))
        {
            driver.findElement(By.tagName("input")).sendKeys(m.getCellData(4, 5));
        }
        else
        {
            driver.findElement(By.tagName("input")).sendKeys(m.getCellData(5, 5));
        }
        Thread.sleep(2000);  
        driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div.p-3.post-form-container > div:nth-child(2) > main > div > div > div:nth-child(3) > div > div.col-7 > div > button")).click();
        Thread.sleep(4000);
        
        if(m.getCellData(5, 6).equals("z") && !(m.getCellData(5,6).equals("NA")))
           {
              driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div.p-3.post-form-container > div:nth-child(3) > div > div.mt-4.step-content.pt-2.mx-auto.col-lg-6.col-12 > div.mt-2.section-white.col-12 > main > div > div:nth-child(1) > div")).click();
               Thread.sleep(1000);
           }
       
        if(!(m.getCellData(5, 7).equals("NA")))
           {
              driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div.p-3.post-form-container > div:nth-child(3) > div > div.mt-4.step-content.pt-2.mx-auto.col-lg-6.col-12 > div.mt-2.section-white.col-12 > main > div > div:nth-child(2) > div")).click();
              Thread.sleep(1000);
           }
        
        
         if(m.getCellData(5, 9).equals("z"))
         {
             driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div.p-3.post-form-container > div:nth-child(3) > div > div.mt-4.step-content.pt-2.mx-auto.col-lg-6.col-12 > div:nth-child(2) > main > div > div:nth-child(2) > div > span")).click();
         }
         else if (m.getCellData(5, 9).equals("Furnished"))
         {
             driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div.p-3.post-form-container > div:nth-child(3) > div > div.mt-4.step-content.pt-2.mx-auto.col-lg-6.col-12 > div:nth-child(2) > main > div > div:nth-child(1) > div > span")).click();
         }
         else
         {
             driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div.p-3.post-form-container > div:nth-child(3) > div > div.mt-4.step-content.pt-2.mx-auto.col-lg-6.col-12 > div:nth-child(2) > main > div > div:nth-child(3) > div > span")).click();
         }
         Thread.sleep(9000);
         if(!(m.getCellData(5, 10).equals("z")))
         {
         int x = Integer.parseInt(m.getCellData(5, 10));
         
         for(int i=0;i<x-1;i++)
         {
             driver.findElements(By.cssSelector("svg")).get(20).click();
             Thread.sleep(2000);
         }
         }
         else
         {
              driver.findElements(By.tagName("svg")).get(20).click();
              Thread.sleep(1000);
         }
         Thread.sleep(10000);
         if(m.getCellData(5, 11).equals("z"))
            {
                     driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div.p-3.post-form-container > div:nth-child(3) > div > div.mt-4.step-content.pt-2.mx-auto.col-lg-6.col-12 > div:nth-child(4) > main > div > div:nth-child(9) > div")).click();
            }                                           
         else
         {
             if(m.getCellData(5, 11).equals("Duplex"))
             {
                 driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div.p-3.post-form-container > div:nth-child(3) > div > div.mt-4.step-content.pt-2.mx-auto.col-lg-6.col-12 > div:nth-child(4) > main > div > div:nth-child(2) > div")).click();
             }
             else
             {
                 driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div.p-3.post-form-container > div:nth-child(3) > div > div.mt-4.step-content.pt-2.mx-auto.col-lg-6.col-12 > div:nth-child(4) > main > div > div:nth-child(5) > div")).click();
             }
         }
         Thread.sleep(2000);
         driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div.p-3.post-form-container > div:nth-child(3) > div > div:nth-child(3) > div > div.col-7 > div > button")).click();
        
        Thread.sleep(4000);
        driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div.p-3.post-form-container > div:nth-child(3) > div > div:nth-child(5) > button")).click();
        Thread.sleep(6000);
        try {
            // Check whether a certain element appears which confirms that the login was not successful
            assertEquals(true, driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div.row.pb-3.is-mobile-device > div:nth-child(2) > svg")).isDisplayed()); 
        } catch(NoSuchElementException e){
            assertTrue(false);
        }
        Thread.sleep(2000);
        
        // Close the web driver
        driver.close();

        }
        
    }
}
