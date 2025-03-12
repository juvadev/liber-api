package com.liber.api.repositories;

import com.liber.api.models.SaleDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISaleDetailsRepository extends JpaRepository<SaleDetails, Integer> {

}
