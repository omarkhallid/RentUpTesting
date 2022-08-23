/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package demo;

import static demo.Methods.*;
import java.util.Random;
import java.util.concurrent.TimeUnit;
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
public class SignupTest {

    
    
    @Test
    public void ChromeTest() throws Exception {

        String name, email, password, phone;
     
        if (!getCellData(19, 0).equals(""))
            name = getCellData(19, 0);
        else
            name = getCellData(18, 0);
        
        if (!getCellData(19, 1).equals(""))
            email = getCellData(19, 1);
        else {
            email = createRandomString() + "@abc.com";
        }

        if (!getCellData(19, 2).equals(""))
            password = getCellData(19, 2);
        else
            password = getCellData(18, 2);
        
        if (!getCellData(19, 3).equals(""))
            phone = getCellData(19, 3);
        else
            phone = getCellData(18, 3);
        
        WebDriver driver = signup(name, email, password, phone);
                
        if(Methods.platform.equals("Desktop"))
        {
            try {
                assertEquals(true, driver.findElement(By.className("user-avatar")).isDisplayed()); 
            } catch(NoSuchElementException e){
                driver.close();
                assertTrue(false);
            }
            driver.close();
        }
        else if(Methods.platform.equals("Mobile"))
        {
            try {
                assertEquals(true, driver.findElement(By.cssSelector("#__layout > div > header > nav > div > div.d-flex.align-items-center.d-none.d-lg-none.mobile-header-items > a > svg")).isDisplayed()); 
            } catch(NoSuchElementException e){
                driver.close();
                assertTrue(false);
            }
            driver.close();
        }
    }
       

}

