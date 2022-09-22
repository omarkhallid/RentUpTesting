                /*

                                        

  
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package demo;

import static demo.Methods.*;
import static demo.SignupTest.signup;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author Omar Fekry
 */
public class AddListingTest {

    
    
 
    static public WebDriver AddlistingTest() throws Exception {

        
        String city, district, street, furnish, propertyType, propertyName, rentPerNight = "", rentPerMonth = "", description;
        int beds = 0, baths = 0;
        Robot rb = new Robot();
        if (getCellData(14,0).equals("")) city = getCellData(13,0);
        else city = getCellData(14,0);
        
        if (getCellData(14,1).equals("")) district = getCellData(13,1);
        else district = getCellData(14,1);
        
        if (getCellData(14,2).equals("")) street = getCellData(13,2);
        else street = getCellData(14,2);
        
        if (getCellData(14,3).equals("")) furnish = getCellData(13,3);
        else furnish = getCellData(14,3);
        
        if (getCellData(14,4).equals("")) propertyType = getCellData(13,4);
        else propertyType = getCellData(14,4);
        
        if (getCellData(14,5).equals("")) beds = Integer.parseInt(getCellData(13,5));
        else beds = Integer.parseInt(getCellData(14,5));
        
        if (getCellData(14,6).equals("")) baths = Integer.parseInt(getCellData(13,6));
        else baths = Integer.parseInt(getCellData(14,6));
        
        if (getCellData(14,7).equals("")) propertyName = getCellData(13,7);
        else propertyName = getCellData(14,7);
        
        if (getCellData(14,8).equals("") && getCellData(14,9).equals("")) rentPerNight = getCellData(13,8);
        else if (!getCellData(14,8).equals("")) rentPerNight = getCellData(14,8);
        else if (!getCellData(14,9).equals("")) rentPerMonth = getCellData(14,9);
        
        if (getCellData(14,11).equals("")) description = getCellData(13,10);
        else description = getCellData(14,10);
        
        LandlordEmail = createRandomString() + "@test.com";
        String password = "123456";
        System.out.println("Landlord credentials:\nEmail: " + LandlordEmail + "\nPassword: " + password);
        
        setCellData(LandlordEmail, 18, 1);
        WebDriver driver = signup("auto tester", LandlordEmail, password, "abcdefg");
        Thread.sleep(6000);
        if (platform.equals("Desktop")){
            //click on i am a Landlord to open dropdown menu
            driver.findElement(By.cssSelector("#__layout > div > header > div > div.desktop-nav > div > div > div:nth-child(2) > button")).click();
            Thread.sleep(2000);
            
            // select on add a new property
            driver.findElement(By.cssSelector("#__layout > div > header > div > div.desktop-nav > div > div > div:nth-child(2) > div > div > div:nth-child(1) > div.actions > a.btn.btn_primary > div")).click();
            Thread.sleep(2000);
            
            //click on i am a Landlord inorder to close the dropdown menu
            driver.findElement(By.cssSelector("#__layout > div > header > div > div.desktop-nav > div > div > div:nth-child(2) > button")).click();
            Thread.sleep(8000);
            
            // select city 
            driver.findElement(By.cssSelector("#citySelect > div > span")).click(); 
            driver.findElement(By.className("dropdown-search")).sendKeys(city); 
            driver.findElement(By.className("option-label")).click();
            Thread.sleep(5000);
            
            //select district
            driver.findElement(By.cssSelector("#districtSelect > div.dropdown-container > span")).click();
            driver.findElement(By.className("dropdown-search")).sendKeys(district); 
            driver.findElement(By.className("option-label")).click();
            Thread.sleep(2000);
            
            //select neighbourhood
            driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div.is-desktop-device > div > div.row.align-items-center > div > div > div.mb-4.m-auto.col-lg-4 > div > input")).sendKeys("AutomationTestRentUP");
           
            Thread.sleep(2000);

            
            //driver.findElement(By.tagName("input")).sendKeys(street);
            //Thread.sleep(2000);
            // press on next
            driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div.is-desktop-device > div > div.col-12.mt-3.d-flex.justify-content-center.actions_buttons > button.btn.mx-2.next_button.col-2.btn-primary")).click();
            //driver.findElement(By.className("properties__content")).findElements(By.tagName("button")).get(driver.findElement(By.className("properties__content")).findElements(By.tagName("button")).size() - 1).click();
            Thread.sleep(6000);
//            for (WebElement we : driver.findElement(By.className("chips-container")).findElements(By.tagName("label")))
//                if (we.getText().toLowerCase().equals(furnish.toLowerCase()))
//                    we.click();
            //select furnished
            if(furnish.equals("Furnished"))
            {
                 for (WebElement we : driver.findElements(By.tagName("span")))
                           if (we.getText().equals("Furnished"))
                                    we.click();
            }
            // select unfurnished
            else if(furnish.equals("Unfurnished"))
            {
                for (WebElement we : driver.findElements(By.tagName("span")))
                           if (we.getText().equals("Unfurnished"))
                                    we.click();
            } // select serviced Apartment
            else
            {
                 for (WebElement we : driver.findElements(By.tagName("span")))
                           if (we.getText().equals("Serviced Apartment"))
                                    we.click();
            }
            
            if(propertyType.equals("Apartment"))
            {
                 for (WebElement we : driver.findElements(By.tagName("span")))
                           if (we.getText().equals("Apartment"))
                                    we.click();
            }
            // select unfurnished
            else if(propertyType.equals("Studio"))
            {
                for (WebElement we : driver.findElements(By.tagName("span")))
                           if (we.getText().equals("Studio"))
                                    we.click();
            } // select serviced Apartment
            else
            {
                 for (WebElement we : driver.findElements(By.tagName("span")))
                           if (we.getText().equals("Villa"))
                                    we.click();
            }
           
//            // select property type
//            for (WebElement we : driver.findElements(By.className("chips-container")).get(1).findElements(By.tagName("label")))
//                if (we.getText().equals(propertyType))
//                    we.click();
            
            // select number of beds
            for (int i = 1; i < beds; i++)
                driver.findElement(By.cssSelector(".rooms-number > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > span:nth-child(1) > div:nth-child(1) > button:nth-child(3)")).click();
            
            // select number of baths
            for (int i = 1; i < baths; i++)
                //driver.findElements(By.className("counter-input-contianer")).get(1).findElements(By.tagName("button")).get(1).click();
                driver.findElement(By.cssSelector(".rooms-number > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > span:nth-child(1) > div:nth-child(1) > button:nth-child(3)")).click();
            // select next button
     
                 driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div.is-desktop-device > div > div.col-12.mt-3.d-flex.justify-content-center.actions_buttons > button.btn.mx-2.next_button.col-2.btn-primary")).click();
            Thread.sleep(4000);
            //driver.findElements(By.className("chips-container")).get(2).click();
//            try{
//                driver.findElements(By.className("chips-container")).get(2).findElement(By.className("chip-label")).click();
//            } catch (Exception ex){}
           
            try{
                
                driver.findElements(By.className("amenities")).get(0).findElement(By.className("chip")).click();
//                for (WebElement we : driver.findElements(By.tagName("span")))
//                if (we.getText().equals("Desk"))
//                    we.click();
            
            } catch (Exception ex){
               System.out.println( ex.getMessage());
            
            }


            try{
                driver.findElements(By.className("amenities")).get(1).findElement(By.className("chip")).click();
//                 for (WebElement we : driver.findElements(By.tagName("span")))
//                if (we.getText().equals("Cooker"))
//                    we.click();
            } catch (Exception ex){}


            try{
                driver.findElements(By.className("amenities")).get(2).findElement(By.className("chip")).click();
//                 for (WebElement we : driver.findElements(By.tagName("span")))
//                if (we.getText().equals("Shampoo"))
//                    we.click();
            } catch (Exception ex){}
            
            driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div.is-desktop-device > div > div.col-12.mt-3.d-flex.justify-content-center.actions_buttons > button.btn.mx-2.next_button.col-2.btn-primary")).click();
            
           Thread.sleep(6000);
            driver.findElements(By.tagName("input")).get(1).sendKeys(propertyName);
            
            Thread.sleep(2000);
            driver.findElements(By.tagName("textarea")).get(1).sendKeys(description);
            Thread.sleep(2000);
            
            
            if (!rentPerNight.equals("")){
                
//                for (WebElement we : driver.findElements(By.className("chip-label")))
//                    if (we.getText().contains("Per Day")){
//                        we.click();
//                        break;
//                    }
            for (WebElement we : driver.findElements(By.tagName("span")))
                                       if (we.getText().equals("per night"))
                                                we.click();
                
            Thread.sleep(2000);
            driver.findElements(By.tagName("input")).get(3).sendKeys(rentPerNight);  
            Thread.sleep(2000);
            }
            else if (!rentPerMonth.equals("")){
                for (WebElement we : driver.findElements(By.className("span")))
                    if (we.getText().equals("Per Month")){
                        we.click();
                        break;
                    }
                
            Thread.sleep(2000);
            driver.findElements(By.tagName("input")).get(3).sendKeys(rentPerMonth);
            Thread.sleep(2000);
            }
            driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div.is-desktop-device > div > div.col-12.mt-3.d-flex.justify-content-center.actions_buttons > button.btn.mx-2.next_button.col-2.btn-primary")).click();
            
            Thread.sleep(2000);
            driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div.is-desktop-device > div > div.row.align-items-center > div > div > div.img-video-container > div > div")).click();
            //driver.findElement(By.className("upload-file-target")).click();
            
            
            // creating robot for uploading an image
            

            // copying File path to Clipboard
            StringSelection str = new StringSelection(new java.io.File(".").getCanonicalPath() + "\\test\\Resources\\placeholder.png");
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
            
            Thread.sleep(2000);
             // press Contol+V for pasting
             rb.keyPress(KeyEvent.VK_CONTROL);
             rb.keyPress(KeyEvent.VK_V);

            // release Contol+V for pasting
            rb.keyRelease(KeyEvent.VK_CONTROL);
            rb.keyRelease(KeyEvent.VK_V);

            // for pressing and releasing Enter

            rb.keyPress(KeyEvent.VK_ENTER);
            rb.keyRelease(KeyEvent.VK_ENTER);
            
            Thread.sleep(3000);
            driver.findElement(By.cssSelector("#__layout > div > div.main-content-container > div > div.is-desktop-device > div > div.col-12.mt-3.d-flex.justify-content-center.actions_buttons > button.btn.mx-2.next_button.col-2.btn-primary")).click();
            
            Thread.sleep(3000);
            driver.findElements(By.tagName("button")).get(7).click();
            Thread.sleep(8000);
            
        }

        else if (platform.equals("Mobile")){
            
            driver.findElement(By.className("burger-menu")).click();
            driver.findElement(By.className("sidebar-first-button")).click();
            
            driver.findElement(By.tagName("form")).findElements(By.className("dropdown-container")).get(0).click();
            
            for (WebElement element : driver.findElements(By.className("option-label"))){
                if (element.getText().equals(city)){
                    element.click();
                    break;
                }
            }
            Thread.sleep(5000);
            
            driver.findElement(By.tagName("form")).findElements(By.className("dropdown-container")).get(1).click();
            
            for (WebElement element : driver.findElements(By.className("option-label"))){
                if (element.getText().equals(district)){
                    element.click();
                    break;
                }
            }
            Thread.sleep(2000);
            
            //driver.findElement(By.tagName("input")).sendKeys(street);
            //Thread.sleep(2000);
            
            driver.findElement(By.className("actions-container")).findElements(By.tagName("button")).get(1).click();
        
            for (WebElement we : driver.findElement(By.tagName("form")).findElement(By.className("second-step")).findElement(By.className("chips-container")).findElements(By.tagName("label")))
                if (we.getText().toLowerCase().equals(furnish.toLowerCase()))
                    we.click();
        
            for (WebElement we : driver.findElement(By.tagName("form")).findElement(By.className("second-step")).findElements(By.className("chips-container")).get(1).findElements(By.tagName("label")))
                if (we.getText().equals(propertyType))
                    we.click();
            
            for (int i = 1; i < beds; i++)
                driver.findElement(By.className("second-step")).findElements(By.className("counter-input-contianer")).get(0).findElements(By.tagName("button")).get(1).click();
            
            for (int i = 1; i < baths; i++)
                driver.findElement(By.className("second-step")).findElements(By.className("counter-input-contianer")).get(1).findElements(By.tagName("button")).get(1).click();
            
            driver.findElement(By.className("second-step")).findElement(By.className("actions-container")).findElements(By.tagName("button")).get(1).click();
            Thread.sleep(8000);

            
            try{
                driver.findElement(By.className("third-step")).findElements(By.className("chips-container")).get(0).findElement(By.className("chip-label")).click();
            } catch (Exception ex){}


            try{
                driver.findElement(By.className("third-step")).findElements(By.className("chips-container")).get(1).findElement(By.className("chip-label")).click();
            } catch (Exception ex){}


            try{
                driver.findElement(By.className("third-step")).findElements(By.className("chips-container")).get(2).findElement(By.className("chip-label")).click();
            } catch (Exception ex){}
            
            driver.findElement(By.className("third-step")).findElement(By.className("actions-container")).findElements(By.tagName("button")).get(1).click();
            
            driver.findElement(By.className("fourth_step")).findElement(By.tagName("input")).sendKeys(propertyName);
                    
            driver.findElement(By.className("fourth_step")).findElement(By.tagName("textarea")).sendKeys(description);
            
            
            
            if (!rentPerNight.equals("")){
                
                for (WebElement we : driver.findElement(By.className("fourth_step")).findElements(By.className("chip-label")))
                    if (we.getText().contains("per night")){
                        we.click();
                        break;
                    }
                
                for (WebElement we : driver.findElement(By.className("fourth_step")).findElements(By.tagName("input")))
                    if (we.getAttribute("placeholder").contains("per night")){
                        we.sendKeys(rentPerNight);
                        break;
                    }
            }
            else if (!rentPerMonth.equals("")){
                for (WebElement we : driver.findElement(By.className("fourth_step")).findElements(By.className("chip-label")))
                    if (we.getText().contains("per month")){
                        we.click();
                        break;
                    }
                
                for (WebElement we : driver.findElement(By.className("fourth_step")).findElements(By.tagName("input")))
                    if (we.getAttribute("placeholder").contains("per month")){
                        we.sendKeys(rentPerMonth);
                        break;
                    }
            }
            
            driver.findElement(By.className("fourth_step")).findElement(By.className("actions-container")).findElements(By.tagName("button")).get(1).click();
            
            driver.findElement(By.className("fifth-step")).findElement(By.className("upload-file-target")).click();
            
            
            // creating robot for uploading an image
           

            // copying File path to Clipboard
            StringSelection str = new StringSelection(new java.io.File(".").getCanonicalPath() + "\\test\\Resources\\placeholder.png");
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
            
            Thread.sleep(2000);
             // press Contol+V for pasting
            rb.keyPress(KeyEvent.VK_CONTROL);
            rb.keyPress(KeyEvent.VK_V);

            // release Contol+V for pasting
            rb.keyRelease(KeyEvent.VK_CONTROL);
            rb.keyRelease(KeyEvent.VK_V);

            // for pressing and releasing Enter
            Thread.sleep(1000);
            rb.keyPress(KeyEvent.VK_ENTER);
            rb.keyRelease(KeyEvent.VK_ENTER);
            
            Thread.sleep(3000);

            driver.findElement(By.className("fifth-step")).findElement(By.className("actions-container")).findElements(By.tagName("button")).get(1).click();
            
            Thread.sleep(3000);
            for (WebElement we : driver.findElements(By.tagName("button")))
                    if (we.getText().contains("Submit your request")){
                        we.click();
                        break;
                    }
            
        }
        
        return driver;
        
    }
    @Test
    public void ChromeAddListingTest() throws Exception {
        WebDriver driver=null;
        driver = AddlistingTest();
        boolean flag= false;
        Thread.sleep(8000);
        if(platform.equals("Desktop"))
        {
        try {
            // Check whether a certain element appears which confirms that the login was not successful
            assertEquals(true, driver.findElement(By.tagName("h1")).isDisplayed()); 
        } catch(NoSuchElementException e){
            assertTrue(false);
            driver.close();
        }
        Thread.sleep(2000);
//        for (WebElement we : driver.findElements(By.tagName("span")))
//                    if (we.getText().contains("Sort")){
//                        flag=true;
//                        break;
//                    }
//        try {
//            // Check whether a certain element appears which confirms that the login was not successful
//            assertEquals(true, flag); 
//        } catch(NoSuchElementException e){
//            assertTrue(false);
//            driver.close();
//        }
        driver.close();
        Thread.sleep(2000);
    }
}
}

