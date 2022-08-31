/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demo;

import static demo.Methods.createRandomString;
import static demo.Methods.login;
import static demo.Methods.platform;
import static demo.Methods.signup;
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
 * @author Tarek Radwan
 */
public class PostRequesttest {
    Methods m = new Methods();
    @Test
    public void ChromePostRequestTest() throws Exception {
        WebDriver driver=null;
        driver = m.ChromePostRequestTest();

        Thread.sleep(5000);
        try {
            // Check whether a certain element appears which confirms that the login was not successful
            assertEquals(true, driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div.is-desktop-device.container > div:nth-child(1) > div > svg > use")).isDisplayed()); 
        } catch(NoSuchElementException e){
            assertTrue(false);
        }
        Thread.sleep(2000);
        
        // Close the web driver
        driver.close();

        }
        
    }

