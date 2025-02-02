package com.liber.api.services;

import com.liber.api.models.RolePermission;
import com.liber.api.repositories.IRolePermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class RolePermissionService {

    @Autowired
    private IRolePermissionRepository rolePermissionRepository;

    public ArrayList<RolePermission> getRolesPermissions () {
        return (ArrayList<RolePermission>) rolePermissionRepository.findAll();
    }

    public Optional<RolePermission> getRolePermissionById (int id) {
        return rolePermissionRepository.findById(id);
    }

    public RolePermission saveRolePermission (RolePermission rolePermission) {
        return rolePermissionRepository.save(rolePermission);
    }

    public RolePermission updateRolePermissionById (int id, RolePermission request) {
        Optional<RolePermission> optionalRolePermission = rolePermissionRepository.findById(id);

        if (optionalRolePermission.isPresent()) {
            RolePermission rolePermission = optionalRolePermission.get();
            rolePermission.setRole(request.getRole());
            rolePermission.setPermission(request.getPermission());
            return rolePermissionRepository.save(rolePermission);
        } else {
            throw new RuntimeException("Role Permission not found with id " + id);
        }
    }

    public Boolean deleteRolePermissionById (int id) {
        try {
            rolePermissionRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
