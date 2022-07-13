package com.stockmanagement.app.controller;

import com.stockmanagement.app.domain.StockItem;
import com.stockmanagement.app.repo.StockRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/stock")
public class StockController {
    @Autowired
    private StockRepo stockRepo;

    @GetMapping("/")
    public ResponseEntity<List<StockItem>> getAllStockItems() {
        return ResponseEntity.ok(stockRepo.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StockItem> getItemByID(@PathVariable("id") UUID id) {
        return ResponseEntity.ok(stockRepo.getItemByID(id));
    }

    @PostMapping("/")
    public void createStockItem(@RequestBody StockItem stockItem) {
        stockRepo.createStockItem(stockItem);
    }
//    @DeleteMapping("/{id}")
}
