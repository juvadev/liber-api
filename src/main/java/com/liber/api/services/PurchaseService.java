package com.liber.api.services;

import com.liber.api.models.Purchase;
import com.liber.api.repositories.IPurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class PurchaseService {
    @Autowired
    private IPurchaseRepository purchaseRepository;

    public ArrayList<Purchase> getPurchases () {
        return (ArrayList<Purchase>) purchaseRepository.findAll();
    }

    public Optional<Purchase> getPurchaseById (int id) {
        return purchaseRepository.findById(id);
    }

    public Purchase savePurchase (Purchase purchase) {
        return purchaseRepository.save(purchase);
    }

    public Purchase updatePurchaseById (int id, Purchase request) {
        Optional<Purchase> optionalPurchase = purchaseRepository.findById(id);

        if (optionalPurchase.isPresent()) {
            Purchase purchase = optionalPurchase.get();
            purchase.setSupplier(request.getSupplier());
            purchase.setEmployee(request.getEmployee());
            purchase.setPurchaseDate(request.getPurchaseDate());
            purchase.setPaymentMethod(request.getPaymentMethod());
            purchase.setShippingCost(request.getShippingCost());
            purchase.setTotalAmount(request.getTotalAmount());
            return purchaseRepository.save(purchase);
        }else {
            throw new RuntimeException("Purchase not found with id " + id);
        }
    }

    public Boolean deletePurchaseById (int id) {
        try {
            purchaseRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
