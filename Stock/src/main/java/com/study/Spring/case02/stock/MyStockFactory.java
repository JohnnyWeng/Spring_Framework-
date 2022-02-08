package com.study.Spring.case02.stock;

import org.springframework.beans.factory.FactoryBean;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;

public class MyStockFactory implements FactoryBean<MyStock>{

	@Override
	public MyStock getObject() throws Exception {
		Stock stock = YahooFinance.get("INTC");
		Double price = stock.getQuote().getPrice().doubleValue();
		MyStock myStock = new MyStock();
		myStock.setSymbol("INTC"); // INTEL 公司股票
		myStock.setPrice(price);
		return myStock;
	}

	@Override
	public Class<?> getObjectType() {
		return MyStock.class;
	}
	
	// 這裡因為股價會變,所以會設成 false
	// 每個人進來會給他一個新的東西
	@Override
	public boolean isSingleton() {
		return false;
	}
}


