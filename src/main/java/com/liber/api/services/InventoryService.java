package com.liber.api.services;

import com.liber.api.models.Inventory;
import com.liber.api.repositories.IInventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class InventoryService {
    @Autowired
    private IInventoryRepository inventoryRepository;

    public ArrayList<Inventory> getAllInventories () {
        return  (ArrayList<Inventory>) inventoryRepository.findAll();
    }

    public Optional<Inventory> getInventoryById (int id) {
        return inventoryRepository.findById(id);
    }

    public Inventory saveInventory (Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    public Inventory updateInventoryById (int id, Inventory request) {
        Optional<Inventory> optionalInventory = inventoryRepository.findById(id);

        if (optionalInventory.isPresent()) {
            Inventory inventory = optionalInventory.get();
            inventory.setEstablishment(request.getEstablishment());
            inventory.setProduct(request.getProduct());
            inventory.setSection(request.getSection());
            inventory.setStock(request.getStock());
            inventory.setMinStock(request.getMinStock());
            inventory.setLocationRef(request.getLocationRef());
            return inventoryRepository.save(inventory);
        } else {
            throw new RuntimeException("Inventory not found with id " + id);
        }
    }

    public Boolean deleteInventoryById (int id) {
        try {
            inventoryRepository.deleteById(id);
            return true;

        } catch (Exception e) {
            return false;
        }
    }
}
