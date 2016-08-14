package com.hafele.dailyexchangerate.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.hafele.dailyexchangerate.model.ExchangeRate;

/**
 * Created by Omer Yaylaalti on 14/08/16.
 */
@RunWith(JUnit4.class)
@ContextConfiguration(value = { "classpath*:springDataContext-test.xml" })
public class HtmlParserServiceTest {
	
	@Autowired
	HtmlParserService htmlParserService;
	
	static ExchangeRate exchangeRate;
	
	@Before
	public void init() {
		if (exchangeRate != null) {
			return;
		}
		exchangeRate = new ExchangeRate();
		exchangeRate.setUnit("1");
		exchangeRate.setIsim("ABD DOLARI");
		exchangeRate.setForexselling("2.54");
		exchangeRate.setForexbuying("2.53");
		exchangeRate.setCurrencyname("ABD DOLLLARS");
		exchangeRate.setCrossrateusd("3.2012");
		exchangeRate.setCrossrateother("3.0122");
		exchangeRate.setBanknoteselling("2.9876");
		exchangeRate.setBanknotebuying("2.9653");
	}
	
	@Test
	public void testGetAllCurrency() {
		List<ExchangeRate> currency = htmlParserService.getAllCurrency();
		if (!currency.isEmpty()) {
			Assert.assertNotNull(currency);

		}
	}
	
}
