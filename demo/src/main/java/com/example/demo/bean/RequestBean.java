package com.example.demo.bean;

import java.math.BigDecimal;
import java.util.Date;

public class RequestBean {
	
	private BigDecimal amount; 
	private String subscTyp;
	private String dayOfWeek;
	private Date startDate;
	private Date endDate;
	
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
	public String getDayOfWeek() {
		return dayOfWeek;
	}
	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	

}
