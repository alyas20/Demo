package com.example.demo.bean;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class ResponseBean {

	private BigDecimal amount; 
	private String subscTyp;
	private List<Date> invDates;
	
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getSubscTyp() {
		return subscTyp;
	}
	public void setSubscTyp(String subscTyp) {
		this.subscTyp = subscTyp;
	}
	public List<Date> getInvDates() {
		return invDates;
	}
	public void setInvDates(List<Date> invDates) {
		this.invDates = invDates;
	}
}
