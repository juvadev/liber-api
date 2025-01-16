package com.liber.api.controllers;

import com.liber.api.models.EstablishmentType;
import com.liber.api.services.EstablishmentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/establishment_types")
public class EstablishmentTypeController {

    @Autowired
    private EstablishmentTypeService establishmentTypeService;

    @GetMapping
    public ArrayList<EstablishmentType> getEstablishmentTypes () {
        return this.establishmentTypeService.getEstablishmentTypes();
    }

    @GetMapping("/{id}")
    public Optional<EstablishmentType> getEstablishmentTypeById (@PathVariable int id) {
        return this.establishmentTypeService.getEstablishmentTypeById(id);
    }

    @PostMapping("/save")
    public EstablishmentType saveEstablishmentType (@RequestBody EstablishmentType establishmentType) {
        return this.establishmentTypeService.saveEstablishmentType(establishmentType);
    }

    @PutMapping("/update/{id}")
    public EstablishmentType updateEstablishmentTypeById (@PathVariable int id, @RequestBody EstablishmentType request) {
        return this.establishmentTypeService.updateEstablishmentType(id, request);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean deleteEstablishmentTypeById (@PathVariable int id) {
        return this.establishmentTypeService.deleteEstablishmentTypeById(id);
    }
}
