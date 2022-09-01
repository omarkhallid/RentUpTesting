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

    
    public static WebDriver signup(String name, String email, String password, String phone) throws InterruptedException{
        
        WebDriver driver = createDriver();
        
        if(Methods.platform.equals("Desktop"))
        {
            Thread.sleep(2000);
            driver.findElement(By.cssSelector("#nav-collapse > ul > li:nth-child(3) > button")).click();
            driver.findElement(By.cssSelector("p.form-message:nth-child(8) > button:nth-child(1)")).click();

            driver.findElements(By.tagName("input")).get(0).sendKeys(name);
            driver.findElements(By.tagName("input")).get(1).sendKeys(email);
            driver.findElements(By.tagName("input")).get(2).sendKeys(password);
            driver.findElements(By.tagName("input")).get(3).sendKeys(phone);

            driver.findElement(By.cssSelector("button.btn:nth-child(6)")).click();
            Thread.sleep(10000);
        }
        else if(Methods.platform.equals("Mobile"))
        {
            
            driver.findElement(By.className("burger-menu")).click();
            Thread.sleep(1000);
            driver.findElement(By.className("side-bar-container")).findElement(By.tagName("a")).click();
            driver.findElements(By.className("form-message")).get(1).findElement(By.tagName("button")).click();
            driver.findElements(By.tagName("input")).get(0).sendKeys(name);
            driver.findElements(By.tagName("input")).get(1).sendKeys(email);
            driver.findElements(By.tagName("input")).get(2).sendKeys(password);
            driver.findElements(By.tagName("input")).get(3).sendKeys(phone);
            Thread.sleep(2000);
            driver.findElement(By.cssSelector("#auth-modal___BV_modal_body_ > div > span:nth-child(2) > form > button")).click();
            Thread.sleep(5000);
            
        }
        
        return driver;
    }
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

