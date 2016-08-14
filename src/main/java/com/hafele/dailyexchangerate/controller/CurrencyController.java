package com.hafele.dailyexchangerate.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hafele.dailyexchangerate.service.HtmlParserService;
import com.hafele.dailyexchangerate.service.impl.HtmlParserServiceImpl;

/**
 * Handles requests for the application home page.
 */
@Controller
public class CurrencyController {

	private static final Logger logger = LoggerFactory.getLogger(CurrencyController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home() {

		logger.info("Controller metoduna girildi.");

		HtmlParserService htmlParser = new HtmlParserServiceImpl();

		ModelAndView model = new ModelAndView("home");

		model.addObject("currencyList", htmlParser.getAllCurrency());
		
		return model;

	}

}
