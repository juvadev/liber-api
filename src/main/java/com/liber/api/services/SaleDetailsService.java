package com.liber.api.services;

import com.liber.api.models.SaleDetails;
import com.liber.api.repositories.ISaleDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class SaleDetailsService {
    @Autowired
    private ISaleDetailsRepository saleDetailsRepository;

    public ArrayList<SaleDetails> getSalesDetails () {
        return (ArrayList<SaleDetails>) saleDetailsRepository.findAll();
    }

    public Optional<SaleDetails> getSaleDetailsById (int id) {
        return saleDetailsRepository.findById(id);
    }

    public SaleDetails saveSaleDetails (SaleDetails saleDetails) {
        return saleDetailsRepository.save(saleDetails);
    }

    public SaleDetails updateSaleDetailsById (int id, SaleDetails request) {
        Optional<SaleDetails> optionalSaleDetails = saleDetailsRepository.findById(id);

        if (optionalSaleDetails.isPresent()) {
            SaleDetails saleDetails = optionalSaleDetails.get();
            saleDetails.setSale(request.getSale());
            saleDetails.setProduct(request.getProduct());
            saleDetails.setQuantity(request.getQuantity());
            saleDetails.setUnitPrice(request.getUnitPrice());
            saleDetails.setDiscount(request.getDiscount());
            saleDetails.setSubtotal(request.getSubtotal());
            return saleDetailsRepository.save(saleDetails);
        } else {
            throw new RuntimeException("Sale Details not found with id " + id);
        }
    }

    public Boolean deleteSaleDetailsById (int id) {
        try {
            saleDetailsRepository.deleteById(id);
            return true;

        } catch (Exception e) {
            return false;
        }
    }
}
