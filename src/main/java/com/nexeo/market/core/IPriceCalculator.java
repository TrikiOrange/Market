package com.nexeo.market.core;

import com.nexeo.market.model.Basket;
import com.nexeo.market.model.Product;

public interface IPriceCalculator {
	
	public double calculatePrice(Basket basket);
	
	public double verifyOfferOnBasket(Product product, int quantity);

}
