package com.liber.api.controllers;

import com.liber.api.models.State;
import com.liber.api.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/states")
public class StateController {

    @Autowired
    private StateService stateService;

    @GetMapping
    public ArrayList<State> getStates() {
        return this.stateService.getStates();
    }

    @GetMapping("/{id}")
    public Optional<State> getStateById(@PathVariable int id) {
        return this.stateService.getStateById(id);
    }

    @PostMapping("/save")
    public State saveState(@RequestBody State state) {
        return this.stateService.saveState(state);
    }

    @PutMapping("/update/{id}")
    public State updateStateById(@PathVariable int id, @RequestBody State request) {
        return this.stateService.updateStateById(id, request);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean deleteStateById(@PathVariable int id) {
        return this.stateService.deleteStateById(id);
    }
}
