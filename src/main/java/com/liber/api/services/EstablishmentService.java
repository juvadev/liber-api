package com.liber.api.services;

import com.liber.api.models.Establishment;
import com.liber.api.repositories.IEstablishmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class EstablishmentService {

    @Autowired
    private IEstablishmentRepository establishmentRepository;

    public ArrayList<Establishment> getEstablishments () {
        return (ArrayList<Establishment>) establishmentRepository.findAll();
    }

    public Optional<Establishment> getEstablishmentById (int id) {
        return establishmentRepository.findById(id);
    }

    public Establishment saveEstablishment (Establishment establishment) {
        return establishmentRepository.save(establishment);
    }

    public Establishment updateEstablishmentById (int id, Establishment request) {
        Optional<Establishment> optionalEstablishment = establishmentRepository.findById(id);

        if (optionalEstablishment.isPresent()) {
            Establishment establishment = optionalEstablishment.get();
            establishment.setName(request.getName());
            establishment.setAddress(request.getAddress());
            establishment.setCity(request.getCity());
            establishment.setState(request.getState());
            establishment.setEstablishmentType(request.getEstablishmentType());
            return establishmentRepository.save(establishment);
        } else {
            throw new RuntimeException("Establishment not found with id " + id);
        }
    }

    public Boolean deleteEstablishmentById (int id) {
        try {
            establishmentRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
