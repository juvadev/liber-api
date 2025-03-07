package com.liber.api.controllers;

import com.liber.api.models.SaleDetails;
import com.liber.api.services.SaleDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("sales_details")
public class SaleDetailsControllers {
    @Autowired
    private SaleDetailsService saleDetailsService;

    @GetMapping
    public ArrayList<SaleDetails> getSalesDetails () {
        return saleDetailsService.getSalesDetails();
    }

    @GetMapping("/{id}")
    public Optional<SaleDetails> getSaleDetailsById (@PathVariable int id) {
        return saleDetailsService.getSaleDetailsById(id);
    }

    @PostMapping("/save")
    public SaleDetails saveSaleDetails (@RequestBody SaleDetails saleDetails) {
        return saleDetailsService.saveSaleDetails(saleDetails);
    }

    @PutMapping("/update/{id}")
    public SaleDetails updateSaleDetailsById (@PathVariable int id, @RequestBody SaleDetails request) {
        return saleDetailsService.updateSaleDetailsById(id, request);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean deleteSaleDetailsById (@PathVariable int id) {
        return saleDetailsService.deleteSaleDetailsById(id);
    }
}
