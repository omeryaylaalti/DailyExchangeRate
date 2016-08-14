package com.hafele.dailyexchangerate.model;

public class ExchangeRate {
	
	
	private String unit;
	private String isim;
	private String currencyname;
	private String forexbuying;
	private String forexselling;
	private String banknotebuying;
	private String banknoteselling;
	
	private String crossrateusd;
	private String crossrateother;
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getIsim() {
		return isim;
	}
	public void setIsim(String isim) {
		this.isim = isim;
	}
	public String getCurrencyname() {
		return currencyname;
	}
	public void setCurrencyname(String currencyname) {
		this.currencyname = currencyname;
	}
	public String getForexbuying() {
		return forexbuying;
	}
	public void setForexbuying(String forexbuying) {
		this.forexbuying = forexbuying;
	}
	public String getForexselling() {
		return forexselling;
	}
	public void setForexselling(String forexselling) {
		this.forexselling = forexselling;
	}
	public String getBanknotebuying() {
		return banknotebuying;
	}
	public void setBanknotebuying(String banknotebuying) {
		this.banknotebuying = banknotebuying;
	}
	public String getBanknoteselling() {
		return banknoteselling;
	}
	public void setBanknoteselling(String banknoteselling) {
		this.banknoteselling = banknoteselling;
	}
	public String getCrossrateusd() {
		return crossrateusd;
	}
	public void setCrossrateusd(String crossrateusd) {
		this.crossrateusd = crossrateusd;
	}
	public String getCrossrateother() {
		return crossrateother;
	}
	public void setCrossrateother(String crossrateother) {
		this.crossrateother = crossrateother;
	}
	@Override
	public String toString() {
		return "ExchangeRate [unit=" + unit + ", isim=" + isim + ", currencyname=" + currencyname + ", forexbuying="
				+ forexbuying + ", forexselling=" + forexselling + ", banknotebuying=" + banknotebuying
				+ ", banknoteselling=" + banknoteselling + ", crossrateusd=" + crossrateusd + ", crossrateother="
				+ crossrateother + "]";
	}

	
	
	
	
	

}
