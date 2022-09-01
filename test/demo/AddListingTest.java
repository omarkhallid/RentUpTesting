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

    
    
 
    public WebDriver AddListingTest() throws Exception {

        
        String city, district, street, furnish, propertyType, propertyName, rentPerNight = "", rentPerMonth = "", description;
        int beds = 0, baths = 0;
        
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
        
        String email = createRandomString() + "@abc.com", password = "123456";
        System.out.println("Landlord credentials:\nEmail: " + email + "\nPassword: " + password);
        
        
        WebDriver driver = signup("auto tester", email, password, "abcdefg");
        Thread.sleep(6000);
        if (platform.equals("Desktop")){
            
            driver.findElement(By.id("list-property")).click();
            Thread.sleep(2000);
            driver.findElement(By.className("dropdown-container")).click();
            
            driver.findElement(By.className("dropdown-search")).sendKeys(city); 
            driver.findElement(By.className("option-label")).click();
            Thread.sleep(2000);
            
            driver.findElements(By.className("dropdown-container")).get(1).click();
            
            driver.findElement(By.className("dropdown-search")).sendKeys(district); 
            driver.findElement(By.className("option-label")).click();
            Thread.sleep(2000);
            
            //driver.findElement(By.tagName("input")).sendKeys(street);
            //Thread.sleep(2000);
            
            driver.findElement(By.className("properties__content")).findElements(By.tagName("button")).get(driver.findElement(By.className("properties__content")).findElements(By.tagName("button")).size() - 1).click();
        
            for (WebElement we : driver.findElement(By.className("chips-container")).findElements(By.tagName("label")))
                if (we.getText().toLowerCase().equals(furnish.toLowerCase()))
                    we.click();
        
            for (WebElement we : driver.findElements(By.className("chips-container")).get(1).findElements(By.tagName("label")))
                if (we.getText().equals(propertyType))
                    we.click();
            
            for (int i = 1; i < beds; i++)
                driver.findElements(By.className("counter-input-contianer")).get(0).findElements(By.tagName("button")).get(1).click();
            
            for (int i = 1; i < baths; i++)
                driver.findElements(By.className("counter-input-contianer")).get(1).findElements(By.tagName("button")).get(1).click();
            
            driver.findElement(By.className("properties__content")).findElements(By.tagName("button")).get(driver.findElement(By.className("properties__content")).findElements(By.tagName("button")).size() - 1).click();
            Thread.sleep(8000);
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
            
            driver.findElement(By.className("properties__content")).findElements(By.tagName("button")).get(driver.findElement(By.className("properties__content")).findElements(By.tagName("button")).size() - 1).click();
            
            for (WebElement we : driver.findElements(By.tagName("input")))
                if (we.getAttribute("placeholder").contains("Beautiful apartment")){
                    we.sendKeys(propertyName);
                    break;
                }

            driver.findElement(By.tagName("textarea")).sendKeys(description);
            
            
            
            if (!rentPerNight.equals("")){
                
                for (WebElement we : driver.findElements(By.className("chip-label")))
                    if (we.getText().contains("Per Day")){
                        we.click();
                        break;
                    }
                
                for (WebElement we : driver.findElements(By.tagName("input")))
                    if (we.getAttribute("placeholder").contains("per night")){
                        we.sendKeys(rentPerNight);
                        break;
                    }
            }
            else if (!rentPerMonth.equals("")){
                for (WebElement we : driver.findElements(By.className("chip-label")))
                    if (we.getText().contains("Per Month")){
                        we.click();
                        break;
                    }
                
                for (WebElement we : driver.findElements(By.tagName("input")))
                    if (we.getAttribute("placeholder").contains("per month")){
                        we.sendKeys(rentPerMonth);
                        break;
                    }
            }
            
            driver.findElement(By.className("upload-file-target")).click();
            
            
            // creating robot for uploading an image
            Robot rb = new Robot();

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
            driver.findElement(By.className("properties__content")).findElements(By.tagName("button")).get(driver.findElement(By.className("properties__content")).findElements(By.tagName("button")).size() - 1).click();
            
            Thread.sleep(3000);
            for (WebElement we : driver.findElements(By.tagName("button")))
                    if (we.getText().contains("Submit your request")){
                        we.click();
                        break;
                    }
            Thread.sleep(8000);
            
            //check if property was added in my properties
            boolean added = false;
            for (WebElement we : driver.findElements(By.className("property-data"))){
                if (we.findElement(By.tagName("strong")).getText().contains(propertyName.substring(2))){
                    added = true;
                    break;
                }
            }
            
            try{
                assertTrue(added);
            } catch (Exception ex){}
            
            driver.close();
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
            Robot rb = new Robot();

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
        driver = AddListingTest();

        Thread.sleep(5000);
            
            try{
            //check if property was added in my properties
            boolean added = false;
            for (WebElement we : driver.findElements(By.className("property-data"))){
                if (we.findElement(By.tagName("strong")).getText().contains(propertyName.substring(2))){
                    added = true;
                    break;
                }
            }
            
            
                assertTrue(added);
            } catch (Exception ex){}
            
            driver.close();
}
}
