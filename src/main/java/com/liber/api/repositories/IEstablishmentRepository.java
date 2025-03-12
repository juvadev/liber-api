package com.liber.api.repositories;

import com.liber.api.models.Establishment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEstablishmentRepository extends JpaRepository<Establishment, Integer> {
}
