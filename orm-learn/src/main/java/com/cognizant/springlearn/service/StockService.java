package com.cognizant.springlearn.service;

import com.cognizant.springlearn.model.Stock;
import com.cognizant.springlearn.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    @Transactional(readOnly = true)
    public List<Stock> findByCodeAndDateBetween(String code, LocalDate startDate, LocalDate endDate) {
        return stockRepository.findByCodeAndDateBetween(code, startDate, endDate);
    }

    @Transactional(readOnly = true)
    public List<Stock> findByCodeAndCloseGreaterThan(String code, double price) {
        return stockRepository.findByCodeAndCloseGreaterThan(code, price);
    }

    @Transactional(readOnly = true)
    public List<Stock> findTop3ByOrderByVolumeDesc() {
        return stockRepository.findTop3ByOrderByVolumeDesc();
    }

    @Transactional(readOnly = true)
    public List<Stock> findTop3ByCodeOrderByCloseAsc(String code) {
        return stockRepository.findTop3ByCodeOrderByCloseAsc(code);
    }
}