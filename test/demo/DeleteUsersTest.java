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
public class DeleteUsersTest {
      
      
      
      
    @Test
    public void test() throws Exception {
        
        WebDriver driver = adminLogin();
        
       
        //open "users / offers / parents / properites" caret

        driver.findElement(By.id("sidebar")).findElements(By.tagName("li")).get(1).click();
        //choose tenants
        driver.findElement(By.id("sidebar")).findElements(By.tagName("li")).get(1).findElement(By.tagName("ul")).findElement(By.tagName("a")).click();
        Thread.sleep(3000);
        driver.findElement(By.className("card")).findElement(By.tagName("input")).sendKeys("abc.com");
        Thread.sleep(3000);
        driver.findElement(By.className("dataTables_length")).click();
        driver.findElement(By.className("dataTables_length")).findElements(By.tagName("option")).get(4).click();
        Thread.sleep(3000);
        Robot rb = new Robot();
        rb.setAutoDelay(250);
        int numberOfRows = driver.findElement(By.id("tt-table")).findElement(By.tagName("tbody")).findElements(By.tagName("tr")).size();
        for(int i = 0; i < numberOfRows; i++){    
            try{
                driver.findElement(By.id("tt-table")).findElement(By.tagName("tbody")).findElement(By.tagName("tr")).findElements(By.tagName("td")).get(2).findElements(By.tagName("button")).get(1).click();
                Thread.sleep(1000);
                rb.keyPress(KeyEvent.VK_ENTER);
                rb.keyRelease(KeyEvent.VK_ENTER);
                Thread.sleep(1000);
            } catch(Exception ex){}
        }
        
        
        driver.close();
    }
    
}
