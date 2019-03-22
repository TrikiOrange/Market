package com.nexeo.market;

import java.util.HashMap;
import java.util.Map;

import com.nexeo.market.config.Configurations;
import com.nexeo.market.core.PriceCalculator;
import com.nexeo.market.model.Basket;
import com.nexeo.market.model.Product;

/**
 * Hello world!
 *
 */
public class MarketMainApp 
{
    public static void main( String[] args )
    {
    	PriceCalculator calculator = new PriceCalculator();
        Configurations.createInitialOffers();
        Basket basket = new Basket();
        basket.getProducts().put(new Product("Apple", 0.2), 4);
        basket.getProducts().put(new Product("Orange", 0.5), 3);
        basket.getProducts().put(new Product("Watermelon", 0.8), 5);
        System.out.println("\n ********************* The Basket contains ********************* \n");
        for (Map.Entry<Product, Integer> entry : basket.getProducts().entrySet()) {
        	System.out.println(entry.getKey().getName() + "   :   " + entry.getValue() + " pieces \n");
		}
        
        System.out.println("\n ********************* Calculate the price of the Basket ********************* \n");
        System.out.println("The price of the current basket is : " + calculator.calculatePrice(basket) + " £");
    }
}
