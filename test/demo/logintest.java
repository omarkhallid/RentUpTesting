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
      
      
      
      
    @Test
    public void ChromeValidLoginTest() throws Exception {
        String email="";
        String password="";
        // Set Firefox Web Driver
        if(getCellData(2, 0).equals("") )
             email=getCellData(1, 0);
        else
            email = getCellData(2, 0);
        
         if(getCellData(2, 1).equals(""))
            password=getCellData(1, 1);
        else
            password=getCellData(2, 1);
        
        
        WebDriver driver = login(email,password);
        //System.out.println(driver.findElement(By.className("Content")).isDisplayed());
        Thread.sleep(8000);
    	try {
            // Check whether a certain element appears which confirms that the login was not successful
            assertEquals(true, driver.findElement(By.className("user-avatar")).isDisplayed()); 
        } catch(NoSuchElementException e){
            driver.close();
            assertTrue(false);
            
        }
        Thread.sleep(2000);
        
        // Close the web driver
        
        driver.close();
    }
}
