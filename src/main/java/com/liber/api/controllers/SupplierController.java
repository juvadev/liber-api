package com.liber.api.controllers;

import com.liber.api.models.Supplier;
import com.liber.api.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/suppliers")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @GetMapping
    public ArrayList<Supplier> getSuppliers () {
        return supplierService.getSuppliers();
    }

    @GetMapping("/{id}")
    public Optional<Supplier> getSupplierById (@PathVariable int id) {
        return supplierService.getSupplierById(id);
    }

    @PostMapping("/save")
    public Supplier saveSupplier (@RequestBody Supplier supplier) {
        return supplierService.saveSupplier(supplier);
    }

    @PutMapping("/update/{id}")
    public Supplier updateSupplierById (@PathVariable int id, @RequestBody Supplier supplier) {
        return supplierService.updateSupplierById(id, supplier);
    }

    @DeleteMapping("/delete/{id}")
    public  Boolean deleteSupplierById (@PathVariable int id) {
        return supplierService.deleteSupplierById(id);
    }
}
