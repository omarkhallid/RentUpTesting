/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package demo;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
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
            domain = "https://rentup.com.eg/",
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
                    System.setProperty("webdriver.chrome.driver", new java.io.File(".").getCanonicalPath() +"\\" + "chromedriver.exe");
                    driver = new ChromeDriver();
                    break;
                case "Edge":
                    System.setProperty("webdriver.edge.driver", new java.io.File(".").getCanonicalPath() +"\\" + "msedgedriver.exe");
                    driver = new EdgeDriver();
                    break;
                case "Firefox":
                    System.setProperty("webdriver.gecko.driver", new java.io.File(".").getCanonicalPath() + "\\" + "geckodriver.exe");
                    driver = new FirefoxDriver();
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
            Thread.sleep(2000);
            driver.findElement(By.cssSelector("#__layout > div > header > nav > div > div.d-flex.align-items-center.d-none.d-lg-none.mobile-header-items > button")).click();
            driver.findElement(By.cssSelector("#__layout > div > header > main > div.side-bar.active-side-bar > div > div > div > ul > li:nth-child(1) > div > a.auth-button.auth-button__register.font-bold.dark")).click();
            driver.findElement(By.cssSelector("#auth-modal___BV_modal_body_ > div > span:nth-child(2) > form > p:nth-child(8) > button")).click();
            driver.findElements(By.tagName("input")).get(0).sendKeys(name);
            driver.findElements(By.tagName("input")).get(1).sendKeys(email);
            driver.findElements(By.tagName("input")).get(2).sendKeys(password);
            driver.findElements(By.tagName("input")).get(3).sendKeys(phone);
            Thread.sleep(2000);
            driver.findElement(By.cssSelector("#auth-modal___BV_modal_body_ > div > span:nth-child(2) > form > button")).click();
            Thread.sleep(10000);
            
        }
        
        return driver;
    }
    public static WebDriver ChromePostRequestTest() throws Exception {

        String email = createRandomString() + "@abc.com", password = "123456";
        System.out.println("Landlord credentials:\nEmail: " + email + "\nPassword: " + password);
        
        
        WebDriver driver = signup("auto tester", email, password, "abcdefg");
        Thread.sleep(3000);
       
        if(platform.equals("Desktop"))
        {
            Thread.sleep(8000);
        driver.findElement(By.cssSelector("#__layout > div > header > nav > div > div.nav-links.d-none.d-lg-flex > a:nth-child(2)")).click();  //post A request
        driver.findElement(By.cssSelector("#citySelect > div > span")).click();  //click on city
        
        Thread.sleep(3000);
        if(getCellData(5, 0).equals("z"))
        {
             driver.findElement(By.className("dropdown-search")).sendKeys(getCellData(4, 0)); // send data in the search bar
             driver.findElement(By.className("option-label")).click();  // click on the selected 
             Thread.sleep(3000);
             
        }
        else
        {
             driver.findElement(By.className("dropdown-search")).sendKeys(getCellData(5, 0));
             driver.findElement(By.className("option-label")).click();
             Thread.sleep(3000);
        }
        
        if(getCellData(5, 1).equals("z"))
        {
            driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div.p-3.post-form-container > div:nth-child(1) > div > div > div.row.justify-content-center > div > div:nth-child(2) > div > span")).click();
            driver.findElement(By.className("dropdown-search")).sendKeys(getCellData(4, 1));
            driver.findElement(By.className("option-label")).click();
             Thread.sleep(3000);
        }
        else if(!(getCellData(5, 1).equals("z"))&&!(getCellData(5, 1).equals("nothing")))
        {
            driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div.p-3.post-form-container > div:nth-child(1) > div > div > div.row.justify-content-center > div > div:nth-child(2) > div > span")).click();
            driver.findElement(By.className("dropdown-search")).sendKeys(getCellData(5, 1));
            driver.findElement(By.className("option-label")).click();
             Thread.sleep(3000);
        }
        
        if(getCellData(5, 2).equals("z"))
        {
            driver.findElement(By.cssSelector("#neighborhoodSelect > div > span")).click();
            driver.findElement(By.className("dropdown-search")).sendKeys(getCellData(4, 2));
            driver.findElement(By.className("option-label")).click();
            Thread.sleep(3000);
        }
        else if(!(getCellData(5, 2).equals("z"))&&!(getCellData(5, 2).equals("nothing")))
        {
            driver.findElement(By.cssSelector("#neighborhoodSelect > div > span")).click();
            driver.findElement(By.className("dropdown-search")).sendKeys(getCellData(5, 2));
            driver.findElement(By.className("option-label")).click();
            Thread.sleep(3000);
        }
       
        
   
       
        driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div.p-3.post-form-container > div:nth-child(1) > div > div > div.step-next-container > button")).click();
        Thread.sleep(3000);
        if(getCellData(5, 3).equals("z"))
        {
             driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div.p-3.post-form-container > div:nth-child(2) > main > div > div > div.mt-4.step-content.pt-2.mx-auto.col-lg-6.col-12 > div.section-white.px-minus-15 > div.row.px-2.row-cols-12 > div:nth-child(2) > button")).click();
                               
        }
        else if (getCellData(5, 3).equals("Nights"))
        {
           driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div.p-3.post-form-container > div:nth-child(2) > main > div > div > div.mt-4.step-content.pt-2.mx-auto.col-lg-6.col-12 > div.section-white.px-minus-15 > div.row.px-2.row-cols-12 > div:nth-child(1) > button > span")).click();
           
        }
        else
        {
            
            driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div.p-3.post-form-container > div:nth-child(2) > main > div > div > div.mt-4.step-content.pt-2.mx-auto.col-lg-6.col-12 > div.section-white.px-minus-15 > div.row.px-2.row-cols-12 > div:nth-child(3) > button > span")).click();
        }

         Thread.sleep(2000);
         if(getCellData(5, 4).equals("z"))
         {
             driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div.p-3.post-form-container > div:nth-child(2) > main > div > div > div.mt-4.step-content.pt-2.mx-auto.col-lg-6.col-12 > div.section-white.px-minus-15 > div.row.mt-1 > div > div > span:nth-child(4)")).click();
         }
         else if (getCellData(5, 4).equals("3"))
         {
              driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div.p-3.post-form-container > div:nth-child(2) > main > div > div > div.mt-4.step-content.pt-2.mx-auto.col-lg-6.col-12 > div.section-white.px-minus-15 > div.row.mt-1 > div > div > span:nth-child(3)")).click();
         }
         else
         {
              driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div.p-3.post-form-container > div:nth-child(2) > main > div > div > div.mt-4.step-content.pt-2.mx-auto.col-lg-6.col-12 > div.section-white.px-minus-15 > div.row.mt-1 > div > div > span:nth-child(8)")).click();
         }
       
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#datepicker")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("datepicker__dialog_")).findElements(By.tagName("footer")).get(1).findElements(By.tagName("button")).get(0).click();

        
        Thread.sleep(2000);     
        if(getCellData(5, 5).equals("z"))
        {
            driver.findElement(By.tagName("input")).sendKeys(getCellData(4, 5));
        }
        else
        {
            driver.findElement(By.tagName("input")).sendKeys(getCellData(5, 5));
        }
        Thread.sleep(2000);  
        driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div.p-3.post-form-container > div:nth-child(2) > main > div > div > div:nth-child(3) > div > div.col-7 > div > button")).click();
        Thread.sleep(4000);
        
        if(getCellData(5, 6).equals("z") && !(getCellData(5,6).equals("NA")))
           {
              driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div.p-3.post-form-container > div:nth-child(3) > div > div.mt-4.step-content.pt-2.mx-auto.col-lg-6.col-12 > div.mt-2.section-white.col-12 > main > div > div:nth-child(1) > div")).click();
               Thread.sleep(1000);
           }
       
        if(!(getCellData(5, 7).equals("NA")))
           {
              driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div.p-3.post-form-container > div:nth-child(3) > div > div.mt-4.step-content.pt-2.mx-auto.col-lg-6.col-12 > div.mt-2.section-white.col-12 > main > div > div:nth-child(2) > div")).click();
              Thread.sleep(1000);
           }
        Thread.sleep(1000);
        if(getCellData(5,12).equals("z"))
        {
            for (WebElement we : driver.findElements(By.tagName("span")))
                if (we.getText().equals("Early Check-In"))
                    we.click();
            Thread.sleep(1000);
        }
        else
        { for (WebElement we : driver.findElements(By.tagName("span")))
                if (we.getText().equals("Late Check-Out"))
                    we.click();
            Thread.sleep(1000);
        }
        if(getCellData(5,13).equals("z"))
        {
            int x = Integer.parseInt(getCellData(4, 13));
            for(int i=0;i<x-1;i++)
            {
              driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div.p-3.post-form-container > div:nth-child(3) > div > div.mt-4.step-content.pt-2.mx-auto.col-lg-6.col-12 > div.mt-4.section-white.contract-section.col-12 > div:nth-child(1) > div.col-md-12.col-lg-4 > span > div.counter-input-contianer > button:nth-child(3)")).click();
              Thread.sleep(1000);
            }
        }
        else
        {
            int x = Integer.parseInt(getCellData(5, 13));
            for(int i=0;i<x-1;i++)
            {
              driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div.p-3.post-form-container > div:nth-child(3) > div > div.mt-4.step-content.pt-2.mx-auto.col-lg-6.col-12 > div.mt-4.section-white.contract-section.col-12 > div:nth-child(1) > div.col-md-12.col-lg-4 > span > div.counter-input-contianer > button:nth-child(3)")).click();
              Thread.sleep(1000);
            }
        }
        Thread.sleep(1000);
        if(getCellData(5,14).equals("z"))
        {
            int x = Integer.parseInt(getCellData(4, 14));
            for(int i=0;i<x-1;i++)
            {
              driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div.p-3.post-form-container > div:nth-child(3) > div > div.mt-4.step-content.pt-2.mx-auto.col-lg-6.col-12 > div.mt-4.section-white.contract-section.col-12 > div:nth-child(2) > div.col-md-12.col-lg-4 > span > div.counter-input-contianer > button:nth-child(3)")).click();
              Thread.sleep(1000);
            }
        }
        else
        {
            int x = Integer.parseInt(getCellData(5, 14));
            for(int i=0;i<x-1;i++)
            {
              driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div.p-3.post-form-container > div:nth-child(3) > div > div.mt-4.step-content.pt-2.mx-auto.col-lg-6.col-12 > div.mt-4.section-white.contract-section.col-12 > div:nth-child(2) > div.col-md-12.col-lg-4 > span > div.counter-input-contianer > button:nth-child(3)")).click();
              Thread.sleep(1000);
            }
        }
        Thread.sleep(1000);
        if(getCellData(5, 15).equals("z"))
        {
            driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div.p-3.post-form-container > div:nth-child(3) > div > div.mt-4.step-content.pt-2.mx-auto.col-lg-6.col-12 > div.mt-4.section-white.contract-section.col-12 > div:nth-child(3) > div.col-md-12.col-lg-4 > input")).sendKeys(getCellData(4, 15));
            Thread.sleep(1000);
        }
        else
        {
             driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div.p-3.post-form-container > div:nth-child(3) > div > div.mt-4.step-content.pt-2.mx-auto.col-lg-6.col-12 > div.mt-4.section-white.contract-section.col-12 > div:nth-child(3) > div.col-md-12.col-lg-4 > input")).sendKeys(getCellData(5, 15));
            Thread.sleep(1000);
        }
         if(getCellData(5, 9).equals("z"))
         {
             driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div.p-3.post-form-container > div:nth-child(3) > div > div.mt-4.step-content.pt-2.mx-auto.col-lg-6.col-12 > div:nth-child(5) > main > div > div:nth-child(2) > div > span")).click();
         }
         else if (getCellData(5, 9).equals("Furnished"))
         {
             driver.findElement(By.cssSelector(" #__layout > div > div.main-content-container > div > div > div.p-3.post-form-container > div:nth-child(3) > div > div.mt-4.step-content.pt-2.mx-auto.col-lg-6.col-12 > div:nth-child(5) > main > div > div:nth-child(1) > div > span")).click();
         }                                       
         else
         {
             driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div.p-3.post-form-container > div:nth-child(3) > div > div.mt-4.step-content.pt-2.mx-auto.col-lg-6.col-12 > div:nth-child(5) > main > div > div:nth-child(3) > div > span")).click();
         }
         if(!(getCellData(5, 10).equals("z")))
         {
         int x = Integer.parseInt(getCellData(5, 10));
         Thread.sleep(2000);
         for(int i=0;i<x-1;i++)
         {
             driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div.p-3.post-form-container > div:nth-child(3) > div > div.mt-4.step-content.pt-2.mx-auto.col-lg-6.col-12 > div:nth-child(7) > div > div.col-md-12.col-lg-8 > span > div.counter-input-contianer > button:nth-child(3)")).click();
             Thread.sleep(1000);
         }
         }
         else
         {
              driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div.p-3.post-form-container > div:nth-child(3) > div > div.mt-4.step-content.pt-2.mx-auto.col-lg-6.col-12 > div:nth-child(7) > div > div.col-md-12.col-lg-8 > span > div.counter-input-contianer > button:nth-child(3)")).click();
         }
         
         if(getCellData(5, 11).equals("z"))
            {
                     driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div.p-3.post-form-container > div:nth-child(3) > div > div.mt-4.step-content.pt-2.mx-auto.col-lg-6.col-12 > div:nth-child(9) > main > div > div:nth-child(9) > div > span")).click();
            }                                        
         else
         {
             if(getCellData(5, 11).equals("Duplex"))
             {
                 driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div.p-3.post-form-container > div:nth-child(3) > div > div.mt-4.step-content.pt-2.mx-auto.col-lg-6.col-12 > div:nth-child(9) > main > div > div:nth-child(2) > div")).click();
             }
             else
             {
                 driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div.p-3.post-form-container > div:nth-child(3) > div > div.mt-4.step-content.pt-2.mx-auto.col-lg-6.col-12 > div:nth-child(9) > main > div > div:nth-child(5) > div > span")).click();
             }
         }
         Thread.sleep(2000);
         driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div.p-3.post-form-container > div:nth-child(3) > div > div:nth-child(3) > div > div.col-7 > div > button")).click();
        
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div.p-3.post-form-container > div:nth-child(3) > div > div:nth-child(5) > button")).click();
        Thread.sleep(2000);
        
        }
        return driver;
    }
    public static WebDriver AddListing() throws InterruptedException, AWTException, Exception
    {
        String city, district, street, furnish, propertyType, propertyName, rentPerNight = "", rentPerMonth = "", description;
        int beds = 0, baths = 0;
        
        if (getCellData(14,0).equals("")) city = getCellData(13,0);
        else city = getCellData(14,0);
        
        if (getCellData(14,1).equals("")) district = getCellData(13,1);
        else district = getCellData(14,1);
        
//        if (getCellData(14,2).equals("")) street = getCellData(13,2);
//        else street = getCellData(14,2);
        
        if (getCellData(14,3).equals("")) furnish = getCellData(13,3);
        else furnish = getCellData(14,3);
        
        if (getCellData(14,4).equals("")) propertyType = getCellData(13,4);
        else propertyType = getCellData(14,4);
        
        if (getCellData(14,5).equals("")) beds = Integer.parseInt(getCellData(13,5));
        else beds = Integer.parseInt(getCellData(14,5));
        
        if (getCellData(14,6).equals("")) baths = Integer.parseInt(getCellData(13,6));
        else baths = Integer.parseInt(getCellData(14,6));
        
        if (getCellData(14,7).equals("")) propertyName = getCellData(13,7);
        else propertyName = getCellData(14,7);
        
        if (getCellData(14,8).equals("") && getCellData(14,9).equals("")) rentPerNight = getCellData(13,8);
        else if (!getCellData(14,8).equals("")) rentPerNight = getCellData(14,8);
        else if (!getCellData(14,9).equals("")) rentPerMonth = getCellData(14,9);
        
        if (getCellData(14,11).equals("")) description = getCellData(13,10);
        else description = getCellData(14,10);
        
        String email = createRandomString() + "@abc.com", password = "123456";
        System.out.println("Landlord credentials:\nEmail: " + email + "\nPassword: " + password);
        
        
        WebDriver driver = signup("auto tester", email, password, "abcdefg");
        Thread.sleep(6000);
        if (platform.equals("Desktop")){
            
            driver.findElement(By.id("list-property")).click();
            Thread.sleep(2000);
            driver.findElement(By.className("dropdown-container")).click();
            
            driver.findElement(By.className("dropdown-search")).sendKeys(city); 
            driver.findElement(By.className("option-label")).click();
            Thread.sleep(2000);
            
            driver.findElements(By.className("dropdown-container")).get(1).click();
            
            driver.findElement(By.className("dropdown-search")).sendKeys(district); 
            driver.findElement(By.className("option-label")).click();
            Thread.sleep(2000);
            
//            driver.findElement(By.tagName("input")).sendKeys(street);
//            Thread.sleep(2000);
            
            driver.findElement(By.className("properties__content")).findElements(By.tagName("button")).get(driver.findElement(By.className("properties__content")).findElements(By.tagName("button")).size() - 1).click();
        
            for (WebElement we : driver.findElement(By.className("chips-container")).findElements(By.tagName("label")))
                if (we.getText().toLowerCase().equals(furnish.toLowerCase()))
                    we.click();
        
            for (WebElement we : driver.findElements(By.className("chips-container")).get(1).findElements(By.tagName("label")))
                if (we.getText().equals(propertyType))
                    we.click();
            
            for (int i = 1; i < beds; i++)
                driver.findElements(By.className("counter-input-contianer")).get(1).click();
            
            for (int i = 1; i < baths; i++)
                driver.findElements(By.className("counter-input-contianer")).get(3).click();
            
            driver.findElement(By.className("properties__content")).findElements(By.tagName("button")).get(driver.findElement(By.className("properties__content")).findElements(By.tagName("button")).size() - 1).click();
            Thread.sleep(8000);
            //driver.findElements(By.className("chips-container")).get(2).click();
//            try{
//                driver.findElements(By.className("chips-container")).get(2).findElement(By.className("chip-label")).click();
//            } catch (Exception ex){}
            try{
                
                driver.findElements(By.className("chips-container")).get(2).findElement(By.className("chip-label")).click();
            } catch (Exception ex){}


            try{
                driver.findElements(By.className("chips-container")).get(3).findElement(By.className("chip-label")).click();
            } catch (Exception ex){}


            try{
                driver.findElements(By.className("chips-container")).get(4).findElement(By.className("chip-label")).click();
            } catch (Exception ex){}
            
            driver.findElement(By.className("properties__content")).findElements(By.tagName("button")).get(driver.findElement(By.className("properties__content")).findElements(By.tagName("button")).size() - 1).click();
            
            for (WebElement we : driver.findElements(By.tagName("input")))
                if (we.getAttribute("placeholder").contains("Beautiful apartment")){
                    we.sendKeys(propertyName);
                    break;
                }
                    
            
            
            
            driver.findElement(By.tagName("textarea")).sendKeys(description);
            
            
            
            if (!rentPerNight.equals("")){
                
                for (WebElement we : driver.findElements(By.className("chip-label")))
                    if (we.getText().contains("Per Day")){
                        we.click();
                        break;
                    }
                
                for (WebElement we : driver.findElements(By.tagName("input")))
                    if (we.getAttribute("placeholder").contains("per night")){
                        we.sendKeys(rentPerNight);
                        break;
                    }
            }
            else if (!rentPerMonth.equals("")){
                for (WebElement we : driver.findElements(By.className("chip-label")))
                    if (we.getText().contains("Per Month")){
                        we.click();
                        break;
                    }
                
                for (WebElement we : driver.findElements(By.tagName("input")))
                    if (we.getAttribute("placeholder").contains("per month")){
                        we.sendKeys(rentPerMonth);
                        break;
                    }
            }
            
            driver.findElement(By.className("upload-file-target")).click();
            
            
            // creating robot for uploading an image
            Robot rb = new Robot();

            // copying File path to Clipboard
            StringSelection str = new StringSelection(new java.io.File(".").getCanonicalPath() + "\\test\\Resources\\placeholder.png");
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
            
            Thread.sleep(2000);
             // press Contol+V for pasting
             rb.keyPress(KeyEvent.VK_CONTROL);
             rb.keyPress(KeyEvent.VK_V);

            // release Contol+V for pasting
            rb.keyRelease(KeyEvent.VK_CONTROL);
            rb.keyRelease(KeyEvent.VK_V);

            // for pressing and releasing Enter

            rb.keyPress(KeyEvent.VK_ENTER);
            rb.keyRelease(KeyEvent.VK_ENTER);
            
            Thread.sleep(3000);
            driver.findElement(By.className("properties__content")).findElements(By.tagName("button")).get(driver.findElement(By.className("properties__content")).findElements(By.tagName("button")).size() - 1).click();
            
            Thread.sleep(3000);
            for (WebElement we : driver.findElements(By.tagName("button")))
                    if (we.getText().contains("Submit your request")){
                        we.click();
                        break;
                    }
            Thread.sleep(2000);
            
    }
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
