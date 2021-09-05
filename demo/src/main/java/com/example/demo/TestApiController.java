package com.example.demo;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.xml.ws.WebServiceException;

import org.springframework.boot.web.server.WebServerException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.RequestBean;
import com.example.demo.bean.ResponseBean;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/testapi")
public class TestApiController {
	
	@RequestMapping(value = "/insert/", method = RequestMethod.POST)
	public ResponseEntity<ResponseBean> Test(@RequestBody RequestBean requestBean) throws WebServerException   
	{  
		Calendar c = Calendar.getInstance(); 
		c.setTime(requestBean.getStartDate()); 
		c.add(Calendar.MONTH, 4);
		Date lastday = c.getTime();
		
		if(requestBean.getEndDate().after(lastday)) {
			throw new WebServiceException("End date is more than 3 month");
		}
		
		List<Date> dates = new ArrayList<Date>();
		if("DAILY".equals(requestBean.getSubscTyp())) {
			dailyFunction(dates , requestBean.getStartDate(), requestBean.getEndDate());
		}else if("WEEKLY".equals(requestBean.getSubscTyp())) {
			weeklyFunction(dates , requestBean.getStartDate(), requestBean.getEndDate());
		}else if ("MONTHLY".equals(requestBean.getSubscTyp())){
			monthlyFunction(dates , requestBean.getStartDate(), requestBean.getEndDate());
		}
		
		ResponseBean responseBean = new ResponseBean();
		responseBean.setAmount(requestBean.getAmount());
		responseBean.setSubscTyp(requestBean.getSubscTyp());
		responseBean.setInvDates(dates);
		
	return  ResponseEntity.ok().body(responseBean);
	}


	private void dailyFunction(List<Date> dates, Date startDate, Date endDate) {
		Date currentDate = getActualDate(startDate);
		while(currentDate.compareTo(endDate) <= 0) {
			dates.add(currentDate);
			Calendar c = Calendar.getInstance(); 
			c.setTime(currentDate); 
			c.add(Calendar.DATE, 1);
			currentDate = c.getTime();
		}
	} 
	
	private void weeklyFunction(List<Date> dates, Date startDate, Date endDate) {
		Date currentDate = getActualDate(startDate);
		while(currentDate.compareTo(endDate) <= 0) {
			dates.add(currentDate);
			Calendar c = Calendar.getInstance(); 
			c.setTime(currentDate); 
			c.add(Calendar.DATE, 7);
			currentDate = c.getTime();
		}
	}
	

	private void monthlyFunction(List<Date> dates, Date startDate, Date endDate) {
		Date currentDate = getActualDate(startDate);
		while(currentDate.compareTo(endDate) <= 0) {
			dates.add(currentDate);
			Calendar c = Calendar.getInstance(); 
			c.setTime(currentDate); 
			c.add(Calendar.MONTH, 1);
			currentDate = c.getTime();
		}
	}

	private Date getActualDate(Date startDate) {
		Calendar c = Calendar.getInstance(); 
		c.setTime(startDate); 
		c.add(Calendar.DATE,1);
		return c.getTime();
	}
	

}
