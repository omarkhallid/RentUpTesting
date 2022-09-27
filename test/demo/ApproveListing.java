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

/**
 *
 * @author Tarek Radwan
 */
public class ApproveListing {
    
    public static WebDriver Approvetest() throws Exception {
        
        WebDriver driver = adminLogin();
       
        //open "users / offers / parents / properites" caret
//        driver.findElement(By.id("sidebar")).findElements(By.tagName("li")).get(1).click();
//        //choose tenants
//        driver.findElement(By.id("sidebar")).findElements(By.tagName("li")).get(1).findElement(By.tagName("ul")).findElements(By.tagName("li")).get(4).findElement(By.tagName("a")).click();
//        Thread.sleep(3000);
//        driver.findElement(By.className("card")).findElement(By.tagName("input")).sendKeys("auto tester");
//        Thread.sleep(6000);
//        
//        driver.findElement(By.id("properties-table")).findElement(By.tagName("tbody")).findElement(By.tagName("tr")).findElements(By.tagName("td")).get(1).findElement(By.className("switch")).click();
//        Thread.sleep(2000);
          Thread.sleep(3000);
          driver.findElement(By.cssSelector("#sidebar > ul > li:nth-child(2) > a")).click();
          Thread.sleep(2000);
          driver.findElement(By.cssSelector("#users > li:nth-child(5) > a")).click();
          Thread.sleep(20000);
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