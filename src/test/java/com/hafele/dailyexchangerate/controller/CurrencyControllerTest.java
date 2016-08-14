package com.hafele.dailyexchangerate.controller;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.hafele.dailyexchangerate.model.ExchangeRate;
import com.hafele.dailyexchangerate.service.HtmlParserService;

/**
 * Created by Omer Yaylaalti on 14/08/16.
 */

@RunWith(JUnit4.class)
public class CurrencyControllerTest {

	@Mock
	private HtmlParserService htmlParserService;

	@InjectMocks
	private CurrencyController currencyController;

	private MockMvc mockMvc;

	@Before
	public void setup() {

		// Process mock annotations
		MockitoAnnotations.initMocks(this);

		// Setup Spring test in standalone mode
		this.mockMvc = MockMvcBuilders.standaloneSetup(currencyController).build();

	}

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(currencyController).build();
	}

	@Test
	public void testFindAll() throws Exception {
		final ExchangeRate currency1 = new ExchangeRate();
		currency1.setUnit("1");
		currency1.setIsim("ABD DOLARI");
		currency1.setForexselling("2.54");
		currency1.setForexbuying("2.53");
		currency1.setCurrencyname("ABD DOLLARS");
		currency1.setCrossrateusd("3.2012");
		currency1.setCrossrateother("3.0122");
		currency1.setBanknoteselling("2.9876");
		currency1.setBanknotebuying("2.9653");

		final ExchangeRate currency2 = new ExchangeRate();
		currency2.setUnit("2");
		currency2.setIsim("Test");
		currency2.setForexselling("Test");
		currency2.setForexbuying("Test");
		currency2.setCurrencyname("Test");
		currency2.setCrossrateusd("Abd Test");
		currency2.setCrossrateother("Test");
		currency2.setBanknoteselling("Test");
		currency2.setBanknotebuying("Test");

		final List<ExchangeRate> exchangeList = new ArrayList<ExchangeRate>();
		exchangeList.add(currency1);
		exchangeList.add(currency2);

		Mockito.when(htmlParserService.getAllCurrency()).thenReturn(exchangeList);

		mockMvc.perform(MockMvcRequestBuilders.get("/"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.[*].currencyName",
						Matchers.hasItems(Matchers.endsWith("ABD DOLLARS"), Matchers.endsWith("Abd Test"))))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

}
