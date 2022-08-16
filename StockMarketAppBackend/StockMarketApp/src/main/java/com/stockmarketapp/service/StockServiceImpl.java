package com.stockmarketapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.stockmarketapp.entities.Stock;
import com.stockmarketapp.repositories.StockRepository;
import com.stockmarketapp.utils.StockNotFoundException;

@Service
public class StockServiceImpl implements StockService{
	@Autowired
    StockRepository stockRepository;

	 @Override
    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }

   @Override
    public ResponseEntity<Stock> getStockById(int id) throws StockNotFoundException {
        Optional<Stock> stock = stockRepository.findById(id);
        if (stock.isPresent()) {
            return new ResponseEntity<Stock>(stock.get(), HttpStatus.OK);
        } else {
            System.out.println("Stock not found with id: " + id);
            throw new StockNotFoundException("Stock not found with id: "+id);

        }
    }

}
