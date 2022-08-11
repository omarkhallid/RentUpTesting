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
        WebDriver driver=null;
        if(Methods.getCellData(1,2).equals("Chrome"))
        {
            System.setProperty("webdriver.chrome.driver", new java.io.File(".").getCanonicalPath()+"\\" + "chromedriver.exe");
    	    driver = new ChromeDriver();
        }
        else if (Methods.getCellData(1,2).equals("Edge"))
        {
            System.setProperty("webdriver.edge.driver", new java.io.File(".").getCanonicalPath()+"\\" + "msedgedriver.exe");
    	    driver = new EdgeDriver();
        }
        else if (Methods.getCellData(1,2).equals("Firefox"))
        {
             System.setProperty("webdriver.gecko.driver", new java.io.File(".").getCanonicalPath() + "\\" + "geckodriver.exe");
             driver = new FirefoxDriver();
        }
        
        if (!getCellData(10, 0).equals(""))
            searchPhrase = getCellData(10, 0);
        else
            searchPhrase = getCellData(9, 0);

       
        driver.manage().window().maximize();
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
            Thread.sleep(5000);
            //type choose first option from dropdown list
            driver.findElements(By.tagName("ul")).get(2).findElement(By.tagName("li")).click();
            Thread.sleep(4000);
            
            
        }
        catch(Exception ex){
            driver.close();
            assertTrue(false);
        }
        
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
