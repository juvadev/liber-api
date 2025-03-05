package com.liber.api.repositories;

import com.liber.api.models.PurchaseDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPurchaseDetailsRepository extends JpaRepository<PurchaseDetails, Integer> {
    
}
