package com.stockmarketapp.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stockmarketapp.entities.Company;
import com.stockmarketapp.service.CompanyServiceImpl;
import com.stockmarketapp.utils.CompanyNotFoundException;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/v1.0/market")
public class SearchController {
	@Autowired 
	CompanyServiceImpl companyService;
	
	
	    @GetMapping("/company/getAll")
	    public ResponseEntity<List<Company>> getAllCompanies() {
	        return new ResponseEntity<>(companyService.getAllCompanies(), HttpStatus.OK);
	    }

	  
	    @GetMapping("/company/info/{companyCode}")
	    public ResponseEntity<Company> getCompanyById(@PathVariable String  companyCode) throws CompanyNotFoundException {
	        return companyService.getCompanyById(companyCode);
	    }

	   
	    @GetMapping("/stock/get/{companyCode}/{startDate}/{endDate}")
	    public ResponseEntity<Company> getStockPricesForCompany(@PathVariable String  companyCode, @PathVariable String  startDate, @PathVariable String  endDate ) throws CompanyNotFoundException, ParseException {
	        return companyService.getStockPricesForCompany(companyCode, startDate, endDate);
	    }

}
