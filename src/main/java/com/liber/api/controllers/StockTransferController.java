package com.liber.api.controllers;

import com.liber.api.models.StockTransfer;
import com.liber.api.services.StockTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/stock_transfers")
public class StockTransferController {

    @Autowired
    private StockTransferService stockTransferService;

    @GetMapping
    public ArrayList<StockTransfer> getStockTransfers () {
        return stockTransferService.getStockTransfers();
    }

    @GetMapping("/{id}")
    public Optional<StockTransfer> getStockTransferById (@PathVariable int id) {
        return stockTransferService.getStockTransferById(id);
    }

    @PostMapping("/save")
    public StockTransfer saveStockTransfer (@RequestBody StockTransfer stockTransfer) {
        return stockTransferService.saveStockTransfer(stockTransfer);
    }

    @PutMapping("/update/{id}")
    public StockTransfer updateStockTransferById (@PathVariable int id, @RequestBody StockTransfer request) {
        return stockTransferService.updateStockTransferById(id, request);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean deleteStockTransferById (@PathVariable int id) {
        return stockTransferService.deleteStockTransferById(id);
    }
}
