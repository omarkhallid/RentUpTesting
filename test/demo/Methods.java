/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import static org.junit.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author Omar Fekry
 */
public class Methods {
    
    public static String browser = "Chrome", domain = "https://dev.rentup.co/";

    public static String getCellData(int row, int col) throws Exception {
        XSSFWorkbook ExcelWBook;
        XSSFSheet ExcelWSheet;

        try {
            // Open the Excel file
            FileInputStream ExcelFile = new FileInputStream(new java.io.File(".").getCanonicalPath() + "\\" + "Login.xlsx");

            // Access the required test data sheet
            ExcelWBook = new XSSFWorkbook(ExcelFile);
            ExcelWSheet = ExcelWBook.getSheet("Sheet1");
            DataFormatter formatter = new DataFormatter();
            String cellData = formatter.formatCellValue(ExcelWSheet.getRow(row).getCell(col));
            ExcelWBook.close();
            return cellData;
        }
        catch (IOException e){
            return "Error in opening the file";
        }
    }
    
    public static void setCellData(final String val, int row, int col) {
        XSSFWorkbook ExcelWBook;
        XSSFSheet ExcelWSheet;

        try {
            // Open the Excel file
            FileInputStream ExcelFile = new FileInputStream(new java.io.File(".").getCanonicalPath() + "\\" + "Login.xlsx");

            // Access the required test data sheet
            ExcelWBook = new XSSFWorkbook(ExcelFile);
            ExcelWSheet = ExcelWBook.getSheet("Sheet1");
            
            if (ExcelWSheet.getRow(row).getCell(col) == null)
                ExcelWSheet.getRow(row).createCell(col, 1);
            
            ExcelWSheet.getRow(row).getCell(col).setCellValue(val);
            
            FileOutputStream out = new FileOutputStream(new File(new java.io.File(".").getCanonicalPath() + "\\" + "Login.xlsx"));
            ExcelWBook.write(out);
            out.close();
            ExcelWBook.close();
            System.out.println("Saved " + val + " to (" + row + ", " + col + ")");
        }
        catch (IOException e){
            System.out.println("Couldn't save to file");
        }
    }
    
    
    public static WebDriver login(String email ,String password) throws Exception{
        
    	

        // Puts an Implicit wait, Will wait for 10 seconds before throwing exception
        //driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        
        System.setProperty("webdriver.chrome.driver", new java.io.File(".").getCanonicalPath()+"\\" + "chromedriver.exe");
        System.setProperty("webdriver.edge.driver", new java.io.File(".").getCanonicalPath()+"\\" + "msedgedriver.exe");
        System.setProperty("webdriver.gecko.driver", new java.io.File(".").getCanonicalPath() + "\\" + "geckodriver.exe");
        
        WebDriver driver = null;
        
        switch(browser){
            case "Chrome":
                driver = new ChromeDriver();
                break;
            case "Edge":
                driver = new EdgeDriver();
                break;
            case "Firefox":
                driver = new FirefoxDriver();
                break;
        }        
      
        
        driver.manage().window().maximize();
        // Launch website
        driver.navigate().to(domain);
        // Maximize the browser
        
        
        // Click on Sign in button
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#nav-collapse > ul > li:nth-child(3) > button")).click();
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
    
    public static WebDriver createDriver(){
        
        try{
            System.setProperty("webdriver.chrome.driver", new java.io.File(".").getCanonicalPath() +"\\" + "chromedriver.exe");
            System.setProperty("webdriver.edge.driver", new java.io.File(".").getCanonicalPath() +"\\" + "msedgedriver.exe");
            System.setProperty("webdriver.gecko.driver", new java.io.File(".").getCanonicalPath() + "\\" + "geckodriver.exe");
        } catch (Exception ex){
            System.out.println("Couldn't find drivers in path");
        }
        
        WebDriver driver = null;
        
        switch(browser){
            case "Chrome":
                driver = new ChromeDriver();
                break;
            case "Edge":
                driver = new EdgeDriver();
                break;
            case "Firefox":
                driver = new FirefoxDriver();
                break;
        }
        
        driver.manage().window().maximize();
        driver.navigate().to(domain);
        return driver;
        
    }
    
}
