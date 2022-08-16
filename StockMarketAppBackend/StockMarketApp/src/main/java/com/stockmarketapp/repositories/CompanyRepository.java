package com.stockmarketapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stockmarketapp.entities.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Integer>{
	 Company deleteCompanyByCompanyCode(String s);
	    Company findCompanyByCompanyCode(String s);
}
