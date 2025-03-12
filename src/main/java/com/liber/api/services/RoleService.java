package com.liber.api.services;

import com.liber.api.models.Role;
import com.liber.api.repositories.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class RoleService {
    @Autowired
    IRoleRepository roleRepository;

    public ArrayList<Role> getRoles () {
        return (ArrayList<Role>) roleRepository.findAll();
    }

    public Optional<Role> getRoleById (int id) {
        return roleRepository.findById(id);
    }

    public Role saveRole (Role role) {
        return roleRepository.save(role);
    }

    public Role updateRoleById (int id, Role request) {
        Optional<Role> optionalRole = roleRepository.findById(id);

        if (optionalRole.isPresent()) {
            Role role = optionalRole.get();
            role.setName(request.getName());
            role.setDescription(request.getDescription());
            role.setState(request.getState());
            return roleRepository.save(role);
        } else {
            throw new RuntimeException("Role not found with id " + id);
        }
    }

    public Boolean deleteRolById (int id) {
        try {
            roleRepository.deleteById(id);
            return true;

        } catch (Exception e) {
            return false;
        }
    }
}
