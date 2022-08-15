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
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author Omar Fekry
 */
public class Methods {
    
    public static String 
            browser = "Chrome", 
            domain = "https://dev.rentup.co/",
            platform = "Desktop";

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
        
    	

        WebDriver driver = createDriver();
        
        
        // Click on Sign in button
        if(platform.equals("Desktop"))
        {
            
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
        else if (platform.equals("Mobile"))
        {
            try{
                Thread.sleep(2000);
            driver.findElement(By.cssSelector("#__layout > div > header > nav > div > div.d-flex.align-items-center.d-none.d-lg-none.mobile-header-items > button")).click();
            driver.findElement(By.cssSelector("#__layout > div > header > main > div.side-bar.active-side-bar > div > div > div > ul > li:nth-child(1) > div > a.auth-button.auth-button__login.font-bold")).click();
            Thread.sleep(2000);
            driver.findElements(By.tagName("input")).get(0).sendKeys(email);
            driver.findElements(By.tagName("input")).get(1).sendKeys(password);
            Thread.sleep(2000);
            driver.findElement(By.cssSelector("#auth-modal___BV_modal_body_ > div > span:nth-child(2) > form > button")).click();
            Thread.sleep(7000);
            driver.findElement(By.cssSelector("#__layout > div > header > nav > div > div.d-flex.align-items-center.d-none.d-lg-none.mobile-header-items > button")).click();
            
            
            }catch(Exception ex)
            {
            driver.close();
            System.out.println(ex.getMessage());
            assertTrue(false);
            }return driver;
        }
        return driver;
    }
    
    public static WebDriver createDriver(){
        
        
        WebDriver driver = null;
        
        try{
            switch(browser){
                case "Chrome":
                    driver = new ChromeDriver();
                    System.setProperty("webdriver.chrome.driver", new java.io.File(".").getCanonicalPath() +"\\" + "chromedriver.exe");
                    break;
                case "Edge":
                    driver = new EdgeDriver();
                    System.setProperty("webdriver.edge.driver", new java.io.File(".").getCanonicalPath() +"\\" + "msedgedriver.exe");
                    break;
                case "Firefox":
                    driver = new FirefoxDriver();
                    System.setProperty("webdriver.gecko.driver", new java.io.File(".").getCanonicalPath() + "\\" + "geckodriver.exe");
                    break;
            }
        } catch (Exception ex){
            System.out.println("Couldn't find driver files in path");
        }
        
        
        if(platform.equals("Desktop"))
        {
             driver.manage().window().maximize();
        }
        else
        {
            Dimension dimension = new Dimension(375,812);
            driver.manage().window().setSize(dimension);
        }
        
        driver.navigate().to(domain);
        return driver;
        
    }
    
}
