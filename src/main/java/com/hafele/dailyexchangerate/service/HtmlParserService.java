package com.hafele.dailyexchangerate.service;

import java.util.List;

import com.hafele.dailyexchangerate.model.ExchangeRate;
import com.hafele.dailyexchangerate.service.exception.HtmlParserServiceException;

public interface HtmlParserService {
	
	public List<ExchangeRate> getAllCurrency() throws HtmlParserServiceException ;
		

}
