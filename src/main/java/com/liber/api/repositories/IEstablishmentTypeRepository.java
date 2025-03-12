package com.liber.api.repositories;

import com.liber.api.models.EstablishmentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEstablishmentTypeRepository extends JpaRepository<EstablishmentType, Integer> {

}
