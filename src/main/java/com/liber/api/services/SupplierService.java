package com.liber.api.services;

import com.liber.api.models.Supplier;
import com.liber.api.repositories.ISupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class SupplierService {

    @Autowired
    private ISupplierRepository supplierRepository;

    public ArrayList<Supplier> getSuppliers () {
        return (ArrayList<Supplier>) supplierRepository.findAll();
    }

    public Optional<Supplier> getSupplierById (int id) {
        return supplierRepository.findById(id);
    }

    public Supplier saveSupplier (Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    public Supplier updateSupplierById (int id, Supplier request) {
        Optional<Supplier> optionalSupplier = supplierRepository.findById(id);

        if (optionalSupplier.isPresent()) {
            Supplier supplier = optionalSupplier.get();
            supplier.setName(request.getName());
            supplier.setRuc(request.getRuc());
            supplier.setAddress(request.getAddress());
            supplier.setCity(request.getCity());
            supplier.setPhone(request.getPhone());
            supplier.setState(request.getState());
            return supplierRepository.save(supplier);
        } else {
            throw new RuntimeException("Supplier not found with id " + id);
        }
    }

    public Boolean deleteSupplierById (int id) {
        try {
            supplierRepository.deleteById(id);
            return true;

        } catch (Exception e) {
            return false;
        }
    }
}
