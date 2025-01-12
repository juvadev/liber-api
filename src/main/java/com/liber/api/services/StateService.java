package com.liber.api.services;

import com.liber.api.models.State;
import com.liber.api.repositories.IStateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class StateService {

    @Autowired
    IStateRepository stateRepository;

    public ArrayList<State> getStates () {
        return (ArrayList<State>)  stateRepository.findAll();
    }

    public Optional<State> getStateById (int id) {
        return stateRepository.findById(id);
    }

    public State saveState (State state) {
        return stateRepository.save(state);
    }

    public State updateStateById (int id, State request) {
        Optional<State> optionalState = stateRepository.findById(id);

        if (optionalState.isPresent()) {
            State state = optionalState.get();
            state.setNombre(request.getNombre());
            return stateRepository.save(state);
        } else {
            throw new RuntimeException("State not found with id " + id);
        }
    }

    public Boolean deleteStateById (int id) {
        try {
            stateRepository.deleteById(id);
            return true;

        } catch (Exception e) {
            return false;
        }
    }
}
