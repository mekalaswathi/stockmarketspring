package com.stockmarketapp.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.stockmarketapp.entities.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock,Integer>{
//	//@Query("{'createdAt' : { $gte: ?0, $lte: ?1 }, 'companyCode' : ?2 }")
//    public List<Stock> getStocksForCompany(Date from, Date to,String companyCode);
    
    @Query(value="select * from stock where created_at >= :from and created_at<:to and companyCode=:companyCode",nativeQuery = true)
    public List<Stock> getStocksForCompany(@Param("from") Date from,@Param("to") Date to,String companyCode);

    List<Stock> getStockByCompanyCode(String companyCode);
    Stock deleteAllStockByCompanyCode(String s);
}
