package com.liber.api.controllers;

import com.liber.api.models.Sale;
import com.liber.api.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/sales")
public class SaleController {
    @Autowired
    private SaleService saleService;

    @GetMapping
    public ArrayList<Sale> getSales () {
        return saleService.getSales();
    }

    @GetMapping("/{id}")
    public Optional<Sale> getSaleById (@PathVariable int id) {
        return saleService.getSaleById(id);
    }

    @PostMapping("/save")
    public Sale saveSale (@RequestBody Sale sale) {
        return saleService.saveSale(sale);
    }

    @PutMapping("/update/{id}")
    public Sale updateSaleById (@PathVariable int id, @RequestBody Sale request) {
        return saleService.updateSaleById(id, request);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean deleteSaleById (@PathVariable int id) {
        return saleService.deleteSaleById(id);
    }
}
