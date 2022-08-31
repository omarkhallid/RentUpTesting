                /*

                                        

  
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package demo;

import static demo.Methods.*;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author Omar Fekry
 */
public class AddListingTest {

    Methods m = new Methods();
    
    @Test
    public void ChromeTest() throws Exception {

        WebDriver driver=null;
        driver = m.AddListing();
           
        Thread.sleep(8000);

        //check if property was added in my properties
        boolean added = false;
        for (WebElement we : driver.findElements(By.className("property-data"))){
            if (we.findElement(By.tagName("strong")).getText().contains(propertyName.substring(2))){
                added = true;
                break;
            }
        }   
        try{
            assertTrue(added);
        } catch (Exception ex){}

        driver.close();
        
    }

