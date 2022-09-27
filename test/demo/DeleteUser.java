/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import static demo.AddListingTest.AddlistingTest;
import static demo.Methods.LandlordEmail;
import static demo.Methods.createRandomString;
import static demo.Methods.getCellData;
import static demo.SignupTest.signup;
import static demo.logintest.adminLogin;
import static demo.logintest.login;
import java.awt.Robot;
import java.awt.event.KeyEvent;
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
public class DeleteUser {

    public static WebDriver Deleteuser() throws Exception {
        
        WebDriver driver1 = AddlistingTest();
        WebDriver driver = adminLogin();
        Thread.sleep(3000);
        //click on users offers properties
        driver.findElement(By.cssSelector("#sidebar > ul > li:nth-child(2) > a")).click();
        Thread.sleep(2000);

        //click on landlord
        driver.findElement(By.cssSelector("#users > li:nth-child(6) > a")).click();
        Thread.sleep(4000);

        //search for specific user
        driver.findElement(By.cssSelector("#tt-table_wrapper > div:nth-child(2) > div > div.dataTables_scroll > div.dataTables_scrollFoot > div > table > tfoot > tr > td:nth-child(7) > input")).sendKeys("automation tester");
        Thread.sleep(3000);

        //click on delete
        driver.findElement(By.cssSelector("#tt-table > tbody > tr:nth-child(1) > td:nth-child(3) > button.btn.btn-xs.btn-danger.btn-delete")).click();
        Thread.sleep(2000);

        //click on yes delete 
        Robot rb = null;
        try {
            rb = new Robot();
        } catch (Exception ex) {
        }
        rb.setAutoDelay(250);
        for (int i = 0; i < 4; i++) {
            rb.keyPress(KeyEvent.VK_TAB);
            rb.keyRelease(KeyEvent.VK_TAB);
        }
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_SHIFT);
        rb.keyPress(KeyEvent.VK_M);

        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyRelease(KeyEvent.VK_SHIFT);
        rb.keyRelease(KeyEvent.VK_M);
        Thread.sleep(2000);

        WebDriver driver2 = login(LandlordEmail, "123456");

        try {
            String txt = driver2.findElement(By.cssSelector("#auth-modal___BV_modal_body_ > div > span:nth-child(1) > div > div")).getText();
            assertEquals("users.validation_messages.wrong_email_or_password" , txt);
        } catch (NoSuchElementException e) {

           
            driver2.close();
            driver.close();
            driver1.close();
        }

        return driver;
    }

    @Test
    public void test() throws Exception {
        WebDriver driver = Deleteuser();
        driver.close();
    }

}
