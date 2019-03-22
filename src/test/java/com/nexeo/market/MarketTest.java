package com.nexeo.market;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.nexeo.market.config.Configurations;
import com.nexeo.market.core.PriceCalculator;
import com.nexeo.market.model.Basket;
import com.nexeo.market.model.Offer;
import com.nexeo.market.model.Product;

/**
 * Unit test for Market App.
 */
public class MarketTest {
	PriceCalculator calculator;
	
	@Before
	public void initializeOffers() {
		Configurations.createInitialOffers();
		calculator = new PriceCalculator();
	}
	
    /**
     * Test if the Apple offer is applied correctly
     *
     */
	@Test
    public void verifyAppleOfferApplied() {
    	Product product = new Product("Apple", 0.2);
    	Basket basket = new Basket();
    	basket.getProducts().put(product, 5);
    	assertTrue("Have to get the price of 3 items = 0.6 ==> ", 
    			Double.compare(calculator.calculatePrice(basket), 0.6) == 0);
    }
	
    /**
     * Test if the Watermelon offer is applied correctly
     *
     */
	@Test
    public void verifyWatermelonOfferApplied() {
    	Product product = new Product("Watermelon", 0.8);
    	Basket basket = new Basket();
    	basket.getProducts().put(product, 7);
    	assertTrue("Have to get the price of 7 items = 4  ==> ", 
    			Double.compare(calculator.calculatePrice(basket), 4) == 0);
    }
	
    /**
     * Test if the No offer is applied
     *
     */
	@Test
    public void verifyNoOfferApplied() {
    	Product product = new Product("Watermelon", 0.8);
    	Product product2 = new Product("Apple", 0.2);
    	Product product3 = new Product("Orange", 0.5);
    	Basket basket = new Basket();
    	basket.getProducts().put(product, 2);
    	basket.getProducts().put(product2, 1);
    	basket.getProducts().put(product3, 5);
    	assertTrue("Have to get the price of 8 items = 4.3  ==> ", (calculator.calculatePrice(basket) - 4.3) < 0.0001);
    }
	
    /**
     * Test if the All the offers are applied
     *
     */
	@Test
    public void verifyOffersApplied() {
    	Product product = new Product("Watermelon", 0.8);
    	Product product2 = new Product("Apple", 0.2);
    	Product product3 = new Product("Orange", 0.5);
    	Basket basket = new Basket();
    	basket.getProducts().put(product, 6);
    	basket.getProducts().put(product2, 4);
    	basket.getProducts().put(product3, 5);
    	assertTrue("Have to get the price of 15 items = 6.1  ==> ", (calculator.calculatePrice(basket) - 6.1) < 0.0001);
    }
	
    /**
     * Test if the All the offers are applied
     *	Add a new Offer on Orange
     */
	@Test
    public void verifyNewOfferIsApplied() {
    	Product product = new Product("Watermelon", 0.8);
    	Product product2 = new Product("Apple", 0.2);
    	Product product3 = new Product("Orange", 0.5);
    	Offer offer = new Offer(product3, 5, product3.getPrice());
    	Configurations.offers.add(offer);
    	Basket basket = new Basket();
    	basket.getProducts().put(product, 6);
    	basket.getProducts().put(product2, 4);
    	basket.getProducts().put(product3, 5);
    	assertTrue("Have to get the price of 15 items = 5.6  ==> ", (calculator.calculatePrice(basket) - 5.6) < 0.0001);
    }
}
