package com.liber.api.repositories;

import com.liber.api.models.StockTransfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStockTransferRepository extends JpaRepository<StockTransfer, Integer> {
}
