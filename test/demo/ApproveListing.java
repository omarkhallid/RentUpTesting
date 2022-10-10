package demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import static demo.Methods.*;
import static demo.logintest.adminLogin;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author Tarek Radwan
 */
public class ApproveListing {
    
    public static WebDriver Approvetest() throws Exception {
       
        WebDriver driver = adminLogin();
        WebDriverWait wait = new WebDriverWait(driver,30);
         
          //Thread.sleep(3000);
          wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#sidebar > ul > li:nth-child(2) > a")));
          driver.findElement(By.cssSelector("#sidebar > ul > li:nth-child(2) > a")).click();
          //Thread.sleep(2000);
          wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#users > li:nth-child(5) > a")));
          driver.findElement(By.cssSelector("#users > li:nth-child(5) > a")).click();
          //Thread.sleep(20000);
          wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#properties-table > tbody > tr:nth-child(1) > td:nth-child(2) > label > span")));
          driver.findElement(By.cssSelector("#properties-table > tbody > tr:nth-child(1) > td:nth-child(2) > label > span")).click();
          Thread.sleep(2000);
          
        
        return driver;
    }
    @Test
    public void test() throws Exception
    {
        WebDriver driver=Approvetest();
        driver.close();
    }
}