/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static demo.Methods.*;

/**
 *
 * @author Tarek Radwan
 */
public class logintest {
     Methods m = new Methods();   
      
      
      
      
    @Test
    public void ChromeValidLoginTest() throws Exception {
        String email="";
        String password="";
        WebDriver driver=null;
        // Set Firefox Web Driver
        if(m.getCellData(2, 0).equals("") )
        {
             email=m.getCellData(1, 0);
        }
        else
        {
             email=m.getCellData(2, 0);
        }
         if(m.getCellData(2, 1).equals(""))
        {
             password=m.getCellData(1, 1);
        }
        else
        {
             password=m.getCellData(2, 1);
        }   
         
        driver = m.login(email,password);
        
        if(platform.equals("Desktop"))
        {
            
        System.out.println(driver.findElement(By.className("Content")).isDisplayed());
        Thread.sleep(8000);
    	try {
            // Check whether a certain element appears which confirms that the login was not successful
            assertEquals(true, driver.findElement(By.className("user-avatar")).isDisplayed()); 
        } catch(NoSuchElementException e){
            driver.close();
            assertTrue(false);  
        }
        
        }
        if(platform.equals("Mobile"))
        {
            Thread.sleep(6000);
    	try {
            // Check whether a certain element appears which confirms that the login was not successful
             driver.findElement(By.cssSelector("#__layout > div > header > nav > div > div.d-flex.align-items-center.d-none.d-lg-none.mobile-header-items > button")).click();
            assertEquals(true, driver.findElement(By.cssSelector("#__layout > div > header > main > div.side-bar.active-side-bar > div > div > div > ul > li:nth-child(1) > div > div > span")).isDisplayed()); 
        } catch(NoSuchElementException e){
            driver.close();
            assertTrue(false);  
        }
        }
        Thread.sleep(2000);
        
        // Close the web driver
        
        driver.close();
    }
    
}
