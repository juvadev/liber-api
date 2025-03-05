package com.liber.api.controllers;

import com.liber.api.models.PurchaseDetails;
import com.liber.api.services.PurchaseDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/purchases_details")
public class PurchaseDetailsController {
    @Autowired
    private PurchaseDetailsService purchaseDetailsService;

    @GetMapping
    public ArrayList<PurchaseDetails> getPurchasesDetails () {
        return purchaseDetailsService.getPurchasesDetails();
    }

    @GetMapping("/{id}")
    public Optional<PurchaseDetails> getPurchaseDetailsById (@PathVariable int id) {
        return purchaseDetailsService.getPurchaseDetailsById(id);
    }

    @PostMapping("/save")
    public PurchaseDetails savePurchaseDetails (@RequestBody PurchaseDetails purchaseDetails) {
        return purchaseDetailsService.savePurchaseDetails(purchaseDetails);
    }

    @PutMapping("/update/{id}")
    public PurchaseDetails updatePurchaseDetailsById (@PathVariable int id, @RequestBody PurchaseDetails request) {
        return purchaseDetailsService.updatePurchaseDetailsById(id, request);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean deletePurchaseDetailsById (@PathVariable int id) {
        return purchaseDetailsService.deletePurchaseDetailsById(id);
    }
}
