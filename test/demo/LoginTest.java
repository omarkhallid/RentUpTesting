package demo;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginTest {   
    public String getCellData(int row, int col) throws Exception {
        XSSFSheet ExcelWSheet;
        XSSFWorkbook ExcelWBook;

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
    
    public WebDriver login(WebDriver driver , String email ,String password) throws Exception{
        
    	

        // Puts an Implicit wait, Will wait for 10 seconds before throwing exception
        //driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        // Launch website
        driver.navigate().to("http://rentup.co/");
        // Maximize the browser
        
        
        // Click on Sign in button
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div/div/div/header/nav/div/div[4]/ul/li[2]/button/span")).click();

        // Enter the username and password
        try{
            driver.findElement(By.xpath("//*[@id=\"__BVID__98\"]")).sendKeys(email);
            driver.findElement(By.xpath("//*[@id=\"__BVID__103\"]")).sendKeys(password);
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
    
    @Test
    public void FirefoxInvalidTest() throws Exception {

    	String username = getCellData(2, 0);
    	String password = getCellData(2, 1);

        // Set Firefox Web Driver
        System.setProperty("webdriver.gecko.driver", new java.io.File(".").getCanonicalPath() + "\\" + "geckodriver.exe");
    	WebDriver driver = new FirefoxDriver();
        
        driver = login(driver,username,password);
      
        try {
            // Check whether a certain element appears which confirms that the login was not successful
            assertEquals(false, driver.findElement(By.xpath("/html/body/div/div/div/header/nav/div/div[4]/ul/li[1]/div/button/div")).isDisplayed()); 
        } catch(NoSuchElementException e){
            assertTrue(true);
        }
        Thread.sleep(2000);
        
        // Close the web driver
        driver.close();
    }
    
    @Test
    public void FirefoxLoginTest() throws Exception {
        String email = getCellData(1, 0);
    	String password = getCellData(1, 1);

        // Set Firefox Web Driver
        System.setProperty("webdriver.gecko.driver", new java.io.File(".").getCanonicalPath() + "\\" + "geckodriver.exe");
        
        WebDriver driver = new FirefoxDriver();
        
        driver = login(driver,email,password);
        
    	try {
            // Check whether a certain element appears which confirms that the login was not successful
            assertEquals(false, driver.findElement(By.xpath("/html/body/div/div/div/header/nav/div/div[4]/ul/li[1]/div/button/div")).isDisplayed()); 
        } catch(NoSuchElementException e){
            assertTrue(true);
        }
        Thread.sleep(2000);
        
        // Close the web driver
        driver.close();
    }
    @Test
    public void ChromeInvalidTest() throws Exception {

    	String username = getCellData(2, 0);
    	String password = getCellData(2, 1);

        // Set Firefox Web Driver
       System.setProperty("webdriver.chrome.driver", new java.io.File(".").getCanonicalPath()+"\\" + "chromedriver.exe");
    	WebDriver driver = new ChromeDriver();
        
        driver = login(driver,username,password);
      
        try {
            // Check whether a certain element appears which confirms that the login was not successful
            assertEquals(false, driver.findElement(By.xpath("/html/body/div/div/div/header/nav/div/div[4]/ul/li[1]/div/button/div")).isDisplayed()); 
        } catch(NoSuchElementException e){
            assertTrue(true);
        }
        Thread.sleep(2000);
        
        // Close the web driver
        driver.close();
    }

    @Test
    public void ChromeValidTest() throws Exception {

    String email = getCellData(1, 0);
    	String password = getCellData(1, 1);

        // Set Firefox Web Driver
        System.setProperty("webdriver.chrome.driver", new java.io.File(".").getCanonicalPath()+"\\" + "chromedriver.exe");
    	WebDriver driver = new ChromeDriver();
        
        driver = login(driver,email,password);
        
    	try {
            // Check whether a certain element appears which confirms that the login was not successful
            assertEquals(false, driver.findElement(By.xpath("/html/body/div/div/div/header/nav/div/div[4]/ul/li[1]/div/button/div")).isDisplayed()); 
        } catch(NoSuchElementException e){
            assertTrue(true);
        }
        Thread.sleep(2000);
        
        // Close the web driver
        driver.close();

    }

    @Test
    public void EdgeInvalidTest() throws Exception {

    	String username = getCellData(2, 0);
    	String password = getCellData(2, 1);

        // Set Firefox Web Driver
        
        System.setProperty("webdriver.edge.driver", new java.io.File(".").getCanonicalPath()+"\\" + "msedgedriver.exe");
    	WebDriver driver = new EdgeDriver();
        driver = login(driver,username,password);
      
        try {
            // Check whether a certain element appears which confirms that the login was not successful
            assertEquals(false, driver.findElement(By.xpath("/html/body/div/div/div/header/nav/div/div[4]/ul/li[1]/div/button/div")).isDisplayed()); 
        } catch(NoSuchElementException e){
            assertTrue(true);
        }
        Thread.sleep(2000);
        
        // Close the web driver
        driver.close();
    }

    @Test
    public void EdgeValidTest() throws Exception {

    String email = getCellData(1, 0);
    	String password = getCellData(1, 1);

        // Set Firefox Web Driver
        System.setProperty("webdriver.edge.driver", new java.io.File(".").getCanonicalPath()+"\\" + "msedgedriver.exe");
    	WebDriver driver = new EdgeDriver();
       
        
        driver = login(driver,email,password);
        
    	try {
            // Check whether a certain element appears which confirms that the login was not successful
            assertEquals(false, driver.findElement(By.xpath("/html/body/div/div/div/header/nav/div/div[4]/ul/li[1]/div/button/div")).isDisplayed()); 
        } catch(NoSuchElementException e){
            assertTrue(true);
        }
        Thread.sleep(2000);
        
        // Close the web driver
        driver.close();

    }
}
// testing commits 