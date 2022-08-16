package com.stockmarketapp.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.stockmarketapp.entities.Company;
import com.stockmarketapp.entities.Stock;
import com.stockmarketapp.repositories.CompanyRepository;
import com.stockmarketapp.repositories.StockRepository;
import com.stockmarketapp.utils.CompanyNotFoundException;
@Service
public class CompanyServiceImpl implements CompanyService{
	 @Autowired
	    CompanyRepository companyRepository;

	    @Autowired
	    StockRepository stockRepository;
	    @Override
	    public List<Company> getAllCompanies() {
	        return companyRepository.findAll();
	    }
	    @Override
	    public ResponseEntity<Company> getCompanyById(String id) throws CompanyNotFoundException {
	        Company company = companyRepository.findCompanyByCompanyCode(id);
	        if (null != company) {
	            List<Stock> stocksForCompany = stockRepository.getStockByCompanyCode(id);
	            if (CollectionUtils.isEmpty(stocksForCompany)) {
	               
	            }
	            company.setStocks(stocksForCompany);
	            return new ResponseEntity<Company>(company, HttpStatus.OK);
	        } else {
	            throw new CompanyNotFoundException("Company not found with id: "+id);

	        }
	    }

	    @Override
	    public ResponseEntity<Company> getStockPricesForCompany(String companyCode, String startDate, String endDate) throws CompanyNotFoundException, ParseException {
	        Company company = companyRepository.findCompanyByCompanyCode(companyCode);
	        if (null != company) {
	            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	            List<Stock> stocksForCompany = stockRepository.getStocksForCompany(simpleDateFormat.parse(startDate), simpleDateFormat.parse(endDate), companyCode);
	            if (CollectionUtils.isEmpty(stocksForCompany)) {
	            }
	            company.setStocks(stocksForCompany);
	            return new ResponseEntity<Company>(company, HttpStatus.OK);
	        } else {
	            throw new CompanyNotFoundException("Company not found with id: "+companyCode);

	        }
	    }
	    @Override
	    public boolean deleteCompanyByCode(String companyCode) {
	        companyRepository.deleteCompanyByCompanyCode(companyCode);
	        stockRepository.deleteAllStockByCompanyCode(companyCode);
	        return true;
	    }

}
