package com.liber.api.controllers;

import com.liber.api.models.Inventory;
import com.liber.api.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;

    @GetMapping
    public ArrayList<Inventory> getAllInventories () {
        return inventoryService.getAllInventories();
    }

    @GetMapping("/{id}")
    public Optional<Inventory> getInventoryById (@PathVariable int id) {
        return inventoryService.getInventoryById(id);
    }

    @PostMapping("/save")
    public Inventory saveInventory (@RequestBody Inventory inventory) {
        return inventoryService.saveInventory(inventory);
    }

    @PutMapping("/update/{id}")
    public Inventory updateInventoryById (@PathVariable int id, @RequestBody Inventory request) {
        return inventoryService.updateInventoryById(id, request);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean deleteInventoryById (@PathVariable int id) {
        return inventoryService.deleteInventoryById(id);
    }
}
