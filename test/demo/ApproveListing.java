package demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import static demo.Methods.*;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.openqa.selenium.WebElement;

/**
 *
 * @author Tarek Radwan
 */
public class ApproveListing {
      
    @Test
    public void test() throws Exception {
        
        WebDriver driver = adminLogin();
        
        //open "users / offers / parents / properites" caret
        driver.findElement(By.id("sidebar")).findElements(By.tagName("li")).get(1).click();
        //choose tenants
        driver.findElement(By.id("sidebar")).findElements(By.tagName("li")).get(1).findElement(By.tagName("ul")).findElements(By.tagName("li")).get(4).findElement(By.tagName("a")).click();
        Thread.sleep(3000);
        driver.findElement(By.className("card")).findElement(By.tagName("input")).sendKeys("auto tester");
        Thread.sleep(6000);
        
        driver.findElement(By.id("properties-table")).findElement(By.tagName("tbody")).findElement(By.tagName("tr")).findElements(By.tagName("td")).get(1).findElement(By.className("switch")).click();
        Thread.sleep(2000);
        
        driver.close();
    }
    
}