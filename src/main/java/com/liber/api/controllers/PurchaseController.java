package com.liber.api.controllers;

import com.liber.api.models.Purchase;
import com.liber.api.services.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping ("/purchases")
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;

    @GetMapping
    public ArrayList<Purchase> getPurchases () {
        return purchaseService.getPurchases();
    }

    @GetMapping("/{id}")
    public Optional<Purchase> getPurchaseById (@PathVariable int id) {
        return purchaseService.getPurchaseById(id);
    }

    @PostMapping("/save")
    public Purchase savePurchase (@RequestBody Purchase purchase) {
        return purchaseService.savePurchase(purchase);
    }

    @PutMapping("/update/{id}")
    public Purchase updatePurchaseById (@PathVariable int id, @RequestBody Purchase request) {
        return purchaseService.updatePurchaseById(id, request);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean deletePurchaseById (@PathVariable int id) {
        return purchaseService.deletePurchaseById(id);
    }
}
