package com.liber.api.services;

import com.liber.api.models.StockTransfer;
import com.liber.api.repositories.IStockTransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class StockTransferService {

    @Autowired
    private IStockTransferRepository stockTransferRepository;

    public ArrayList<StockTransfer> getStockTransfers () {
        return (ArrayList<StockTransfer>) stockTransferRepository.findAll();
    }

    public Optional<StockTransfer> getStockTransferById (int id) {
        return stockTransferRepository.findById(id);
    }

    public StockTransfer saveStockTransfer (StockTransfer stockTransfer) {
        return stockTransferRepository.save(stockTransfer);
    }

    public StockTransfer updateStockTransferById (int id, StockTransfer request) {
        Optional<StockTransfer> optionalStockTransfer = stockTransferRepository.findById(id);

        if (optionalStockTransfer.isPresent()) {
            StockTransfer stockTransfer = optionalStockTransfer.get();
            stockTransfer.setEstablishmentOrigin(request.getEstablishmentOrigin());
            stockTransfer.setEstablishmentDestination(request.getEstablishmentDestination());
            stockTransfer.setTransferDate(request.getTransferDate());
            stockTransfer.setProduct(request.getProduct());
            stockTransfer.setQuantity(request.getQuantity());
            return stockTransferRepository.save(stockTransfer);
        } else {
            throw new RuntimeException("Stock Transfer not found with id " + id);
        }
    }

    public Boolean deleteStockTransferById (int id) {
        try {
            stockTransferRepository.deleteById(id);
            return true;

        } catch (Exception e) {
            return false;
        }
    }
}
