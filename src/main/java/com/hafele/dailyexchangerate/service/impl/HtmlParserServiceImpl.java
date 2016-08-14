package com.hafele.dailyexchangerate.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hafele.dailyexchangerate.model.ExchangeRate;
import com.hafele.dailyexchangerate.service.HtmlParserService;
import com.hafele.dailyexchangerate.service.exception.HtmlParserServiceException;

public class HtmlParserServiceImpl implements HtmlParserService {
	

	private static final Logger logger = LoggerFactory.getLogger(HtmlParserServiceImpl.class);

	private List<String> unitList = new ArrayList<String>();
	private List<String> IsimList = new ArrayList<String>();
	private List<String> currencyNameList = new ArrayList<String>();
	private List<String> ForexBuyingList = new ArrayList<String>();
	private List<String> ForexSellingList = new ArrayList<String>();
	private List<String> BanknoteBuyingList = new ArrayList<String>();
	private List<String> BanknoteSellingList = new ArrayList<String>();
	private List<String> CrossRateUSDList = new ArrayList<String>();
	private List<String> CrossRateOtherList = new ArrayList<String>();

	@Override
	public List<ExchangeRate> getAllCurrency() throws HtmlParserServiceException {

		List<ExchangeRate> currencyList = new ArrayList<ExchangeRate>();

		try {
			// need http protocol
			Document doc = Jsoup.connect("http://www.tcmb.gov.tr/kurlar/today.xml").get();

			// get all links
			Elements Unit = doc.select("Unit");
			for (Element j : Unit) {
				unitList.add(j.text());
			}

			Elements Isim = doc.select("Isim");
			for (Element j : Isim) {
				IsimList.add(j.text());

			}

			Elements currencyName = doc.select("CurrencyName");
			for (Element j : currencyName) {
				currencyNameList.add(j.text());
			}

			Elements ForexBuying = doc.select("ForexBuying");
			for (Element j : ForexBuying) {
				ForexBuyingList.add(j.text());
			}

			Elements ForexSelling = doc.select("ForexSelling");
			for (Element j : ForexSelling) {
				ForexSellingList.add(j.text());
			}

			Elements BanknoteBuying = doc.select("BanknoteBuying");
			for (Element j : BanknoteBuying) {
				BanknoteBuyingList.add(j.text());
			}

			Elements BanknoteSelling = doc.select("BanknoteSelling");
			for (Element j : BanknoteSelling) {
				BanknoteSellingList.add(j.text());
			}

			Elements CrossRateUSD = doc.select("CrossRateUSD");
			for (Element j : CrossRateUSD) {
				CrossRateUSDList.add(j.text());
			}

			Elements CrossRateOther = doc.select("CrossRateOther");
			for (Element j : CrossRateOther) {
				CrossRateOtherList.add(j.text());
			}

			for (int i = 0; i < unitList.size(); i++) {
				ExchangeRate exchangeRate = new ExchangeRate();
				exchangeRate.setUnit(String.valueOf(unitList.get(i).toString()));
				exchangeRate.setIsim(String.valueOf(IsimList.get(i).toString()));
				exchangeRate.setForexselling(String.valueOf(ForexSellingList.get(i)));
				exchangeRate.setForexbuying(String.valueOf(ForexBuyingList.get(i)));
				exchangeRate.setCurrencyname(String.valueOf(currencyNameList.get(i)));
				exchangeRate.setCrossrateusd(String.valueOf(CrossRateUSDList.get(i)));
				exchangeRate.setCrossrateother(String.valueOf(CrossRateOtherList.get(i)));
				exchangeRate.setBanknotebuying(String.valueOf(BanknoteBuyingList.get(i)));
				exchangeRate.setBanknoteselling(String.valueOf(BanknoteSellingList.get(i)));
				currencyList.add(exchangeRate);

			}

			logger.info("Currency listesi oluşturuldu.");

		} catch (IOException e) {
			logger.error(e.getMessage());
		}
		return currencyList;
	}

}
