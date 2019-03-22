package com.nexeo.market.config;

import java.util.ArrayList;
import java.util.List;

import com.nexeo.market.model.Offer;
import com.nexeo.market.model.Product;

public class Configurations {
	
	public static List<Offer> offers;
	
	//TODO: this part will be linked to DB to verify if ther's an offer
	public static Offer verifyProductOffer(Product product){
		Offer offer = null;
		for (Offer currentOffer : offers) {
			if (currentOffer.getProduct().equals(product)) {
				offer = currentOffer;
				break;
			}
			
		}
		return offer;
	}
	
	//This part to initialize the offers in the test
	public static void createInitialOffers() {
		
		offers = new ArrayList<Offer>();
		
		//Apple Offer
		Product appleProduct = new Product("Apple", 0.2);
		Offer appleOffer = new Offer(appleProduct, 2, appleProduct.getPrice());
		offers.add(appleOffer);
		
		//Watermelon Offer
		Product wmProduct = new Product("Watermelon", 0.8);
		Offer wmOffer = new Offer(wmProduct, 3, wmProduct.getPrice());
		offers.add(wmOffer);
	}

}
