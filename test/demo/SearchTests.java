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
public class SearchTests {

    
    
    @Test
    public void ChromeTest() throws Exception {

        String searchPhrase;
        if (!getCellData(10, 0).equals(""))
            searchPhrase = getCellData(10, 0);
        else
            searchPhrase = getCellData(9, 0);

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        System.setProperty("webdriver.edge.driver", "msedgedriver.exe");
        System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
    	WebDriver driver = new ChromeDriver();
        
        //driver = login(driver,getCellData(1, 0),getCellData(1, 1));
        driver.navigate().to("http://rentup.co/");

        while(true){
            try{
                //click search button
                driver.findElement(By.className("SearchPhrase2")).click();
                Thread.sleep(1000);
                break;
            } catch(Exception e){}
        }
        Thread.sleep(2000);
        try{
            //type searchPhrase into search field
            driver.findElements(By.tagName("input")).get(1).sendKeys(searchPhrase);
            driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div.home-front > main > div > div > div > div > div > div > div:nth-child(2) > div > div > form > div.search-field-cintainer.position-relative > ul > li:nth-child(1)")).click();
            
        }
        catch(Exception ex){
            driver.close();
            assertTrue(false);
        }
        
        
            
            
        
        
    	try {
            // Check whether a certain element appears which confirms that the login was not successful
            assertEquals(false, driver.findElement(By.xpath("/html/body/div/div/div/header/nav/div/div[4]/ul/li[1]/div/button/div"))); 
        } catch(NoSuchElementException e){
            assertTrue(true);
        }
        
        // Close the web driver
        driver.close();

    }
}
