/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

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
public class EditLandlordProfile {
    public static WebDriver Editlandlord() throws Exception {

        WebDriver driver = adminLogin();
        Robot rb = new Robot();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#sidebar > ul > li:nth-child(2) > a")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#users > li:nth-child(6) > a")).click();
        Thread.sleep(4000);
        driver.findElement(By.cssSelector("#tt-table_wrapper > div:nth-child(1) > div.m-auto.float-right.col-sm-12.col-md-6 > div > button.dt-button.btn.btn-primary.btn-sm > span > i")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#name")).sendKeys("tarek");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#email")).sendKeys(createRandomString() + "@abc.com");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#password")).sendKeys("123456");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#mobile")).sendKeys("01123456");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#landlord_form > div > div.col-12.mt-2 > div > div:nth-child(1) > button")).click();
        Thread.sleep(10000);
        driver.findElement(By.cssSelector("#tt-table_wrapper > div:nth-child(2) > div > div.dataTables_scroll > div.dataTables_scrollFoot > div > table > tfoot > tr > td:nth-child(7) > input")).sendKeys("tarek");
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("#tt-table > tbody > tr:nth-child(1) > td:nth-child(3) > a:nth-child(1)")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#email")).clear();
//           rb.keyPress(KeyEvent.VK_CONTROL);
//       rb.keyPress(KeyEvent.VK_SHIFT);
//       rb.keyPress(KeyEvent.VK_RIGHT);
//       rb.keyRelease(KeyEvent.VK_CONTROL);
//       rb.keyRelease(KeyEvent.VK_SHIFT);
//       rb.keyRelease(KeyEvent.VK_RIGHT);
//       for(int i=0;i<12;i++)
//       {
//           rb.keyPress(KeyEvent.VK_BACK_SPACE);
//           rb.keyRelease(KeyEvent.VK_BACK_SPACE);
//       }

        Thread.sleep(4000);

        driver.findElement(By.cssSelector("#email")).sendKeys("tarek12@abc.com");
        Thread.sleep(8000);
        driver.findElement(By.cssSelector("#landlord_update_form > div > div.col-12.mt-2 > div > div:nth-child(1) > button")).click();
        Thread.sleep(8000);

        WebDriver driver1 = login("tarek12@abc.com", "123456");
        try {
            // Check whether a certain element appears which confirms that the login was not successful
            assertEquals(true, driver1.findElements(By.tagName("button")).get(3).isDisplayed());
        } catch (NoSuchElementException e) {

            assertTrue(false);
            driver1.close();
        }

        return driver;
    }

    @Test
    public void test() throws Exception {
        WebDriver driver = Editlandlord();
        driver.close();
    }
}
