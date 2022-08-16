package com.stockmarketapp.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.stockmarketapp.entities.Company;
import com.stockmarketapp.utils.CompanyNotFoundException;
@Service
public interface CompanyService {

	List<Company> getAllCompanies();

	ResponseEntity<Company> getCompanyById(String id) throws CompanyNotFoundException;

	boolean deleteCompanyByCode(String companyCode);

	ResponseEntity<Company> getStockPricesForCompany(String companyCode, String startDate, String endDate)
			throws CompanyNotFoundException, ParseException;

}
