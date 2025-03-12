package com.liber.api.services;

import com.liber.api.models.Sale;
import com.liber.api.repositories.ISaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class SaleService {
    @Autowired
    private ISaleRepository saleRepository;

    public ArrayList<Sale> getSales() {
        return (ArrayList<Sale>) saleRepository.findAll();
    }

    public Optional<Sale> getSaleById (int id) {
        return saleRepository.findById(id);
    }

    public Sale saveSale (Sale sale) {
        return saleRepository.save(sale);
    }

    public Sale updateSaleById (int id, Sale request) {
        Optional<Sale> optionalSale = saleRepository.findById(id);

        if (optionalSale.isPresent()) {
            Sale sale = optionalSale.get();
            sale.setEmployee(request.getEmployee());
            sale.setSaleDate(request.getSaleDate());
            sale.setPaymentMethod(request.getPaymentMethod());
            sale.setTotalAmount(request.getTotalAmount());
            return saleRepository.save(sale);
        } else {
            throw new RuntimeException("Sale not found with id " + id);
        }
    }

    public Boolean deleteSaleById (int id) {
        try {
            saleRepository.deleteById(id);
            return true;

        } catch (Exception e) {
            return false;
        }
    }
}
