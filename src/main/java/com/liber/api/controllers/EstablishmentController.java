package com.liber.api.controllers;

import com.liber.api.models.Establishment;
import com.liber.api.services.EstablishmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/establishments")
public class EstablishmentController {

    @Autowired
    private EstablishmentService establishmentService;

    @GetMapping
    public ArrayList<Establishment> getEstablishments () {
        return this.establishmentService.getEstablishments();
    }

    @GetMapping("/{id}")
    public Optional<Establishment> getEstablishmentById (@PathVariable int id) {
        return this.establishmentService.getEstablishmentById(id);
    }

    @PostMapping("/save")
    public Establishment saveEstablishment (@RequestBody Establishment establishment) {
        return this.establishmentService.saveEstablishment(establishment);
    }

    @PutMapping("/update/{id}")
    public Establishment updateEstablishmentById (@PathVariable int id, @RequestBody Establishment request) {
        return this.establishmentService.updateEstablishmentById(id, request);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean deleteEstablishmentById (@PathVariable int id) {
        return this.establishmentService.deleteEstablishmentById(id);
    }
}
