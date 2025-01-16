package com.liber.api.services;

import com.liber.api.models.EstablishmentType;
import com.liber.api.repositories.IEstablishmentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class EstablishmentTypeService {
    @Autowired
    private IEstablishmentTypeRepository establishmentTypeRepository;

    public ArrayList<EstablishmentType> getEstablishmentTypes () {
        return (ArrayList<EstablishmentType>) establishmentTypeRepository.findAll();
    }

    public Optional<EstablishmentType> getEstablishmentTypeById (int id) {
        return establishmentTypeRepository.findById(id);
    }

    public EstablishmentType saveEstablishmentType (EstablishmentType establishmentType) {
        return establishmentTypeRepository.save(establishmentType);
    }

    public EstablishmentType updateEstablishmentType (int id, EstablishmentType request) {
        Optional<EstablishmentType> optionalEstablishmentType = establishmentTypeRepository.findById(id);

        if (optionalEstablishmentType.isPresent())  {
            EstablishmentType establishmentType = optionalEstablishmentType.get();
            establishmentType.setName(request.getName());
            establishmentType.setState(request.getState());
            return establishmentTypeRepository.save(establishmentType);
        } else {
            throw new RuntimeException("EstablishmentType not found with id " + id);
        }
    }

    public Boolean deleteEstablishmentTypeById (int id) {
        try {
            establishmentTypeRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
