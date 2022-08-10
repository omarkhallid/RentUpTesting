/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demo;

import static demo.Methods.login;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author Tarek Radwan
 */
public class PostRequesttest {
    Methods m = new Methods();
    @Test
    public void ChromePostRequestTest() throws Exception {

        String email = m.getCellData(1, 0);
    	String password = m.getCellData(1, 1);
        // Set Firefox Web Driver
        System.setProperty("webdriver.edge.driver", new java.io.File(".").getCanonicalPath()+"\\" + "msedgedriver.exe");
    	WebDriver driver = new ChromeDriver();
        driver = login(driver,email,password);
        Thread.sleep(8000);
        driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/header/nav/div/div[3]/a[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"citySelect\"]/div[1]/span")).click();
        Thread.sleep(3000);
        if(m.getCellData(5, 0).equals("z"))
        {
             driver.findElement(By.className("dropdown-search")).sendKeys(m.getCellData(4, 0));
             driver.findElement(By.className("option-label")).click();
             driver.findElement(By.className("w-100")).click();
        }
        else
        {
             driver.findElement(By.className("dropdown-search")).sendKeys(m.getCellData(5, 0));
             driver.findElement(By.className("option-label")).click();
             driver.findElement(By.className("w-100")).click();
        }
       
        Thread.sleep(5000);
        driver.findElement(By.className("w-100")).click();
        if(m.getCellData(5, 1).equals("z"))
        {
            driver.findElement(By.className("dropdown-search")).sendKeys(m.getCellData(4, 1));
            driver.findElement(By.className("option-label")).click();
            
        }
        else 
        {
           driver.findElement(By.className("dropdown-search")).sendKeys(m.getCellData(5, 1));
           driver.findElement(By.className("option-label")).click();
           
        }
        
        //driver.findElement(By.className("dropdown-search")).sendKeys(District);
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
       // driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div/div/div[2]/div[2]/main/div/div/div[2]/div[2]/div[2]/div/div[2]/span/fieldset/div/input")).sendKeys(budget);
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
