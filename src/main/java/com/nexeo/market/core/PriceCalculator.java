package com.nexeo.market.core;

import java.util.Map;

import com.nexeo.market.config.Configurations;
import com.nexeo.market.model.Basket;
import com.nexeo.market.model.Offer;
import com.nexeo.market.model.Product;

public class PriceCalculator implements IPriceCalculator{

	public double calculatePrice(Basket basket) {
		double price = 0;
		if (basket != null && basket.getProducts() != null) {
			for (Map.Entry<Product, Integer> entry : basket.getProducts().entrySet()) {
				price += (entry.getKey().getPrice() * entry.getValue() 
						- verifyOfferOnBasket(entry.getKey(), entry.getValue()));
			}
		}
		
		return price;
	}

	public double verifyOfferOnBasket(Product product, int quantity) {
		double offerAmount = 0;
		Offer offer = Configurations.verifyProductOffer(product);
		if (offer != null) {
			offerAmount = (quantity/offer.getQuantity()) * offer.getSalesAmount();
		}
		return offerAmount;
	}

}
