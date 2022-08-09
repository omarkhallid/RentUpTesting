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
     Tests t = new Tests();   
      public void setCellData(String value, int rownum, int colnum) throws Exception {
        XSSFSheet ExcelWSheet;
        XSSFWorkbook ExcelWBook;
        FileInputStream ExcelFile = new FileInputStream(new java.io.File(".").getCanonicalPath() + "\\" + "Login.xlsx");
            // Access the required test data sheet
            ExcelWBook = new XSSFWorkbook(ExcelFile);
            ExcelWSheet = ExcelWBook.getSheet("Sheet1");
            FileOutputStream Fos =new FileOutputStream(new java.io.File(".").getCanonicalPath() + "\\" + "Login.xlsx");
 
            XSSFRow row=ExcelWSheet.getRow(rownum);
            
            if(row ==null)
            {
                row=ExcelWSheet.createRow(rownum);
            }
             XSSFCell cell=row.getCell(colnum);
            if(cell ==null)
            {
                cell=row.createCell(colnum);
            }
            cell.setCellValue(value);
            Fos = new FileOutputStream(new java.io.File(".").getCanonicalPath() + "\\" + "Login.xlsx");
            ExcelWBook.write(Fos);
            Fos.close(); 
            ExcelWBook.close();
    }
      
      
      
    @Test
    public void ChromeValidLoginTest() throws Exception {
        String email="";
        String password="";
        // Set Firefox Web Driver
        if(t.getCellData(2, 0).equals("z") )
        {
             email=t.getCellData(1, 0);
        }
        else
        {
             email=t.getCellData(2, 0);
        }
         if(t.getCellData(2, 1).equals("z"))
        {
             password=t.getCellData(1, 1);
        }
        else
        {
             password=t.getCellData(2, 1);
        }   
        
        System.setProperty("webdriver.chrome.driver", new java.io.File(".").getCanonicalPath()+"\\" + "chromedriver.exe");
    	WebDriver driver = new ChromeDriver();
        
        driver = t.login(driver,email,password);
        
    	try {
            // Check whether a certain element appears which confirms that the login was not successful
            assertEquals(true, driver.findElement(By.xpath("/html/body/div/div/div/header/nav/div/div[4]/ul/li[1]/div/button/div")).isDisplayed()); 
        } catch(NoSuchElementException e){
            assertTrue(false);
        }
        Thread.sleep(2000);
        
        // Close the web driver
        driver.close();
        
    }
}
