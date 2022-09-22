/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demo;

import static demo.Methods.*;
import static demo.SignupTest.signup;
import static demo.logintest.login;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author Tarek Radwan
 */
public class PostRequesttest {

    public static WebDriver PostRequestTest() throws Exception {

        TenantEmail = createRandomString() + "@test.com";
        String password = "123456";
        System.out.println("Landlord credentials:\nEmail: " + TenantEmail + "\nPassword: " + password);

        WebDriver driver = signup("auto tester", TenantEmail, password, "abcdefg");
        Thread.sleep(1000);

        //Click on post a request on Desktop
        if (platform.equals("Desktop")) {

            Thread.sleep(5000);
            driver.findElement(By.cssSelector(".PostButt")).click();  //post A request

        } //Click on post a request on Mobile
        else if (platform.equals("Mobile")) {
            Thread.sleep(8000);
            driver.findElement(By.cssSelector("#__layout > div > div.main-content-container.home > div > div.onboardingMobile.d-sm-block.d-md-none.p-0.m-0 > div > div.bt-home-control > a.slider-post-link")).click();  //post A request
        }

        //Click on City
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#citySelect > div.dropdown-container > span")).click();
        Thread.sleep(3000);

        //City
        if (getCellData(5, 0).equals("z")) {
            // send data in the search bar
            driver.findElement(By.className("dropdown-search")).sendKeys(getCellData(4, 0));
            Thread.sleep(8000);
            // click on the selected 
            driver.findElement(By.className("option-label")).click();
            Thread.sleep(5000);

        } //City
        else {
            // send data in the search bar
            driver.findElement(By.className("dropdown-search")).sendKeys(getCellData(5, 0));
            Thread.sleep(8000);
            // click on the selected 
            driver.findElement(By.className("option-label")).click();
            Thread.sleep(5000);

        }
        //District
        if (getCellData(5, 1).equals("z")) {
            //Click on District
            driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div > div > div > div > div.row.justify-content-center > div > div:nth-child(2) > div > span")).click(); // select district
            Thread.sleep(5000);
            // send data in the search bar 
            driver.findElement(By.className("dropdown-search")).sendKeys(getCellData(4, 1));
            Thread.sleep(8000);
            // click on the selected 
            driver.findElement(By.className("option-label")).click();
            Thread.sleep(5000);
        } //District
        else if (!(getCellData(5, 1).equals("z")) && !(getCellData(5, 1).equals("nothing"))) {
            //Click on District
            driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div > div > div > div > div.row.justify-content-center > div > div:nth-child(2) > div > span")).click();
            Thread.sleep(5000);
            // send data in the search bar 
            driver.findElement(By.className("dropdown-search")).sendKeys(getCellData(5, 1));
            Thread.sleep(8000);
            // click on the selected 
            driver.findElement(By.className("option-label")).click();
            Thread.sleep(5000);
        }

        //Neighbour
        if (getCellData(5, 2).equals("z")) {
            //Click on Neighbour
            driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div > div > div > div > div.row.justify-content-center > div > div:nth-child(3) > div > span")).click();
            Thread.sleep(5000);               
            // send data in the search bar 
            driver.findElement(By.className("dropdown-search")).sendKeys(getCellData(4, 2));
            Thread.sleep(8000);
            // click on the selected 
            driver.findElement(By.className("option-label")).click();
            Thread.sleep(5000);
        } //Neighbour
        else if (!(getCellData(5, 2).equals("z")) && !(getCellData(5, 2).equals("nothing"))) {
            //Click on Neighbour
            driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div > div > div > div > div.row.justify-content-center > div > div:nth-child(3) > div > span")).click();
            Thread.sleep(5000);
            // send data in the search bar 
            driver.findElement(By.className("dropdown-search")).sendKeys(getCellData(5, 2));
            Thread.sleep(8000);
            // click on the selected 
            driver.findElement(By.className("option-label")).click();
            Thread.sleep(5000);
        }
        //Click on Next Button
        driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div > div > div > div > div.step-next-container > button")).click();   
        Thread.sleep(5000);
       
        
        
        //Select Months
        if (getCellData(5, 3).equals("z")) {
            driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div > div > main > div > div > div.mt-4.step-content.pt-2.mx-auto.col-lg-6.col-12 > div.section-white.px-minus-15 > div.row.px-2.row-cols-12 > div:nth-child(2) > button")).click();
    
        } 
        //Select Nights
        else if (getCellData(5, 3).equals("Nights")) {
            driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div > div > main > div > div > div.mt-4.step-content.pt-2.mx-auto.col-lg-6.col-12 > div.section-white.px-minus-15 > div.row.px-2.row-cols-12 > div:nth-child(1) > button")).click();

        } 
        //Select Years
        else {

            driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div > div > main > div > div > div.mt-4.step-content.pt-2.mx-auto.col-lg-6.col-12 > div.section-white.px-minus-15 > div.row.px-2.row-cols-12 > div:nth-child(3) > button")).click();
        }

        Thread.sleep(5000);
        
        if (platform.equals("Mobile")) {
            if (getCellData(5, 4).equals("z")) {
                driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/div[1]/div/div/div[2]/div[2]/main/div/div/div[2]/div[1]/div[3]/div/div/span[4]")).click();
            } else if (getCellData(5, 4).equals("3")) {
                driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/div[1]/div/div/div[2]/div[2]/main/div/div/div[2]/div[1]/div[3]/div/div/span[3]")).click();
            } else {
                driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/div[1]/div/div/div[2]/div[2]/main/div/div/div[2]/div[1]/div[3]/div/div/span[6]")).click();
            }
        }
        
        
        //Select number of (Days , Months or Years)
        
        if (platform.equals("Desktop")) {
            if (getCellData(5, 4).equals("z")) {
                driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div > div > main > div > div > div.mt-4.step-content.pt-2.mx-auto.col-lg-6.col-12 > div.section-white.px-minus-15 > div.row.mt-1 > div > div > span:nth-child(4)")).click();
            } else if (getCellData(5, 4).equals("3")) {
                driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div > div > main > div > div > div.mt-4.step-content.pt-2.mx-auto.col-lg-6.col-12 > div.section-white.px-minus-15 > div.row.mt-1 > div > div > span:nth-child(3)")).click();
            } else {
                driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div > div > main > div > div > div.mt-4.step-content.pt-2.mx-auto.col-lg-6.col-12 > div.section-white.px-minus-15 > div.row.mt-1 > div > div > span:nth-child(8)")).click();
            }
        }
       
        
        //Select Date
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#datepicker__value_")).click();
        
        
        //Enter Date
        Thread.sleep(5000);
        if (domain.equals("https://rentup.co/")) {
            driver.findElement(By.id("datepicker__dialog_")).findElements(By.tagName("footer")).get(0).findElements(By.tagName("button")).get(0).click();
        } else {
            driver.findElement(By.id("datepicker__dialog_")).findElements(By.tagName("footer")).get(1).findElements(By.tagName("button")).get(0).click();
        }
       
        
        //Enter Budget
        Thread.sleep(2000);
        if (getCellData(5, 5).equals("z")) {
            driver.findElement(By.tagName("input")).sendKeys(getCellData(4, 5));
        } else {
            driver.findElement(By.tagName("input")).sendKeys(getCellData(5, 5));
        }
        
        
        //Press on Next Button
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div > div > main > div > div > div:nth-child(3) > div > div.col-7 > div > button")).click();
        Thread.sleep(4000);

        
        //Choose Terms
        if (getCellData(5, 6).equals("z") && !(getCellData(5, 6).equals("NA"))) {
            driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div > div > div > div.mt-4.step-content.pt-2.mx-auto.col-lg-6.col-12 > div.mt-2.section-white.col-12 > main > div > div:nth-child(9)")).click();
            Thread.sleep(1000);
        }
       //no more terms 
        if (!(getCellData(5, 7).equals("NA"))) {
            driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div.p-3.post-form-container > div:nth-child(3) > div > div.mt-4.step-content.pt-2.mx-auto.col-lg-6.col-12 > div.mt-2.section-white.col-12 > main > div > div:nth-child(2) > div")).click();
            Thread.sleep(1000);
        }
        Thread.sleep(4000);

        
        
        //Select Furnishing status
        if (getCellData(5, 9).equals("z")) {
            driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div > div > div > div.mt-4.step-content.pt-2.mx-auto.col-lg-6.col-12 > div:nth-child(3) > main > div > div:nth-child(2)")).click();
        } else if (getCellData(5, 9).equals("Furnished")) {
            driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div > div > div > div.mt-4.step-content.pt-2.mx-auto.col-lg-6.col-12 > div:nth-child(3) > main > div > div:nth-child(1)")).click();
        } else {
            driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div > div > div > div.mt-4.step-content.pt-2.mx-auto.col-lg-6.col-12 > div:nth-child(3) > main > div > div:nth-child(3)")).click();
        }
        Thread.sleep(1000);
        
        
        //Choose number of min rooms
        if (!(getCellData(5, 10).equals("z"))) {
            int x = Integer.parseInt(getCellData(5, 10));
            Thread.sleep(2000);
            for (int i = 0; i <x -1 ; i++) {
                driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div > div > div > div.mt-4.step-content.pt-2.mx-auto.col-lg-6.col-12 > div:nth-child(5) > div > div.col-md-12.col-lg-8 > span > div.counter-input-contianer > button:nth-child(3) > svg")).click();
                Thread.sleep(1000);
            }
        } else {
            driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div > div > div > div.mt-4.step-content.pt-2.mx-auto.col-lg-6.col-12 > div:nth-child(5) > div > div.col-md-12.col-lg-8 > span > div.counter-input-contianer > button:nth-child(3) > svg")).click();
        }
        Thread.sleep(4000);
        
        
        
        //Choose Property types
        if (getCellData(5, 11).equals("z")) {
            driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div > div > div > div.mt-4.step-content.pt-2.mx-auto.col-lg-6.col-12 > div:nth-child(7) > main > div > div:nth-child(3)")).click();
        } else {
            if (getCellData(5, 11).equals("Duplex")) {
                driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div > div > div > div.mt-4.step-content.pt-2.mx-auto.col-lg-6.col-12 > div:nth-child(7) > main > div > div:nth-child(2)")).click();
            } else {
                driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div > div > div > div.mt-4.step-content.pt-2.mx-auto.col-lg-6.col-12 > div:nth-child(7) > main > div > div:nth-child(1)")).click();
            }
        }
        
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div > div > div > div:nth-child(3) > div > div.col-7 > div > button")).click();
        Thread.sleep(7000);
        driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div > div > div > div:nth-child(5) > button")).click();
         Thread.sleep(2000);
        return driver;
        
      /*  //Choose 
        if (getCellData(5, 12).equals("z")) {
            for (WebElement we : driver.findElements(By.tagName("span"))) {
                if (we.getText().equals("Early Check-In")) {
                    we.click();
                }
            }
            Thread.sleep(1000);

        } else {
            for (WebElement we : driver.findElements(By.tagName("span"))) {
                if (we.getText().equals("Late Check-Out")) {
                    we.click();
                }
            }
            Thread.sleep(1000);
        }

        if (getCellData(5, 13).equals("z")) {
            int x = Integer.parseInt(getCellData(4, 13));
            for (int i = 0; i < x - 1; i++) {
                driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div.p-3.post-form-container > div:nth-child(3) > div > div.mt-4.step-content.pt-2.mx-auto.col-lg-6.col-12 > div.mt-4.section-white.contract-section.col-12 > div:nth-child(1) > div.col-md-12.col-lg-4 > span > div.counter-input-contianer > button:nth-child(3)")).click();
                Thread.sleep(1000);
            }
        } else {
            int x = Integer.parseInt(getCellData(5, 13));
            for (int i = 0; i < x - 1; i++) {
                driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div.p-3.post-form-container > div:nth-child(3) > div > div.mt-4.step-content.pt-2.mx-auto.col-lg-6.col-12 > div.mt-4.section-white.contract-section.col-12 > div:nth-child(1) > div.col-md-12.col-lg-4 > span > div.counter-input-contianer > button:nth-child(3)")).click();
                Thread.sleep(1000);
            }
        }
        Thread.sleep(1000);
        if (getCellData(5, 14).equals("z")) {
            int x = Integer.parseInt(getCellData(4, 14));
            for (int i = 0; i < x - 1; i++) {
                driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div.p-3.post-form-container > div:nth-child(3) > div > div.mt-4.step-content.pt-2.mx-auto.col-lg-6.col-12 > div.mt-4.section-white.contract-section.col-12 > div:nth-child(2) > div.col-md-12.col-lg-4 > span > div.counter-input-contianer > button:nth-child(3)")).click();
                Thread.sleep(1000);
            }
        } else {
            int x = Integer.parseInt(getCellData(5, 14));
            for (int i = 0; i < x - 1; i++) {
                driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div.p-3.post-form-container > div:nth-child(3) > div > div.mt-4.step-content.pt-2.mx-auto.col-lg-6.col-12 > div.mt-4.section-white.contract-section.col-12 > div:nth-child(2) > div.col-md-12.col-lg-4 > span > div.counter-input-contianer > button:nth-child(3)")).click();
                Thread.sleep(1000);
            }
        }
        Thread.sleep(1000);
        if (getCellData(5, 15).equals("z")) {
            driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div.p-3.post-form-container > div:nth-child(3) > div > div.mt-4.step-content.pt-2.mx-auto.col-lg-6.col-12 > div.mt-4.section-white.contract-section.col-12 > div:nth-child(3) > div.col-md-12.col-lg-4 > input")).sendKeys(getCellData(4, 15));
            Thread.sleep(1000);
        } else {
            driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div.p-3.post-form-container > div:nth-child(3) > div > div.mt-4.step-content.pt-2.mx-auto.col-lg-6.col-12 > div.mt-4.section-white.contract-section.col-12 > div:nth-child(3) > div.col-md-12.col-lg-4 > input")).sendKeys(getCellData(5, 15));
            Thread.sleep(1000);
        }
        Thread.sleep(4000);
        driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div.p-3.post-form-container > div:nth-child(3) > div > div:nth-child(3) > div > div.col-7 > div > button")).click();

        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div > div.p-3.post-form-container > div:nth-child(3) > div > div:nth-child(5) > button")).click();
        Thread.sleep(2000);
*/
    
    }

    @Test
    public void ChromePostRequestTest() throws Exception {
        WebDriver driver = null;
        driver = PostRequestTest();
        if (platform.equals("Desktop")) {
            Thread.sleep(5000);
            try {
                // Check whether a certain element appears which confirms that the login was not successful
                assertEquals(true, driver.findElement(By.cssSelector("#__BVID__242___BV_tab_button__")).isDisplayed());
            } catch (NoSuchElementException e) {
                assertTrue(false);
            }
            Thread.sleep(2000);

            // Close the web driver
            driver.close();
        } else if (platform.equals("Mobile")) {
            Thread.sleep(5000);
            try {
                // Check whether a certain element appears which confirms that the login was not successful
                assertEquals(true, driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div.row.pb-3.is-mobile-device > div:nth-child(2) > svg > use")).isDisplayed());
            } catch (NoSuchElementException e) {
                assertTrue(false);
            }
            Thread.sleep(2000);

            // Close the web driver
            driver.close();
        }

    }
}
