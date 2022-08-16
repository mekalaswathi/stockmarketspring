package com.stockmarketapp.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.stockmarketapp.entities.Stock;
import com.stockmarketapp.utils.StockNotFoundException;
@Service
public interface StockService {
	 public List<Stock> getAllStocks();
	 public ResponseEntity<Stock> getStockById(int id) throws StockNotFoundException;
}
