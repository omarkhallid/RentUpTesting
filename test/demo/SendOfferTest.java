/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demo;

import org.junit.Test;

/**
 *
 * @author Tarek Radwan
 */
public class SendOfferTest {
    PostRequesttest p = new PostRequesttest();
    AddListingTest t = new AddListingTest();
    @Test
    public void Offertest() throws Exception
    {
        p.ChromePostRequestTest();
        t.ChromeTest();
    }
}
