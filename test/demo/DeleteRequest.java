/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import static demo.AddListingTest.AddlistingTest;
import static demo.DeleteUser.Deleteuser;
import static demo.Methods.TenantEmail;
import static demo.Methods.getCellData;
import static demo.PostRequesttest.PostRequestTest;
import static demo.logintest.adminLogin;
import static demo.logintest.login;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author Farida Osama
 */
public class DeleteRequest {

    public static WebDriver Deleterequest() throws Exception {
        WebDriver driver1 = PostRequestTest();
        WebDriver driver = adminLogin();
        Thread.sleep(3000);

        //click on users offers properties
        driver.findElement(By.cssSelector("#sidebar > ul > li:nth-child(2) > a")).click();
        Thread.sleep(2000);

        //click on requests
        driver.findElement(By.cssSelector("#users > li:nth-child(2) > a")).click();
        Thread.sleep(4000);

        //search for specific user
        driver.findElement(By.cssSelector("#tt-table_wrapper > div:nth-child(2) > div > div.dataTables_scroll > div.dataTables_scrollFoot > div > table > tfoot > tr > td:nth-child(5) > input")).sendKeys(TenantEmail);
        Thread.sleep(1000);

        Robot rb = null;
        try {
            rb = new Robot();
        } catch (Exception ex) {
        }

        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(2000);

        //click on delete them
        driver.findElement(By.cssSelector("#tt-table > tbody > tr > td:nth-child(2) > a")).click();
        Thread.sleep(3000);
       
        
        
        //click ok
        driver.findElement(By.cssSelector("body > div.swal2-container.swal2-top-end.swal2-backdrop-show > div > div.swal2-actions > button.swal2-confirm.swal2-styled")).click();
        Thread.sleep(2000);

        WebDriver driver2 = login(TenantEmail, "123456");
        
        Thread.sleep(5000);

        //click on iam tenant
        driver2.findElement(By.cssSelector("#__layout > div > header > div > div.desktop-nav > div > div > div:nth-child(1) > button")).click();
        Thread.sleep(2000);

        //click on myrequests
        driver2.findElement(By.cssSelector("#__layout > div > header > div > div.desktop-nav > div > div > div:nth-child(1) > div > div > div.col-6.tenant > div.actions > a:nth-child(1)")).click();
        Thread.sleep(2000);

        try {
          //  String txt = driver2.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div > div.b-overlay-wrap.position-relative > div > div.container > div > div:nth-child(1) > a > div > div.card-heading > div.card-address")).getText();
            Assert.assertTrue(driver2.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div > div.b-overlay-wrap.position-relative > div > p")).isDisplayed());
        } catch (NoSuchElementException e) {
            //Assert.assertFalse(true);
            driver2.close();
        }
        return driver;
    }

    @Test
    public void test() throws Exception {
        WebDriver driver = Deleterequest();
        driver.close();
    }

}
