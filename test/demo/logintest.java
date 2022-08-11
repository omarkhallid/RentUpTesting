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

/**
 *
 * @author Tarek Radwan
 */
public class logintest {
      
      
      
    @Test
    public void ChromeValidLoginTest() throws Exception {
        String email, password;
        // Set Firefox Web Driver
        if(Methods.getCellData(2, 0).equals("") )
            email = Methods.getCellData(1, 0);
        else
            email = Methods.getCellData(2, 0);
        
         if(Methods.getCellData(2, 1).equals(""))
             password=Methods.getCellData(1, 1);
        
        else
             password=Methods.getCellData(2, 1);
        
        
        System.setProperty("webdriver.chrome.driver", new java.io.File(".").getCanonicalPath()+"\\" + "chromedriver.exe");
    	WebDriver driver = new ChromeDriver();
        
        driver = Methods.login(driver,email,password);
        
    	try {
            // Check whether a certain element appears which confirms that the login was not successful
            
            assertEquals(true, driver.findElement(By.className("user-avatar")).isDisplayed());
        } catch(NoSuchElementException e){
            driver.close();
            assertTrue(false);
        }
        Thread.sleep(2000);
        
        // Close the web driver
        
        
    }
}
