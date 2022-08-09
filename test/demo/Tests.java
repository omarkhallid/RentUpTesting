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
public class Tests {   
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
    public void FirefoxInvalidLoginTest() throws Exception {

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
    public void FirefoxValidLoginTest() throws Exception {
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
    public void ChromeInvalidLoginTest() throws Exception {

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
    public void ChromeValidLoginTest() throws Exception {

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
    public void EdgeInvalidLoginTest() throws Exception {

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
    public void EdgeValidLoginTest() throws Exception {

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
    
    
     @Test
    public void ChromePostRequestTest() throws Exception {

        String email = getCellData(1, 0);
    	String password = getCellData(1, 1);
        String District = getCellData(1,2);
        String budget = getCellData(1,3);
        // Set Firefox Web Driver
        System.setProperty("webdriver.edge.driver", new java.io.File(".").getCanonicalPath()+"\\" + "msedgedriver.exe");
    	WebDriver driver = new ChromeDriver();
        driver = login(driver,email,password);
        Thread.sleep(8000);
        driver.findElement(By.xpath("/html/body/div[1]/div/div/header/nav/div/div[3]/a[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"citySelect\"]/div[1]/span")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"desktop-option-container\"]/div[2]/div[2]/div[1]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/div[1]/div/div/div[2]/div[1]/div/div/div[2]/div/div[2]/div[1]/span")).click();
        driver.findElement(By.xpath("//*[@id=\"desktop-option-container\"]/div[1]/input")).click();
        driver.findElement(By.className("dropdown-search")).sendKeys(District);
        driver.findElement(By.xpath("//*[@id=\"desktop-option-container\"]/div[2]/div/div[1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"neighborhoodSelect\"]/div[1]/span")).click();
         Thread.sleep(4000);
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div/div/div[2]/div[1]/div/div/div[2]/div/div[3]/div[2]/div[2]/div[1]/div[1]")).click();
        Thread.sleep(400);
        driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/div[1]/div/div/div[2]/div[1]/div/div/div[3]/button")).click();
        Thread.sleep(400);
        driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/div[1]/div/div/div[2]/div[2]/main/div/div/div[2]/div[1]/div[1]/div[2]/button/div")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/div[1]/div/div/div[2]/div[2]/main/div/div/div[2]/div[1]/div[3]/div/div/span[4]")).click();
        Thread.sleep(400);
        driver.findElement(By.xpath("//*[@id=\"datepicker__value_\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div/div/div[2]/div[2]/main/div/div/div[2]/div[2]/div[1]/div/div[2]/div/div/div/div/footer/div/button[1]")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div/div/div[2]/div[2]/main/div/div/div[2]/div[2]/div[2]/div/div[2]/span/fieldset/div/input")).sendKeys(budget);
        driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/div[1]/div/div/div[2]/div[2]/main/div/div/div[3]/div/div[2]/div/button")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/div[1]/div/div/div[2]/div[3]/div/div[2]/div[1]/main/div/div[1]/div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/div[1]/div/div/div[2]/div[3]/div/div[2]/div[2]/main/div/div[3]/div/span")).click();
        Thread.sleep(4000);
        driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div.p-3.post-form-container > div:nth-child(3) > div > div.mt-4.step-content.pt-2.mx-auto.col-lg-6.col-12 > div:nth-child(3) > div > div.col-md-12.col-lg-8 > span > div.counter-input-contianer > button:nth-child(3)")).click();
    	Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/div[1]/div/div/div[2]/div[3]/div/div[2]/div[4]/main/div/div[2]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/div[1]/div/div/div[2]/div[3]/div/div[3]/div/div[2]/div/button")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/div[1]/div/div/div[2]/div[3]/div/div[5]/button")).click();
        Thread.sleep(2000);
        try {
            // Check whether a certain element appears which confirms that the login was not successful
            assertEquals(false, driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/div[1]/div/div[2]/div[1]/div/svg")).isDisplayed()); 
        } catch(NoSuchElementException e){
            assertTrue(true);
        }
        Thread.sleep(2000);
        
        // Close the web driver
        driver.close();

    }
    
}
