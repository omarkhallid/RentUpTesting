/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package demo;

import static demo.Methods.*;
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
 * @author Omar Fekry
 */
public class SearchTest {

    
    
    @Test
    public void ChromeTest() throws Exception {

        String searchPhrase;
        WebDriver driver = createDriver();
        
        if (!getCellData(10, 0).equals(""))
            searchPhrase = getCellData(10, 0);
        else
            searchPhrase = getCellData(9, 0);

        if (platform.equals("Desktop")){
            while(true){
                try{
                    //click search button
                    driver.findElement(By.className("SearchPhrase2")).click();
                    Thread.sleep(1000);
                    break;
                } catch(Exception e){}
            }
            Thread.sleep(3000);
            try{
                //type searchPhrase into search field
                driver.findElements(By.tagName("input")).get(1).sendKeys(searchPhrase);
               
                Thread.sleep(5000);
                //type choose first option from dropdown list
                driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div.home-front > main > div > div > div > div > div > div > div:nth-child(2) > div > div > form > div.search-field-cintainer.position-relative > ul > li:nth-child(1)")).click();
                Thread.sleep(4000);
   

            }
            catch(Exception ex){
                driver.close();
                assertTrue(false);
            }

            try {
                boolean flag = driver.findElement(By.className("property-container")).findElement(By.tagName("a")).getAttribute("href").contains(searchPhrase.toLowerCase());
                driver.close();
                assertEquals(true, flag); 
            } catch(NoSuchElementException e){
                driver.close();
                assertTrue(false);
            }
        }
        
        else if (platform.equals("Mobile")){
            //click search button
            driver.findElement(By.tagName("h1")).click();
            Thread.sleep(3000);
            //click search box
            driver.findElements(By.tagName("input")).get(0).click();
            Thread.sleep(2000);
            
            //type search phrase
            driver.findElement(By.tagName("input")).sendKeys(searchPhrase);
            Thread.sleep(5000);
            
            //type choose first option from dropdown list
            driver.findElements(By.tagName("ul")).get(2).findElement(By.tagName("li")).click();
            Thread.sleep(4000);
            
            try {
                // Check whether a certain element appears which confirms that the login was not successful
                boolean flag = driver.findElement(By.className("property-container")).findElement(By.tagName("a")).getAttribute("href").contains(searchPhrase.toLowerCase());
                driver.close();
                assertEquals(true, flag); 
            } catch(NoSuchElementException e){
                driver.close();
                assertTrue(false);
            }
            
        }
        
    }
}
