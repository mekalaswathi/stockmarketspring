package com.stockmarketapp.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stockmarketapp.entities.Company;
import com.stockmarketapp.entities.Stock;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/v1.0/market")
public class StockController {
	 AtomicInteger companyIdIndex = new AtomicInteger();
	 AtomicInteger stockIdIndex = new AtomicInteger();
	@CrossOrigin
    @PostMapping("/company/register")
    public ResponseEntity<Company> saveCompany(@RequestBody Company company) {
        //TODO test implementation - To be removed
        Company newCompany = new Company();
        newCompany.setCompanyName("Company1");
        newCompany.setCompanyCode("COMP01");
        newCompany.setCompanyCeo("Test");
        newCompany.setCompanyWebsite("www.comp1.com");
        newCompany.setStockExchange("NSE");
        newCompany.setCompanyTurnover(new BigDecimal(300000000));

        company.setId((companyIdIndex.incrementAndGet()));
        company.setCompanyCode(company.getCompanyName().substring(0, 4) +company.getId());
    	return new ResponseEntity<Company>(company,HttpStatus.OK);
    }
	
	@CrossOrigin
    @PostMapping("/stock/add/{companyCode}")
    public ResponseEntity<Stock> saveStock(@RequestBody Stock stock,@PathVariable String companyCode ) {
        //TODO test implementation - To be removed
    	stock.setCompanyName(companyCode);
    	stock.setStockPrice(new BigDecimal(580));
    	stock.setCompanyCode("COMP01");
        stock.setCreatedAt(new Date());
        stock.setId(stockIdIndex.incrementAndGet());
        return new ResponseEntity<Stock>(stock,HttpStatus.OK);
    }

    @CrossOrigin
    @DeleteMapping("/company/delete/{companyCode}")
    public ResponseEntity<?> deleteCompany(@PathVariable String companyCode) {
        return new ResponseEntity<>(Boolean.TRUE,HttpStatus.OK);
    }
}
