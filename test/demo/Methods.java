/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package demo;


import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
            domain = "https://rentup.co/",
            platform = "Desktop",
            propertyName="";
          


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
    
    
   
    
    public static WebDriver createDriver(){
        
        
        WebDriver driver = null;
        
        try{
            switch(browser){
                case "Chrome":
                    System.setProperty("webdriver.chrome.driver", new java.io.File(".").getCanonicalPath() +"\\" + "chromedriver.exe");
                    driver = new ChromeDriver();
                    break;
                case "Edge":
                    System.setProperty("webdriver.edge.driver", new java.io.File(".").getCanonicalPath() +"\\" + "msedgedriver.exe");
                    driver = new EdgeDriver();
                    break;
                case "Firefox":
                    
                    System.setProperty("webdriver.gecko.driver", new java.io.File(".").getCanonicalPath() +"\\" + "geckodriver.exe");
                    driver = new FirefoxDriver();
                    
                    break;
            }
        } catch (Exception ex){
            System.out.println("driver ="+driver);
            System.out.println("Couldn't find driver files in path");
        }
        
        driver.manage().window().maximize();
        if(platform.equals("Mobile"))
        {
            
            Robot rb = null;
            try{
                 rb = new Robot();
            } catch(Exception ex){}
            
            driver.navigate().to(domain);
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Methods.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            rb.setAutoDelay(250);
            
            if (!browser.equals("Firefox")){
                rb.keyPress(KeyEvent.VK_F12);
                rb.keyRelease(KeyEvent.VK_F12);
            }
            
            if (browser.equals("Edge")){
                for (int i = 0; i < 4; i++){
                    rb.keyPress(KeyEvent.VK_TAB);
                    rb.keyRelease(KeyEvent.VK_TAB);
                }
                rb.keyPress(KeyEvent.VK_ENTER);
                rb.keyRelease(KeyEvent.VK_ENTER);
            }
            
            
            rb.keyPress(KeyEvent.VK_CONTROL);
            rb.keyPress(KeyEvent.VK_SHIFT);
            rb.keyPress(KeyEvent.VK_M);
            
            rb.keyRelease(KeyEvent.VK_CONTROL);
            rb.keyRelease(KeyEvent.VK_SHIFT);                                       
            rb.keyRelease(KeyEvent.VK_M);
            
            if (browser.equals("Firefox")){
                for (int i = 0; i < 15; i++){
                    rb.keyPress(KeyEvent.VK_TAB);
                    rb.keyRelease(KeyEvent.VK_TAB);
                }
                rb.keyPress(KeyEvent.VK_ENTER);
                rb.keyRelease(KeyEvent.VK_ENTER);
                rb.keyPress(KeyEvent.VK_ENTER);
                rb.keyRelease(KeyEvent.VK_ENTER);
            }
            
            driver.navigate().to(domain);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Methods.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        driver.navigate().to(domain);
        return driver;
        
    }
   
    public static String createRandomString() {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
          .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
          .limit(targetStringLength)
          .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
          .toString();

        return generatedString;
    }
    }
