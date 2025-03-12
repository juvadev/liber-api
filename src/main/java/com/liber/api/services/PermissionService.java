package com.liber.api.services;

import com.liber.api.models.Permission;
import com.liber.api.repositories.IPermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class PermissionService {
    @Autowired
    private IPermissionRepository permissionRepository;

    public ArrayList<Permission> getPermissions() {
        return (ArrayList<Permission>) permissionRepository.findAll();
    }

    public Optional<Permission> getPermissionById (int id) {
        return permissionRepository.findById(id);
    }

    public Permission savePermission (Permission permission) {
        return permissionRepository.save(permission);
    }

    public Permission updatePermissionById (int id, Permission request) {
        Optional<Permission> optionalPermission = permissionRepository.findById(id);

        if (optionalPermission.isPresent()) {
            Permission permission = optionalPermission.get();
            permission.setName(request.getName());
            permission.setDescription(request.getDescription());
            permission.setState(request.getState());
            return permissionRepository.save(permission);

        } else {
            throw new RuntimeException("Permission not found with id " + id);
        }
    }

    public Boolean deletePermissionById (int id) {
        try {
            permissionRepository.deleteById(id);
            return true;

        } catch (Exception e) {
            return false;
        }
    }
}
