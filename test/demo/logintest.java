/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import static demo.Methods.*;
import org.openqa.selenium.WebElement;

/**
 *
 * @author Tarek Radwan
 */
public class logintest {
    @Test
    public void ChromeValidLoginTest() throws Exception {
        String email="";
        String password="";
        WebDriver driver=null;
        // Set Firefox Web Driver
        if(getCellData(2, 0).equals("") )
        {
             email=getCellData(1, 0);
        }
        else
        {
             email=getCellData(2, 0);
        }
         if(getCellData(2, 1).equals(""))
        {
             password=getCellData(1, 1);
        }
        else
        {
             password=getCellData(2, 1);
        }   
         
        driver = login(email,password);
        if(platform.equals("Desktop"))
        {
        Thread.sleep(8000);
    	try {
            // Check whether a certain element appears which confirms that the login was not successful
            assertEquals(true, driver.findElements(By.tagName("button")).get(3).isDisplayed()); 
        } catch(NoSuchElementException e){
            
            assertTrue(false); 
            driver.close(); 
        }
        
        }
        if(platform.equals("Mobile"))
        {
       
            Thread.sleep(6000);
            
            try {
                // Check whether a certain element appears which confirms that the login was not successful
                assertEquals(true, driver.findElements(By.tagName("button")).get(3).isDisplayed());   
            } catch(NoSuchElementException e){
                driver.close();
                assertTrue(false);  
            }
        }
        Thread.sleep(2000);
        
        // Close the web driver
        
        driver.close();
    }
    public static WebDriver login(String email ,String password) throws Exception{
        
    	

        WebDriver driver = createDriver();
        
        
        // Click on Sign in button
        if(platform.equals("Desktop"))
        {
            
            Thread.sleep(2000);
            driver.findElement(By.cssSelector("ul.header-nav:nth-child(2) > li:nth-child(2) > div:nth-child(1) > button:nth-child(1)")).click();
            Thread.sleep(2000);
            // Enter the username and password
            try{
                //Thread.sleep(2000);
                driver.findElements(By.tagName("input")).get(0).sendKeys(email);
                driver.findElements(By.tagName("input")).get(1).sendKeys(password);
                Thread.sleep(2000);
            }
            catch(Exception ex){
                driver.close();
                assertTrue(false);
            }

            // Click on Sign in button
            try{
                driver.findElement(By.cssSelector("button.btn:nth-child(4)")).click();
            }
            catch(Exception ex){
                driver.close();
                System.out.println(ex.getMessage());
                assertTrue(false);
            }
            return driver;
        }
        else if (platform.equals("Mobile"))
        {
            try{
                Thread.sleep(2000);
                //press on login/register
                driver.findElement(By.cssSelector("#nav-collapse > ul > li:nth-child(2) > div > button")).click();
   
                Thread.sleep(2000);
                // send keys to email
                driver.findElements(By.tagName("input")).get(0).sendKeys(email);
                // send keys to password
                driver.findElements(By.tagName("input")).get(1).sendKeys(password);
                Thread.sleep(2000);
                // press login 
                driver.findElement(By.cssSelector("#auth-modal___BV_modal_body_ > div > span:nth-child(2) > form > button")).click();
                Thread.sleep(7000); 
            
            }catch(Exception ex)
            {
                driver.close();
                System.out.println(ex.getMessage());
                assertTrue(false);
            }
        }
        return driver;
    }
    

    public static WebDriver adminLogin() throws Exception{
        String oldDomain = domain;
        domain = "https://api.rentup.co/";
        
        String email = getCellData(22,0);
        String password = getCellData(22,1);
        WebDriver driver = createDriver();
        
        for(WebElement we : driver.findElement(By.className("auth-content")).findElements(By.tagName("input"))){
            if (we.getAttribute("name").equals("email")){
                we.sendKeys(email);
                break;
            }
        }
        for(WebElement we : driver.findElement(By.className("auth-content")).findElements(By.tagName("input"))){
            if (we.getAttribute("name").equals("password")){
                we.sendKeys(password);
                break;
            }
        }        
        driver.findElement(By.className("auth-content")).findElement(By.tagName("button")).click();
        domain = oldDomain;
        return driver;
    }

}
