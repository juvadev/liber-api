package com.liber.api.services;

import com.liber.api.models.PurchaseDetails;
import com.liber.api.repositories.IPurchaseDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class PurchaseDetailsService {
    @Autowired
    private IPurchaseDetailsRepository purchaseDetailsRepository;

    public ArrayList<PurchaseDetails> getPurchasesDetails () {
        return (ArrayList<PurchaseDetails>) purchaseDetailsRepository.findAll();
    }

    public Optional<PurchaseDetails> getPurchaseDetailsById (int id) {
        return purchaseDetailsRepository.findById(id);
    }

    public PurchaseDetails savePurchaseDetails (PurchaseDetails purchaseDetails) {
        return purchaseDetailsRepository.save(purchaseDetails);
    }

    public PurchaseDetails updatePurchaseDetailsById (int id, PurchaseDetails request) {
        Optional<PurchaseDetails> optionalPurchaseDetails = purchaseDetailsRepository.findById(id);

        if (optionalPurchaseDetails.isPresent()) {
            PurchaseDetails purchaseDetails = optionalPurchaseDetails.get();
            purchaseDetails.setPurchase(request.getPurchase());
            purchaseDetails.setProduct(request.getProduct());
            purchaseDetails.setQuantity(request.getQuantity());
            purchaseDetails.setUnitPrice(request.getUnitPrice());
            purchaseDetails.setDiscount(request.getDiscount());
            purchaseDetails.setSubtotal(request.getSubtotal());
            return purchaseDetailsRepository.save(purchaseDetails);
        } else {
            throw new RuntimeException("PurchaseDetails not found with id " + id);
        }
    }

    public Boolean deletePurchaseDetailsById (int id) {
        try {
            purchaseDetailsRepository.deleteById(id);
            return true;

        } catch (Exception e) {
            return false;
        }
    }
}
