/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import static demo.AddListingTest.AddlistingTest;
import static demo.Methods.createRandomString;
import static demo.logintest.adminLogin;
import static demo.logintest.login;
import java.awt.Robot;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author Farida Osama
 */
public class EditProperty {
      public static WebDriver EditProperty() throws Exception {

        WebDriver driver = AddlistingTest();
        WebDriver driver1 = adminLogin();
        Robot rb = new Robot();
        Thread.sleep(3000);
        //click on users offers parents properties
        driver1.findElement(By.cssSelector("#sidebar > ul > li:nth-child(2) > a")).click();
        Thread.sleep(2000);
        //click on properties
        driver1.findElement(By.cssSelector("#users > li:nth-child(5) > a")).click();
        Thread.sleep(4000);
        //search for property
        driver1.findElement(By.cssSelector("#properties-table_wrapper > div:nth-child(2) > div > div.dataTables_scroll > div.dataTables_scrollFoot > div > table > tfoot > tr > td:nth-child(6) > input")).sendKeys("Automation");
        Thread.sleep(3000);
        //click edit
        driver1.findElement(By.cssSelector("#properties-table > tbody > tr:nth-child(1) > td:nth-child(2) > a")).click();
        Thread.sleep(2000);
        //edit name
        driver1.findElement(By.cssSelector("#name_en")).sendKeys("Edit");
        Thread.sleep(2000);
        //click on submit
        driver1.findElement(By.cssSelector("#app > div > div > button > span")).click();
        Thread.sleep(10000);
        
        WebDriver driver2 = login("magdaosamaAdmin@test.com", "123456");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#__layout > div > header > div > div.desktop-nav > div > div > div:nth-child(2) > button")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#__layout > div > header > div > div.desktop-nav > div > div > div:nth-child(2) > div > div > div.col-6.landlord > div.actions > a:nth-child(2) > div > span")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div.container-fluid > div > div > div.row > div:nth-child(1)")).clear();
      
//   
      

        return driver1;
    }

    @Test
    public void test() throws Exception {
        WebDriver driver = EditProperty();
        driver.close();
    }
}
